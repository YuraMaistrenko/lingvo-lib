/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combinatory;

import static combinatory.ILanguageRules.IPairsWord;
import word.PropertieWord;
import word.word;

/**
 *
 * @author progroup
 */
public class DefinePairWord {

    private word first;
    private word second;
    private word third;
    private boolean test = false;

    /**
     *
     * @param val_first
     * @param val_second
     */
    public DefinePairWord(word val_first, word val_second) {
        int i = 0;
        if (val_first.getAllProperties() != null) {
            this.first = val_first;
            i++;
        }
        if (val_second.getAllProperties() != null) {
            this.second = val_second;
            i++;
        }
        if (i == 2) {
            this.test = true;
        }

    }
    
       public DefinePairWord(word val_first, word val_second,word val_third) {
        int i = 0;
        if (val_first.getAllProperties() != null) {
            this.first = val_first;
            i++;
        }
        if (val_second.getAllProperties() != null) {
            this.second = val_second;
            i++;
        }
        if (val_third.getAllProperties() != null) {
            this.third = val_third;
            i++;
        }
        
        if (i == 3) {
            this.test = true;
        }

    }

    /**
     * Определение пары
     * @return 
     */
    public word[] definePair() {
        String pair = "";
        word results[] = {null, null}; //{(new word("")), (new word("")) };
        if (test) {
            this.first.getAllProperties().size();
            for (PropertieWord pr_first : this.first.getAllProperties()) {
                for (PropertieWord pr_second : this.second.getAllProperties()) {
                    pair = pr_first.getLanguagePart() + "-" + pr_second.getLanguagePart();
                    for (String str : IPairsWord) {
                        if (str.equalsIgnoreCase(pair)) {
                            results[0] = this.first;
                            results[1] = this.second;
                            return results;
                            //  System.out.println(this.first.getWord() + " - " + this.second.getWord() + "  " + str);
                        }
                    }
                }
            }
        }
        return results;

    }

}
