/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import word.PropertieWord;
import word.word;

/**
 *
 * @author progroup
 */
public class WorkWithOffer {

    public ArrayList<word> offering;

    public WorkWithOffer() {
    }

    /**
     * Возвращает следующее слово после текущего
     *
     * @param val
     * @return
     */
    public word getNextWord(word val) {
        int lastWord = offering.size();
        word result = offering.get(offering.size() - 1);

        for (int i = 0; i < offering.size() - 2; i++) {
            if (val.compare(offering.get(i))) {
                result = offering.get(i + 1);
            }
        }
        return result;
    }

    /**
     * Возвращает предыдущее слово
     *
     * @param val
     * @return
     */
    public word getPrevWord(word val) {
        int lastWord = offering.size();
        word result = offering.get(0);
        for (int i = 1; i < offering.size() - 1; i++) {
            if (val.compare(offering.get(i))) {
                result = offering.get(i - 1);
            }
        }
        return result;
    }

    /**
     * Возвращает любое слово из предложения
     *
     * @param val
     * @return
     */
    public word getSelectiveWord(int val) {
        int i = 0;
        if (val < offering.size()) {
            i = val;
        } else {
            return null;
        }
        return offering.get(i);
    }

    /**
     * Проверить соответсвует ли слово заданним характеристикам
     */
    public boolean getWordSpecifiedCharacteristics(word w, PropertieWord prw) {
        boolean result = true;
        boolean[] res = {true, true, true, true, true, true}; //{false,false,false,false,false,false};
        int[] results = {0, 0, 0, 0, 0, 0}; //{false,false,false,false,false,false};
//ArrayList<PropertieWord> propertie = w.getAllProperties();
        if (w.getAllProperties() != null) {
 //           System.out.print(w.getWord()+" = ");
            for (PropertieWord pr : w.getAllProperties()) {
                res = getPropertieCompare(prw, pr);
 result = res[0] && res[1] && res[2] && res[3] && res[4] && res[5];               
                if (result) {
                    break;
                }
            }
           
        }
        //res[0] && res[1] && res[2] && res[3] && res[4] && res[5];   // res[0] & res[1] & res[2] & res[3] & res[4] & res[5]; 
        //   result = true;
        return result;
    }

    /**
     * Сравниваются две характеристики слова Истина если выполняются условия
     * если <0  елементы не должны совпадать
     * если  0  не проверять елемент
     * если >0 елементы должны совпадать
     *
     * @param source
     * @param destination
     * @return
     */
    public boolean[] getPropertieCompare(PropertieWord source, PropertieWord destination) {
        //public boolean[] getPropertieCompare(PropertieWord source, PropertieWord destination) {
        boolean[] result = {true, true, true, true, true, true};
 //       int[] results = {0, 0, 0, 0, 0, 0};
//      if(source[] == destination[])
//if(source.getCm() )
        for (int i = 0; i < source.getPropertie().length; i++) {
            if (source.getPropertie()[i] == 0) {
                continue;
            }
//*****************************************************************************************************           
            if (source.getPropertie()[i] < 0) {
                int mod = source.getPropertie()[i]*(-1); 
                if (mod != destination.getPropertie()[i]) {
                    result[i] = true;
                  //  System.out.println("отрицание");
//                    results[i] = 1;
                } else {
                    result[i] = false;
 //                   results[i] = -1;
                }
            } else {
                //****************************************************************
                if (source.getPropertie()[i] > 0) {
                    if (source.getPropertie()[i] == destination.getPropertie()[i]) {
                        result[i] = true;
//                        results[i] = 1;
                    } else {
                        result[i] = false;
 //                       results[i] = -1;
                    }
                }
            }
//*********************************************************************************************************            
        }
   /*     for(boolean r:result){
        System.out.print(r+" ");
        }
         System.out.print(" ;");
        System.out.println();*/
   
        return result;
    }

    /**
     * Проверить соответсвует ли слово заданним характеристикам
     */
    public boolean getFindWordCompare(word w, PropertieWord prw) {
        boolean result = false;
        if (w.getAllProperties() != null) {
            for (PropertieWord pr : w.getAllProperties()) {
                if (pr.getCm() == prw.getCm()) {
                    result = getWordSpecifiedCharacteristics(w, prw);
                    // true;
                }
            }
        }

        return result;
    }

}
/**
 * ************************** END
 * *****************************************************************
 */
