/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * word слово со своими свойствами ArrayList<PropertieWord>
 * IProperties массивы свойств
 *
 * @author yprog
 */
public class word implements IProperties, Serializable {

    private final String some_word;
    private ArrayList<PropertieWord> properties;
    private String Znak;
    private int Num;
    private int current_properties;
    //  private PropertieWord some_properties = null;

    public word(String val) {
        this.some_word = testPunctuationMarks(val.replace("\"", ""));//val);
        properties = new ArrayList<>();
    }

    public String getWord() {
        return some_word;
    }

    /**
     * Возвращает все свойста слова или NULL
     *
     * @return
     */
    public ArrayList<PropertieWord> getAllProperties() {
        return properties;
    }

    /**
     * Устанавливает все свойства слова или NUL
     *
     * @param properties
     */
    public void setProperties(ArrayList<PropertieWord> properties) {
        this.properties = properties;
        //    System.out.println("Установили свойства слова "+ this.getWord());
    }

    /**
     * Возвращает ОДНО свойство слова или NULL
     *
     * @return
     */
    public void addOnePropertie(PropertieWord oneProperties) {
        //  this.some_properties = some_properties;
        this.properties.add(oneProperties);
        this.current_properties = oneProperties.getColumn();
    }

    /**
     * Возвращает ОДНО свойство слова или NULL
     *
     * @return
     */
    public PropertieWord getOnePropertie(int val) {
        return this.properties.get(val);
    }

    /**
     * Проверяем есть ли в слова знак препинания Если есть то разделяем слово
     * пишем в name, а для знак препинания создадим объект Znak
     */
    private String testPunctuationMarks(String val) {
        String str = val;
        for (String s : PunctuationMarks) {
            if (val.endsWith(s) && val.length() > 1) {
                str = val.replace(s, "");
                this.Znak = s;
                break;
            }
        }
        str = str.replace("’", "'");
        return str;
    }

    /**
     *
     * @return знак препинания
     */
    public String getZnak() {
        return Znak;
    }

    /**
     * Это как бы текущая характеристика слова из списка
     * ArrayList<PropertieWord>
     * Возвращает номер столбца в базе
     *
     * @return
     */
    public int getCurrent_properties() {
        return current_properties;
    }

    /**
     * Устанавливает номер столбца в базе.
     *
     * @param current_properties
     */
    public void setCurrent_properties(int current_properties) {
        this.current_properties = current_properties;
    }

    public boolean equals(word w) {
        boolean result = false;
        if (this.some_word.toLowerCase().equals(w.some_word.toLowerCase())) {
            result = true;
        }
        return result;
    }
/**
 *  Сравнение двух слов
 * @param w
 * @return 
 */
    public boolean compare(word w) {
        boolean res = false;        
        if ( equals(w) && this.properties.contains(w.getAllProperties())) {
            res = true;
        }
        return res;
    }
/**
 * Возвратить Номер слова в предложении
 * @return Номер слова в предложении
 */
    public int getNum() {
        return Num;
    }
/**
 *  Установить  Номер слова в предложении
 * @param Num  Номер слова в предложении
 */
    public void setNum(int Num) {
        this.Num = Num;
    }

}
