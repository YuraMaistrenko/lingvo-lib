/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import text.Offering;
import word.PropertieWord;
import word.word;

/**
 *
 * @author progroup
 */
public class Rule1N {

    private word[] pairs;
    Offering offering;

    public Rule1N(Offering valOffering) {
        this.offering = valOffering;
    }

    public boolean test1(word[] pairs) {
        boolean result = false;
        //for (word w : this.offering.getSentence()) {

            for (PropertieWord pr_first1 : pairs[0].getAllProperties()) {
                for (PropertieWord pr_second1 : pairs[1].getAllProperties()) {
                    
                    if (pr_second1.getLanguagePart().equalsIgnoreCase("дієслово")  ) {
                        result = false;
                        return result;
                    }
                    
                }
            }
        //}
        return result;
    }

}
