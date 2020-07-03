/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word;

/**
 *
 * @author progroup
 */
public class CompareWord {

    private word current_word;
    private word compareWord;

    public CompareWord(word valWord) {
        this.current_word = valWord;
    }

    /**
     *
     * @return Сравниеваемое слово
     */
    public word getCompareWord() {
        return compareWord;
    }

    /**
     *
     * @param compareWord Сравниваемое слово
     */
    public void setCompareWord(word compareWord) {
        this.compareWord = compareWord;
    }

    /**
     * Сравниваем своства двух слов valPropertie и word.getCurrent_properties
     *
     * @param valPropertie
     * @return 
     */
    public boolean equalProperties(PropertieWord valPropertie) {
        boolean result = false;

        for(int i = 0; i < this.current_word.getAllProperties().size();i++) {
            
            if(this.current_word.getAllProperties().get(i).getG() == valPropertie.getG()) result = true;
            if(this.current_word.getAllProperties().get(i).getLizo() == valPropertie.getLizo()) result = true;
            if(this.current_word.getAllProperties().get(i).getNumber() == valPropertie.getNumber()) result = true;
            if(this.current_word.getAllProperties().get(i).getRhode() == valPropertie.getRhode()) result = true;
            if(this.current_word.getAllProperties().get(i).getTime() == valPropertie.getTime()) result = true;
            if(this.current_word.getAllProperties().get(i).getH() == valPropertie.getH()) result = true;
if(result) return result;
        }
        
        return result;

    }
}
