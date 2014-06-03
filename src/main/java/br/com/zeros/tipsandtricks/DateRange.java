/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zeros.tipsandtricks;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author eros
 */
public class DateRange implements Serializable{   
    
    
    public static Date[] dataRangerStartDayToEndDay(Date dtStart,Date dtEnd){
            Date arrayDate[] = new Date[2];
                Calendar calStartOfTheDay = Calendar.getInstance();
                calStartOfTheDay.setTime(dtStart);
                calStartOfTheDay.set(dtStart.getYear()+1900,dtStart.getMonth(), dtStart.getDate(), 00, 00,00);
                dtStart = calStartOfTheDay.getTime();
            
                Calendar calEndOfTheDay = Calendar.getInstance();
                calEndOfTheDay.setTime(dtEnd);
                calEndOfTheDay.set(dtEnd.getYear()+1900,dtEnd.getMonth(), dtEnd.getDate(), 23, 59,59);
                dtEnd = calEndOfTheDay.getTime();
                arrayDate[0] = dtStart;
                arrayDate[1] = dtEnd;
        return  arrayDate;
    }
    
    
    public static Date shiftDayto00hrs(Date day){
                Calendar calStartOfTheDay = Calendar.getInstance();
                calStartOfTheDay.setTime(day);
                calStartOfTheDay.set(day.getYear()+1900,day.getMonth(), day.getDate(), 00, 00,00);
                day = calStartOfTheDay.getTime();
        return  day;
    }
    
    public static Date shiftDayto24hrs(Date day){
                Calendar calEndOfTheDay = Calendar.getInstance();
                calEndOfTheDay.setTime(day);
                calEndOfTheDay.set(day.getYear()+1900,day.getMonth(), day.getDate(), 23, 59,59);
                day = calEndOfTheDay.getTime();
        return  day;
    }
    
    
    public static boolean rangeVerifierDays(int rangeDays,Date dtStart,Date dtEnd){
        
        Long elapse = elapsedTimeBtwDatesDays(dtStart, dtEnd);
        
        if(elapse.intValue()<= rangeDays){
            return  true;
        }else{
            return false;
        }
    }
    
    
    public static boolean rangeVerifierMonths(int rangeMonths,Date dtStart,Date dtEnd){
        
        
       Long elapse = elapsedTimeBtwDatesDays(dtStart, dtEnd);
        
        rangeMonths = rangeMonths*31;
        if(elapse.intValue()<= rangeMonths){
            return  true;
        }else{
            return false;
        }
        
    }
    
    
    public static Long[] elapsedTimeBtwDatesComplete(Date dtStart,Date dtEnd){
        
        long l1 = dtStart.getTime();
        long l2 = dtEnd.getTime();
        long diff = l2 - l1;

        long secondInMillis = 1000;
        long minuteInMillis = secondInMillis * 60;
        long hourInMillis = minuteInMillis * 60;
        long dayInMillis = hourInMillis * 24;
        long yearInMillis = dayInMillis * 365;
        
        long elapsedYears = diff / yearInMillis;
        diff = diff % yearInMillis;
        long elapsedDays = diff / dayInMillis;
        diff = diff % dayInMillis;
        long elapsedHours = diff / hourInMillis;
        diff = diff % hourInMillis;
        long elapsedMinutes = diff / minuteInMillis;
        diff = diff % minuteInMillis;
        long elapsedSeconds = diff / secondInMillis;
        Long[] array =  {elapsedYears,elapsedDays,elapsedHours,elapsedMinutes,elapsedSeconds};
        return array;
    }
    
    
    public static long elapsedTimeBtwDatesYears(Date dtStart,Date dtEnd){
        return  elapsedTimeBtwDatesComplete(dtStart, dtEnd)[0];
    }
    
    public static long elapsedTimeBtwDatesDays(Date dtStart,Date dtEnd){
        return  elapsedTimeBtwDatesComplete(dtStart, dtEnd)[1];
    }
    
    public static long elapsedTimeBtwDatesHours(Date dtStart,Date dtEnd){
        return  elapsedTimeBtwDatesComplete(dtStart, dtEnd)[2];
    }
    
    public static long elapsedTimeBtwDatesMinutes(Date dtStart,Date dtEnd){
        return  elapsedTimeBtwDatesComplete(dtStart, dtEnd)[3];
    }
    
    public static long elapsedTimeBtwDatesSeconds(Date dtStart,Date dtEnd){
        return  elapsedTimeBtwDatesComplete(dtStart, dtEnd)[4];
    }
    
    
    public static boolean  timerInterval(int seconds, Date dtBase,Date dtRightNow){
        return (new Long(elapsedTimeBtwDatesSeconds(dtBase, dtRightNow))).intValue()>=seconds;
    }
    
}
