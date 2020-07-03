package text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import text.Offering;
import utilities.CreateMapFromDB;
import word.IProperties;

import word.PropertieWord;
import word.word;

/**
 * Определения свойств слов
 *
 * @author progroup
 */
public class DefinitionOfWordProperties implements IProperties {   //, Serializable {

    private ArrayList<Offering> sentenceListWord = null;  //    Предложения
    private Map<String, ArrayList<PropertieWord>> hashMap = null;   // Слова из базы

    public DefinitionOfWordProperties() {
        hashMap = new HashMap<>();
    }

    /**
     * Определяем свойства слов в предложении
     *
     * @param hashMap база слов сс свойствами
     * @param sentence предложение для определения свойств
     */
    public DefinitionOfWordProperties(Map<String, ArrayList<PropertieWord>> hashMap,
            ArrayList<Offering> sentence) {
        this.sentenceListWord = sentence;
        int j = 0;
        PropertieWord pwM = null;
        ArrayList<PropertieWord> apw = new ArrayList<>();
        apw.add(pwM);
        for (Offering offering : sentenceListWord) {
            for (word slovo : offering.getSentence()) {
                slovo.setProperties(hashMap.get(slovo.getWord().toLowerCase()));
                offering.getSentence().set(j, slovo);
                j++;
            }
            j = 0;
            
        }
    }

    /**
     * Второй конструктор
     */
    public DefinitionOfWordProperties(ArrayList<Offering> sentence) {
        this.sentenceListWord = sentence;
        
    }

    /**
     *
     * @return Предложения с заполненными свойствами
     *
     */
    public ArrayList<Offering> getSentenceListWord() {
        //   this.sentenceListWord.get(0).getSentence().get(0).getAllProperties()   Слово со всеми свойствами
        return this.sentenceListWord;
    }
    
    /**
     * Возвращает предложение val
     * @param val
     * @return 
     */
    public ArrayList<word> getWordOffering(int val) {
        ArrayList<word> words = this.sentenceListWord.get(val).getSentence();
        return words;
    }
 /**
  *   Возвращает заданное слово numWord из предложения  numSentense
  * @param numSentense
  * @param numWord
  * @return 
  */   
    public word getWordFromOffering(int numSentense, int numWord) {
        word slovo = this.sentenceListWord.get(numSentense).getSentence().get(numWord);        
        return slovo;
    }

    /**
     * Отобразим HashMap
     */
    public void toStringBase() {
        Set<Map.Entry<String, ArrayList<PropertieWord>>> set = hashMap.entrySet();
        ArrayList<PropertieWord> pries = null;
        for (Map.Entry<String, ArrayList<PropertieWord>> me : set) {
            System.out.print(me.getKey() + ": ");
            pries = me.getValue();
            if (pries != null) {
                for (PropertieWord pw : pries) {
                    System.out.print(" - {  " + pw.getLanguagePart() + " ,  " + padezhi[pw.getG()]
                            + ",  " + chislo[pw.getNumber()] + " " + rod[pw.getRhode()] + "}");
                }
            }
            System.out.print("\n");
        }
    }
    
    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        //                      ПЕЧАТЬ РЕЗУЛЬТАТОВ       
        for (Offering offering : sentenceListWord) {
            //         System.out.println();
            for (word slovo : offering.getSentence()) {
                res.append(slovo.getWord());
                res.append(" - (Знак = ");
                res.append(slovo.getZnak());
                res.append(")\n");
                //           System.out.println(slovo.getWord() + "  ");
                if (slovo.getAllProperties() != null) {
                    ArrayList<PropertieWord> pr = slovo.getAllProperties();
                    //       if(!pr.isEmpty() ){
                    for (PropertieWord pw : pr) {
                        res.append(" - {  " + pw.getLanguagePart() + ",  " + padezhi[pw.getG()]
                                + ", " + chislo[pw.getNumber()] + ", " + rod[pw.getRhode()] + ", " + vremja[pw.getTime()] + ", "
                                + f_glagol[pw.getTimeVerb()] + ", " + lizo[pw.getLizo()] + ", " + chlen_predlozh[pw.getCh()] + "}");
                        /*         System.out.print(" - {  " + pw.getLanguagePart() + " ,  " + padezhi[pw.getDecline()]
                                + ",  " + chislo[pw.getNumber()] + " " + rod[pw.getRhode()] + "}");*/
                        //}
                    }
                }
                //           System.out.println();
                res.append("\n");
            }
        }
        return res.toString();
    }
    
}
