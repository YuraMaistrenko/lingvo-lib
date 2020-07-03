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
public class Rule1 {

    private word[] pairs;

    public Rule1(word[] pairs) {
        this.pairs = pairs;
    }

    public boolean test_rule1(Offering val_Offering) {
        boolean result = false;
        word w1 = this.pairs[0];
        word w2 = this.pairs[1];
        int i = 0, j = 0, k = 0;
        //           System.out.println("Rule1 = "+w1.getWord()+" - "+ w2.getWord());
        for (PropertieWord pr_first1 : w1.getAllProperties()) {
            k = 0;
            i++;
            for (PropertieWord pr_second1 : w2.getAllProperties()) {
                k++;
                /**
                 * если второе слово из пары дієслово то прекращаем поиск
                 */
                if (pr_second1.getLanguagePart().equalsIgnoreCase("дієслово")) {
                    result = false;
                    return result;
                }
                
                if(pr_second1.getLanguagePart().equalsIgnoreCase("сполучник") && 
                        pr_second1.getLanguagePart().equalsIgnoreCase("іменник")){
                    if (pr_first1.getG() == pr_second1.getG()
                            && pr_first1.getNumber() == pr_second1.getNumber()
                            && pr_first1.getRhode() == pr_second1.getRhode()) {

                        System.out.println(pairs[0].getWord() + " №" + pairs[0].getNum() + " & "
                                + pairs[1].getWord() + " №" + pairs[1].getNum() + "  - ПРАВИЛО  1 = " + pr_first1.getLanguagePart());
                        result = true;
}
                }
                
                if (pr_first1.getLanguagePart().equalsIgnoreCase("прикметник")
                        && pr_second1.getLanguagePart().equalsIgnoreCase("іменник")) {
                    if (pr_first1.getG() == pr_second1.getG()
                            && pr_first1.getNumber() == pr_second1.getNumber()
                            && pr_first1.getRhode() == pr_second1.getRhode()) {

                        System.out.println(pairs[0].getWord() + " №" + pairs[0].getNum() + " & "
                                + pairs[1].getWord() + " №" + pairs[1].getNum() + "  - ПРАВИЛО  1 = " + pr_first1.getLanguagePart());
                        result = true;
                    }
                }
            }
            
        }

        return result;
    }

    public word[] getPairs() {
        return pairs;
    }

    public void setPairs(word[] pairs) {
        this.pairs = pairs;
    }

}
