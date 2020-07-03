/*
 * To change this license header, choose License Headers in
Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text;

//import combinatory.PairWord;
import java.util.ArrayList;
import word.CombinationOfWords;
import word.word;

/**
 *
 * @author progroup
 */
public final class Offering {

    private final String offeringText;
    private final ArrayList<word> sentence;     //  Слова данного предложения
    private ArrayList<word[]> pairWord;   //  Словосочетание данного предложения
    private ArrayList<CombinationOfWords> pairWords;
   // private int size = 0;

    public Offering(String text) {
        sentence = new ArrayList<>();
        pairWord = new ArrayList<>();
        pairWords = new ArrayList<>();
        this.offeringText = text;
        //    buldListFromString();

        //      buildPairWord();
    }

    /**
     * Построение из предложения текста предложения вида ArrayList word
     *
     * @return sentence
     */
    public ArrayList<word> buldListFromString() {
        int i = 0;
        java.util.StringTokenizer token = new java.util.StringTokenizer("");
        StringBuilder str = new StringBuilder();
        try {
            token = new java.util.StringTokenizer(this.offeringText, " ");
//,:- ; ");
            while (token.hasMoreTokens()) {
                word w = new word((String) token.nextElement());
                w.setNum(i++);
                sentence.add(w);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при разделении на предложения   "
                    + e.toString());
        }
        return sentence;
    }

    public ArrayList<word> getSentence() {
        return sentence;
    }

    @Override
    public String toString() {
        String stroka = " ";
        stroka = sentence.stream().map((str)
                -> str.getWord() + " ").reduce(stroka, String::concat);
        return stroka;
    }

    public String getOfferingText() {
        return offeringText;
    }

    /**
     * Установка всех словосочетаний предложения.
     *
     * @param pairWord
     */
    public void setPairWord(ArrayList<word[]> pairWord) {
        this.pairWord = pairWord;
//               System.out.println("Кол-в словосочетаний == " + pairWord.size());
 
    }

    /**
     * Добавляет пару word[] в ArrayList word[] pairWord
     *
     * @param valWords Словосочетание из предложения
     */
    public void setPairWord(word[] valWords) {
        this.pairWord.add(valWords);
 //       this.pairWords.add(new CombinationOfWords(valWords));
    }

    /**
     * Возврат всех словосочетаний предложения.
     *
     * @return
     */
    public ArrayList<word[]> getPairWord() {
        return pairWord;
    }

    public int getSize() {
        return this.sentence.size();        
    }

    public ArrayList<CombinationOfWords> getPairWordsAll() {
        return pairWords;
    }

    public void setPairWordsAll(ArrayList<CombinationOfWords> pairWords) {
        this.pairWords = pairWords;
                      // System.out.println("Кол-в словосочетаний pairWords == " + pairWords.size());
    }

}
