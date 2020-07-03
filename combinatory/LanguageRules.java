/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import word.PropertieWord;
import word.word;

/**
 *
 * @author progroup
 */
public class LanguageRules implements ILanguageRules {

    public LanguageRules() {

    }

    /**
     *
     * @param s1
     * @param s2
     * @return
     */
    public int Determinant(word s1, word s2) {
        int result = 0;
        String str = "";
        for (int i = 0; i < LanguageRulesPair.length; i++) { 
            //s1.getOnePropertie(0).getCm()
            if ((s1.getWord() + "-" + s2.getWord()).equals(LanguageRulesPair[i])) {
                result = i;
            }
        }
        return result;
    }

    /**
     * 
     */
    private void initLanguageRules() {

    }
    //  private 
}
