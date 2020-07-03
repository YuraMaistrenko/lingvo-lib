/*
 * Читаем из файла и формируем список, одна запись - предложения.
 */
package text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import text.Offering;

/**
 * Чтение исследуемого текста из файла и построение ArrayList<String> String
 * text; а также ArrayList<Offering(ArrayList<word>)> - это предложение
 * построенное на основе  <word>
 *
 * @author Yura Maistrenko
 */
public final class ReadFromFile {

    private final ArrayList<String> listFromFile = new ArrayList<>();
    private String text = "";
    private ArrayList<Offering> offering;

    /**
     *
     * @param val - Имя файла, в котором находится ТЕКСТ
     */
    public ReadFromFile(String val) {
        String testStr;
        offering = new ArrayList<>();
        //     Читаем из файла текст.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(val)))) {//windows-1251"))) {
            String str = null;
            while ((str = in.readLine()) != null) {
                text += str;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла " + val);
        }
        toketSentence();
    }

    /**
     * Разбиваем текст на предложения.
     */
    protected void toketSentence() {
        java.util.StringTokenizer token = new java.util.StringTokenizer("");

        try {
            token = new java.util.StringTokenizer(this.text, ".?!");
            while (token.hasMoreTokens()) {
                String str = (String) token.nextElement();
                listFromFile.add(str);
                Offering OFRNG = new Offering(str);
                OFRNG.buldListFromString();
                boolean add = offering.add(OFRNG);   //new Offering(str));
            }
        } catch (Exception e) {
            System.out.println("Ошибка при разделении на предложения   " + e.toString());
        }

    }

    /**
     * Возвращается список-предложений (String ) из файла
     *
     * @return
     */
    public ArrayList<String> getListSentntence() {

        //       System.out.println("Текст разбит на предложения и размещен в List = "+ this.listFromFile.size()+" предложений ");
        return this.listFromFile;
    }

    /**
     * Возвращается список-предложений (Offering ) из файла Offering - это
     * ArrayList<word>
     *
     * @return
     */
    public ArrayList<Offering> getOffering() {
        return offering;
    }

}
