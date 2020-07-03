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

/**
 *
 * @author progroup
 */
public interface ILanguageRules {

    public String[] LanguageRulesPair = {
        "Прикметник-Іменник", "Порядковий числівник-Іменник", "Займенник-Іменник", "Дієприкметник-Іменник",
        "Іменник-Іменник(ВласнаНазва)", "Дієслово-Іменник", "Дієслово-Прийменник ", "Дієслово-Особовий займенник",
        "Дієприслівник-Іменник", "Дієприслівник-Особовий займенник", "Іменник-Іменник",
        "Іменник-Прийменник", "Числівник-Іменник", "Прикметник-Прийменник", "Прикметник-Прийменник",
        "Дієслово-Прислівник", "Дієслово-Дієприслівник", "Прислівник-Прикметник", "Дієприкметник-Прислівник",
        "Дієприслівник-Прислівник", "Прислівник-Прислівник", "Дієприкметник-Прийменник", "Дієприкметник-Прийменник",
        "Дієприслівник-Прийменник", "Дієслово-Діслово в неозначеній формі", "Дієприкметник-Діслово в неозначеній формі",
        "Прислівник-Прийменник",
        ""
    };
    public String[] IPairsWord = {
        "Прикметник-Іменник", "Порядковий числівник-Іменник", "Займенник-Іменник", "Дієприкметник-Іменник",
        "Іменник-Іменник(ВласнаНазва)", "Дієслово-Іменник", "Дієслово-Прийменник ", "Дієслово-Особовий займенник",
        "Дієприслівник-Іменник", "Дієприслівник-Особовий займенник", "Іменник-Іменник",
        "Іменник-Прийменник", "Числівник-Іменник", "Прикметник-Прийменник", "Прикметник-Прийменник",
        "Дієслово-Прислівник", "Дієслово-Дієприслівник", "Прислівник-Прикметник", "Дієприкметник-Прислівник",
        "Дієприслівник-Прислівник", "Прислівник-Прислівник", "Дієприкметник-Прийменник", "Дієприкметник-Прийменник",
        "Дієприслівник-Прийменник", "Дієслово-Дієслово в неозначеній формі", "Дієприкметник-Дієслово в неозначеній формі",
        "Прислівник-Прийменник","дієслово-прийменник-іменник","дієслово-прийменник-займенник","прикметник-прийменник-іменник",
        "дієприкметник-прийменник-іменник","прикметник-прийменник-займенник","дієприкметник-прийменник-займенник",
        ""
    };
    
 
}