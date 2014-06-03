/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zeros.tipsandtricks;




/**
 *
 * @author eros
 */

public class DescricaoResumida {
    
    
    public static String descResuminda(String strFrase,int  qtMaxChars){
        
        String strResumo = strFrase;
        
        if(strFrase != null && strFrase.length()>qtMaxChars){
            if(strFrase.length()>=2){
                
                if(qtMaxChars >= 5){
                    return  strResumo.substring(0, qtMaxChars-3)+"...";
                }else if(qtMaxChars >= 4){
//                    System.out.println("insite 4");
                    return  strResumo.substring(0, qtMaxChars-1)+".";
                }else if(qtMaxChars >= 3){
//                    System.out.println("insite 3");
                    return  strResumo.substring(0, qtMaxChars)+".";
                }else if(qtMaxChars >= 2){
//                    System.out.println("insite 2");
                    return  strResumo.substring(0, qtMaxChars);
                }else{
                    return  strResumo.substring(0, qtMaxChars);
                }
                
            }else{
                return  strResumo.substring(0, qtMaxChars-3)+"...";
            }
            
        }else{
            return  strFrase;
        }
        
    }
    
}
