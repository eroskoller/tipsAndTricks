/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eros.tipsandtricks;

/**
 *
 * @author eros
 */
public class StringsUtils {
    
    
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
    
    public static String truncateAfterWords(int numberOfWords, String longString)     {
        return longString.replaceAll("^((?:\\W*\\w+){" + numberOfWords + "}).*$", "$1");
    }
    
    /**
 * 
 * @param txt
 * @return Replace all non ascii chars in the string.
 */    
    public static String replaceNoASCII(String txt){
        return txt.replaceAll("[^\\x0A\\x0D\\x20-\\x7E]", "");
    }
    
}
