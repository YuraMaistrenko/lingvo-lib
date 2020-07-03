/**
 * Устанавливаютсясвойства слова на основании таблиц и колонки в таблице
 */
package word;

import java.io.Serializable;

/**
 *
 * @author Yura Maistrenko
 */
public class PropertieWord implements IProperties, Serializable {             

    private static final long serialVersionUID = 1L;
//, Serializable {

    /**
     * Свойства слова
     */
    private int cm = 0;                             // часть речи значение от 1 до 23
    
    private int g = 0;                              // Падеж.Значение от 1 до 6
    private int n = 1;                              // Число. 1 - если единственное и 0 если множественное
    private int k2 = 0;                             // Род. Значения от 1 до 4
    private int t = 0;                              // Время. Значение от 1 до 3
    private int h = 0;                              // Способ. Значение от 1 до 3
    private int l = 0;                              // Лицо. Значение от 1 до 3

    private int ch = 0;                             // индекс Член предложения Пидмет, присудок и т.д.
    private int[] propertie;                        // Массив из одной таблицы. Определяет свойство слова по колонке в таблице
    private String LanguagePart;                    // Названия части речи
    private int column;                             // Колонка в базе в которой находится данное слово

    /**
     * По имени таблицы и номеру колонки устанавливается СВОЙСТВО СЛОВА
     *
     * @param valTable Имя таблицы базы
     * @param val Число это колонка в таблице. данные берутся из массива
     * полученного из базы.
     */
    public PropertieWord(String valTable, int val) {
        searchAndSet(valTable, val);
        setLanguagePart(valTable);
        this.column = val;
    }

    public PropertieWord() {

    }

    /**
     * Найти и установить характеристику слова
     *
     * @param valTable Имя таблицы из базы
     * @param val номер массива одного из свойств слова
     */
    private void searchAndSet(String nameTable, int val) {
        //    int[] tmp;
        switch (nameTable) {
            case "imen0":
                this.propertie = IMEN0[val];
                break;
            case "imen1":
                this.propertie = IMEN1[val];
                break;
            case "imen2":
                this.propertie = IMEN2[val];
                break;
            case "imen3":
                this.propertie = IMEN3[val];
                break;
            case "prizv":
                this.propertie = PRIZV[val];
                break;
            case "prizv1":
                this.propertie = PRIZV1[val];
                break;
            case "prizv2":
                this.propertie = PRIZV2[val];
                break;

            case "prik":
                this.propertie = PRIK[val];
                break;
            case "zajm0":
                this.propertie = ZAIM0[val];
                break;
            case "zajm1":
                this.propertie = ZAIM1[val];
                break;
            case "zajm2":
                this.propertie = ZAIM2[val];
                break;
            case "zajm3":
                this.propertie = ZAIM3[val];
                break;
            case "zajmpr":
                this.propertie = ZAIMPR[val];
                break;
            case "chis":
                this.propertie = CHIS[val];
                break;
            case "chis1":
                this.propertie = CHIS1[val];
                break;
            case "chis2":
                this.propertie = CHIS2[val];
                break;
            case "chispr":
                this.propertie = CHISPR[val];
                break;
            case "diedok":
                this.propertie = DIEDOC[val];
                break;
            case "die2":
                this.propertie = DIE2[val];
                break;
            case "dienedok":
                this.propertie = DIENEDOC[val];
                break;
            case "diepr":
                this.propertie = DIEPR[val];
                break;
            case "pris":
                this.propertie = PRIS[val];
                break;
            case "spol1":
            case "spol2":
            case "spol3":
            case "spol5":
            case "spol4":

                this.propertie = SPOL[0];
                break;
//chast
            case "chast":
                this.propertie = CHAST[0];
                break;

            default:
                this.propertie = none[0];
                break;
        }
        this.g = this.propertie[0];     // Падежи
        this.n = this.propertie[1];     // Число
        this.k2 = this.propertie[2];     // Род
        this.t = this.propertie[3];     // Время
        this.h = this.propertie[4];     // Способ
        this.l = this.propertie[5];     // Лицо
    }

    /**
     * По имени таблицы устанавливается часть речи.
     *
     * @param valTable название таблицы
     */
    public final void setLanguagePart(String valTable) {
        switch (valTable) {
            case "imen0":
            case "imen1":
            case "imen2":
            case "imen3":
            //   НОВОЕ
            case "prizv":
            case "prizv1":
            case "prizv2":
                this.LanguagePart = "іменник";
                cm = 0;
                break;

            case "prik":
                this.LanguagePart = "прикметник";
                cm = 1;
                break;
            case "zajm0":
            case "zajm1":
            case "zajm2":
            case "zajm3":
            case "zajmpr":
                this.LanguagePart = "займенник";
                cm = 2;
                break;
//"chis", "chis1", "chis2", "chispr",
            case "chis":
            case "chis1":
            case "chis2":
            case "chispr":
                this.LanguagePart = "числівник";
                cm = 3;
                break;
//"diedok", "die2", "dienedok",                
            case "diedok":
            case "die2":
            case "dienedok":
                this.LanguagePart = "дієслово";
                cm = 4;
                break;
// "diepr"                
            case "diepr":
                this.LanguagePart = "дієприкметник";
                cm = 5;
                break;
            //"pris", 
            case "pris":
                this.LanguagePart = "прислівник";
                cm = 6;
                break;
            // pruim               
            case "pruim":
                this.LanguagePart = "прийменник";
                cm = 7;
                break;
// "spol1", "spol2", "spol3", "spol4", "spol5",                
            case "spol1":
            case "spol2":
            case "spol3":
            case "spol5":
            case "spol4":

                this.LanguagePart = "сполучник";
                cm = 8;
                break;
//chast
            case "chast":
                this.LanguagePart = "частка";
                cm = 9;
                break;

            default:
                cm = 10;
                this.LanguagePart = "none";
        }

    }

    /**
     * По имени таблицы устанавливается часть речи.
     *
     * @param valTable название таблицы
     */
    public final void setLanguagePart(int numTable) {
        switch (numTable) {
            case 0:
                this.LanguagePart = "іменник";
                break;
            case 1:
                this.LanguagePart = "прикметник";
                break;
            case 2:
                this.LanguagePart = "займенник";
                break;
//"chis", "chis1", "chis2", "chispr",
            case 3:
                this.LanguagePart = "числівник";
                break;
//"diedok", "die2", "dienedok",                
            case 4:
                this.LanguagePart = "дієслово";
                break;
// "diepr"                
            case 5:
                this.LanguagePart = "дієприкметник";
                break;
            //"pris", 
            case 6:
                this.LanguagePart = "прислівник";
                break;
            // pruim               
            case 7:
                this.LanguagePart = "прийменник";
                break;
// "spol1", "spol2", "spol3", "spol4", "spol5",                
            case 8:
                this.LanguagePart = "сполучник";
                break;
//chast
            case 9:
                this.LanguagePart = "частка";
                break;

            default:
                cm = 10;
                this.LanguagePart = "none";
        }

    }

    /**
     * Часть речи
     *
     * @return
     */
    public int getCm() {
        return cm;
    }

    /**
     * Часть речи
     *
     * @param cm
     */
    public void setCm(int cm) {
        this.cm = cm;
        setLanguagePart(cm);
    }

    /**
     * Число (Однина , Множина)
     *
     * @return
     */
    public int getNumber() {
        this.n = propertie[1];
        return n;
    }

    /**
     * Рід
     *
     * @return
     */
    public int getRhode() {
        this.k2 = propertie[2];
        return k2;
    }

    /**
     * Час
     *
     * @return
     */
    public int getTime() {
        this.t = propertie[3];
        return t;
    }

    /**
     * Час для дієслова
     *
     * @return
     */
    public int getTimeVerb() {
        this.h = propertie[4];
        return h;
    }

    /**
     * Лицо "перша", "друга", "третя"
     *
     * @return
     */
    public int getLizo() {
        this.l = propertie[5];
        return l;
    }

    /**
     * Части предложения (Підмет,присудок, доповнення, означення і т.д. // Для
     * построения модели.
     *
     * @return
     */
    public int getCh() {
        this.ch = propertie[6];
        return ch;
    }

    /**
     * Получить НАЗВАНИЯ части речи
     *
     * @return
     */
    public String getLanguagePart() {
        return LanguagePart;
    }

    public int getColumn() {
        return column;
    }

    /**
     * Сравнение двух характеристик
     */
    public int[] compare_array(PropertieWord val) {
        int[] prop = {0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < prop.length; i++) {
            prop[i] = val.getG() + getG();
        }
        return prop;
    }

    /**
     * Падежи
     *
     * @return
     */
    public int getG() {
        this.g = propertie[0];
        return g;
    }

    /**
     * Возвращает массив свойств
     *
     * @return
     */
    public int[] getPropertie() {
        return propertie;
    }

    public void setPropertie(int[] propertie) {
        this.propertie = propertie;
    }

    public int getH() {
        return h;
    }

}
