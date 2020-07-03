/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import java.util.ArrayList;
import text.Offering;
import word.CombinationOfWords;
import word.PropertieWord;
import word.word;

/**
 *
 * @author progroup
 */
public class RulesN {

    private Offering offering;

    public RulesN(Offering offering) {
        this.offering = offering;

    }

    public Offering getOffering() {
        return offering;
    }

    public void setOffering(Offering offering) {
        this.offering = offering;
    }

    /**
     * Метод на проверку відмінник та число співпадають
     *
     * @param pr1 часть речи
     * @param pr2 часть речи
     * @return
     */
    protected boolean m1(String lang1, String lang2) {
        boolean result = false;

        for (word[] w : offering.getPairWord()) {

            for (PropertieWord pr1 : w[0].getAllProperties()) {
                for (PropertieWord pr2 : w[1].getAllProperties()) {

                    if (pr1.getLanguagePart().equalsIgnoreCase(lang1)
                            && pr2.getLanguagePart().equalsIgnoreCase(lang2)) {
                        if (pr1.getG() == pr2.getG()
                                && pr1.getNumber() == pr2.getNumber()
                                && pr1.getRhode() == pr2.getRhode()) {

                            result = true;
                        }
                    }
//*******************************************************************************************
                }
            }
            if (result) {
                System.out.println(w[0].getWord() + " №" + w[0].getNum() + " & "
                        + w[1].getWord() + " №" + w[1].getNum());
            }
        }

        return result;
    }

    /**
     * Метод на проверку відмінки співпадають
     *
     * @param pr1 часть речи
     * @param pr2 часть речи
     * @return
     */
    protected boolean m2(String lang1, String lang2) {
        boolean result = false;
        for (word[] w : offering.getPairWord()) {

            for (PropertieWord pr1 : w[0].getAllProperties()) {
                for (PropertieWord pr2 : w[1].getAllProperties()) {
                    if (pr1.getLanguagePart().equalsIgnoreCase(lang1)
                            && pr2.getLanguagePart().equalsIgnoreCase(lang2)) {
                        if (pr1.getG() == pr2.getG()) {

                            result = true;
                        }
                    }

                }
            }
            if (result) {
                System.out.println(w[0].getWord() + " №" + w[0].getNum() + " & "
                        + w[1].getWord() + " №" + w[1].getNum());
            }
        }
        return result;
    }

    /**
     * Метод на проверку не в називному відмінку слово lang2 але відмінок та
     * число співпадають
     *
     * @param lang1 часть речи
     * @param lang2 часть речи
     * @return
     */
    protected boolean m3(String lang1, String lang2) {
        boolean result = false;
        for (word[] w : offering.getPairWord()) {

            for (PropertieWord pr1 : w[0].getAllProperties()) {
                for (PropertieWord pr2 : w[1].getAllProperties()) {
                    if (pr1.getLanguagePart().equalsIgnoreCase(lang1)
                            && pr2.getLanguagePart().equalsIgnoreCase(lang2)) {
                        if (pr2.getG() != 1
                                && pr1.getG() == pr2.getG()
                                && pr1.getNumber() == pr2.getNumber()) {

                            result = true;
                        }
                    }

                }
                if (result) {
                    System.out.println(w[0].getWord() + " №" + w[0].getNum() + " & "
                            + w[1].getWord() + " №" + w[1].getNum());
                }
            }
        }

        return result;
    }

    /**
     * Метод на проверку відмінки співпадають
     *
     * @param lang1, lang2 часть речи
     * @return
     */
    protected boolean m4(String lang1, String lang2) {
        boolean result = false;

        return result;
    }

//*********************************************************************************    
    /**
     *
     */
    public void test_rule() {
        m11("прикметник", "іменник");
        m11("числівник", "іменник");
        m11("займенник", "іменник");
        m11("дієприкметник", "іменник");
        //*********************************
        m12("дієслово", "іменник");
 
    }

    /**
     * Метод на проверку відмінник та число співпадають
     *
     * @param lang1 часть речи
     * @param lang2 часть речи
     * @return
     */
    protected Offering m11(String lang1, String lang2) {
        boolean result = false;
        int res = 0;
        boolean coma = false;
        for (CombinationOfWords cow : this.offering.getPairWordsAll()) {
            if (notVerb(cow)) {
                cow.setStatus(0);
                continue;
            }

            //   if(coma) continue;
            //     if (imennikKoma((cow)) {
            // cow.setStatus(1);
            for (PropertieWord pr1 : cow.getWords()[0].getAllProperties()) {
                for (PropertieWord pr2 : cow.getWords()[1].getAllProperties()) {

                    if (pr1.getLanguagePart().equalsIgnoreCase(lang1)
                            && pr2.getLanguagePart().equalsIgnoreCase(lang2)) {
                        if (pr1.getG() == pr2.getG() && pr1.getNumber() == pr2.getNumber()
                                && pr1.getRhode() == pr2.getRhode()) {
                            cow.setStatus(cow.getStatus() + 1);
                            result = true;
                        }
                        System.out.println(cow.getWords()[0].getWord() + " и " + cow.getWords()[1].getWord() + " status " + cow.getStatus());
                    }
                    /*
                    if(cow.getWords()[1].getZnak().equalsIgnoreCase(",")){
                coma = true;
                }
                     */
//*******************************************************************************************
                }
            }
            // }
        }
        return this.offering;
    }

    /**
     * Метод на проверку відмінник та число співпадають
     *
     * @param lang1 часть речи дієслово
     * @param lang2 часть речи іменник не в називному відмінку
     * @return
     */
    protected Offering m12(String lang1, String lang2) {
        boolean result = false;
        int res = 0;
        for (CombinationOfWords cow : this.offering.getPairWordsAll()) {
            for (PropertieWord pr1 : cow.getWords()[0].getAllProperties()) {
                for (PropertieWord pr2 : cow.getWords()[1].getAllProperties()) {

                    if (pr1.getLanguagePart().equalsIgnoreCase(lang1)
                            && pr2.getLanguagePart().equalsIgnoreCase(lang2)) {
                        if (pr2.getG() != 1 ) {

                            cow.setStatus(cow.getStatus() + 1);
                            result = true;
                        }
                    }
//*******************************************************************************************
                }
            }

        }

        return this.offering;
    }

    /**
     *
     * @param cow
     * @return
     */
    protected boolean f1(CombinationOfWords cow) {
        boolean result = false;

        return result;
    }

//*****************************************************************************************
    /**
     * Проверяем есть ли межлу парой слов глагол
     *
     * @param cow
     * @return
     */
    protected boolean notVerb(CombinationOfWords cow) {
        boolean result = false;
        word[] tmp = cow.getWords();
        for (word w : this.offering.getSentence()) {
            if (w.getAllProperties() != null) {
                for (PropertieWord pr : w.getAllProperties()) {
                    if (tmp[0].getNum() < w.getNum() && tmp[1].getNum() > w.getNum()
                            && pr.getLanguagePart().equalsIgnoreCase("дієслово")) {
                        result = true;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    protected boolean notSpoluchnik(CombinationOfWords cow) {
        boolean result = false;
        word[] tmp = cow.getWords();
        for (word w : this.offering.getSentence()) {
            if (w.getAllProperties() != null) {
                for (PropertieWord pr : w.getAllProperties()) {
                    if ((w.getNum() - tmp[0].getNum() == 1) && (tmp[1].getNum() - w.getNum() == 1)
                            && pr.getLanguagePart().equalsIgnoreCase("сполучник")) {
                        result = true;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    protected boolean imennikKoma(CombinationOfWords cow) {
        boolean result = false;
        int i = 0;

        for (word w : cow.getWords()) {

            if (w.getOnePropertie(i++).getLanguagePart().equalsIgnoreCase("іменник")
                    && w.getZnak().equalsIgnoreCase(",")) {
                result = true;
                return result;
            }
        }

        return result;
    }

//*****************************************************************************************    
}
