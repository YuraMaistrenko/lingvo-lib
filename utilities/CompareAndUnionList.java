/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import word.PropertieWord;

/**
 *      Сравнение и объединения списка
 * @author progroup
 */
public class CompareAndUnionList {

    private ArrayList<PropertieWord> array1, array2;
    private Map<String, ArrayList<PropertieWord>> hashMapMain;
    private Map<String, ArrayList<PropertieWord>> hashMapNew, hashMapTmp;

    public CompareAndUnionList(Map<String, ArrayList<PropertieWord>> hashMap1,
            Map<String, ArrayList<PropertieWord>> hashMap2) {
        this.hashMapMain = hashMap1;
        this.hashMapNew = hashMap2;
        CompareAndUnion();
    }

    /**
     *
     * @return
     */
    public void CompareAndUnion() {
        hashMapMain.size();
        this.hashMapTmp = this.hashMapNew;
        ArrayList<String> keyRemove = new ArrayList<>();
        for (String key : hashMapNew.keySet()) {

            if (hashMapMain.containsKey(key)) {
                array1 = hashMapNew.get(key);
                array2 = hashMapMain.get(key);
                array2.addAll(array1);
                keyRemove.add(key);
                //this.hashMapTmp.remove(key);
                hashMapMain.put(key, array2);
            }

        } // Цикл по новому массиву
        for (String s : keyRemove) {
            hashMapNew.remove(s);
        }
        this.hashMapMain.putAll(this.hashMapNew);
    }

    public Map<String, ArrayList<PropertieWord>> getHashMap() {
        return hashMapMain;
    }

}
