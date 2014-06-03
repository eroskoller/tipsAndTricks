/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eros.tipsandtricks;

/**
 *
 * @author eros
 */
public class ResumeStrings {
    
    
    public static String resumeString(int intMaxChrs,String strText,String strAppend){
        if(strText != null){
            if(strText.length()>intMaxChrs){
                strText = strText.substring(0, intMaxChrs-4)+" ...";
                if(strAppend != null){
                    strText = strText+strAppend;
                }
            }
        }
        return strText;
    }
    
}
