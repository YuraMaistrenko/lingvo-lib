/*
 *     ArrayList<String> rowTable  это строка из таблицы (String) <NameTable>
 */
package utilities;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import static word.IProperties.table;
import word.PropertieWord;

/**
 * Формируем набор слов из базы и формируем свойства этих слов. Используется
 * один раз при включении.
 *
 * @author progroup
 */
public class CreateMapFromDB implements Serializable{

    private static final long serialVersionUID = 1L;

    private final String URL;
    private final String USER;
    private final String PASSWORD;

    private String NameTable;
    private Connection connection;
private DataSource dataSource;
    private Map<String, ArrayList<PropertieWord>> hashMap = new HashMap<>();

    public CreateMapFromDB(String URL, String USER, String PASSWORD) throws InstantiationException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
        try {
           // com.mysql.jdbc.exceptions.jdbc4.CommunicationsException
           Class.forName("com.mysql.jdbc.Driver");
        //   Object newInstance = Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
            for (String str : table) {
                buildHashMapFromDb(str);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CreateMapFromDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CreateMapFromDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
    /**
     * Из базы сформируем слово со свойствами согласно ТАБЛИЦ IProperties.
     *
     * @param valTable
     * @throws SQLException
     */
    public void buildHashMapFromDb(String valTable) throws SQLException {
        ArrayList<PropertieWord> properties, properties2;
        Statement st = null;
        PreparedStatement prst = null;
        ResultSet rs;//= null;
        prst = connection.prepareStatement("SELECT * FROM " + valTable);
        rs = prst.executeQuery();
        int count = 0, count1 = 0;
        while (rs.next()) {
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                String str = rs.getString(i);
                if (!str.equals("<>")) {
                    count++;
                    PropertieWord prw = new PropertieWord(valTable, i);
                    properties = new ArrayList<>();
                    properties.add(prw);
                    ArrayList<String> Records = tokenFields(str);                   
                    for (String fields : Records) {
                        count1++;
                        if (hashMap.containsKey(fields.toLowerCase().trim())) {
                            properties.addAll(hashMap.get(fields.toLowerCase().trim()));
                        }
                        hashMap.put(fields.toLowerCase().trim(), properties);
                    }
                }      //   Читаем из таблицы +NameTable+  и формируем  строку - РЯД. Слова разделены  символом #

            }
        }
        System.out.println(" Из таблицы " + valTable + " Число слов (count = " + count + ") число действительных (count1 =  " + count1 + "). Разница "
                + (count1 - count) + ";");
    }

    /**
     * Проверяется поле в БАЗЕ не состоит ли поле из нескольких слов
     *
     * @param valField
     * @return
     */
    protected ArrayList<String> tokenFields(String valField) {
        ArrayList<String> field = new ArrayList<>();
        java.util.StringTokenizer token = new java.util.StringTokenizer(valField, ",");
        while (token.hasMoreTokens()) {
            field.add((String) token.nextElement());
        }
        return field;
    }

    /**
     *
     * @return Map<String, ArrayList<PropertieWord>>
     */
    public Map<String, ArrayList<PropertieWord>> getHashMap() {
        System.out.println(" Размер hashMap = " + hashMap.size());
        return hashMap;
    }

}
