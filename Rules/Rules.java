/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rules;

import java.util.ArrayList;
import text.Offering;
import word.word;

/**
 *
 * @author progroup
 */
public class Rules {
    
    private word[] pairs = null;
    private ArrayList<word> offering;
    private Offering OFRGN;
    
  /*  public Rules(ArrayList<word> valOffering) {
        this.offering = valOffering;
    }*/

    public Rules(Offering OFRGN) {
        this.OFRGN = OFRGN;
    }
    
    public word[] getPairs() {
        return pairs;
    }
    
    public void setPairs(word[] pairs) {
        this.pairs = pairs;
        //      System.out.println(pairs[0].getWord() + "&" + pairs[1].getWord() + "  - ПРАВИЛО  1");
    }
    
    public ArrayList<word> getOffering() {
//System.out.println("RULES   "+pairs[0].getWord()+" - "+ pairs[1].getWord());        
        Rule1 p = new Rule1(pairs);
        //       p.setPairs(pairs);
        if (p.test_rule1(this.OFRGN)) {
            OFRGN.setPairWord(pairs);
        }
        return offering;
    }
    
    public void setOffering(ArrayList<word> offering) {
        this.offering = offering;
    }
    
    public Offering getOFRGN() {
        return OFRGN;
    }
    
    public void setOFRGN(Offering OFRGN) {
        this.OFRGN = OFRGN;
    }
    
}
