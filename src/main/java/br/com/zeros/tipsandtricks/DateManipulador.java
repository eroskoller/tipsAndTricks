/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zeros.tipsandtricks;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author eros
 */
public class DateManipulador implements Serializable{
    
    static SimpleDateFormat    formatS = new SimpleDateFormat();
    
    public static String formatDateToPattern(String pattern , Date date){
        formatS.applyPattern(pattern);
        return formatS.format(date);
    }
    
    public static Date formatDateToPattern(String pattern , String strDate){    
        Date dtRetorno = null;
        
//        System.out.println("data str : " + strDate);
        formatS.applyPattern(pattern);
        try {
             dtRetorno = formatS.parse(strDate);
        } catch (ParseException ex) {
            Logger.getLogger(DateManipulador.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println("retorno date: " +  dtRetorno);
        return  dtRetorno;
    }
    
    public static Date formatDateCurta(Date date){
        String dataCurta = formatDateToPattern("dd/MM/yyyy", date);
        Date dtRetorno = formatDateToPattern("dd/MM/yyyy", dataCurta);
        return dtRetorno;
    }
   
}
    