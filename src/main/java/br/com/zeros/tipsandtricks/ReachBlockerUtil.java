/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zeros.tipsandtricks;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author eros
 */


public class ReachBlockerUtil implements Serializable{
    
    private final int intMaxMapSize  = 500;
    private final Map<keyMap,Obj4Map>  mapReachBlockerByMaxDate  = new HashMap<keyMap, Obj4Map>(intMaxMapSize);

    public ReachBlockerUtil() {
        
    }
    
    /**
     * 
     * @param reacherId  who is reaching 
     * @param maxReach  Maximum reach 
     * @param maxSeconds Maximum in seconds
     * @return 
     */
    public boolean reachBlockerByMaxPerSeconds(String reacherId, int maxReach,int maxSeconds) {
        return reachBlockerByMaxGeneric(new keyMap("second", reacherId), maxReach, maxSeconds,0);
    }
    
    /**
     * 
     * @param reacherId  who is reaching 
     * @param maxReach  Maximum reach 
     * @param maxMinutes Maximum in minutes
     * @return 
     */
    public boolean reachBlockerByMaxPerMinutes(String reacherId, int maxReach,int maxMinutes) {
        return reachBlockerByMaxGeneric(new keyMap("minutes", reacherId), maxReach, maxMinutes,1);
    }
    
    /**
     * 
     * @param reacherId  who is reaching 
     * @param maxReach  Maximum reach 
     * @param maxHours Maximum in hours
     * @return 
     */
    public boolean reachBlockerByMaxPerHours(String reacherId, int maxReach,int maxHours) {
        return reachBlockerByMaxGeneric(new keyMap("hours", reacherId), maxReach, maxHours,2);
    }
     
    /**
     * 
     * @param reacherId  who is reaching 
     * @param maxReach  Maximum reach 
     * @param maxDays Maximum in days
     * @return 
     */
    public boolean reachBlockerByMaxPerDays(String reacherId, int maxReach,int maxDays) {
        return reachBlockerByMaxGeneric(new keyMap("days", reacherId), maxReach, maxDays,3);
    }
    
    
    
    private boolean reachBlockerByMaxGeneric(keyMap key, int maxReach,int max,int option) {
        if(mapReachBlockerByMaxDate.size() >= intMaxMapSize){
           mapReachBlockerByMaxDate.clear();
        }
        if (mapReachBlockerByMaxDate.containsKey(key)) {
            long elapsedTime  = 0;
            switch (option) {
                case 0:
                    elapsedTime = DateRange.elapsedTimeBtwDatesSeconds(mapReachBlockerByMaxDate.get(key).elapsedDate, new Date());
                    break;
                case 1:
                    elapsedTime = DateRange.elapsedTimeBtwDatesMinutes(mapReachBlockerByMaxDate.get(key).elapsedDate, new Date())+1;
                    break;
                case 2:
                    elapsedTime = DateRange.elapsedTimeBtwDatesHours(mapReachBlockerByMaxDate.get(key).elapsedDate, new Date())+1;
                    break;
                case 3:
                    elapsedTime = DateRange.elapsedTimeBtwDatesDays(mapReachBlockerByMaxDate.get(key).elapsedDate, new Date())+1;
                    break;
                default:
                    elapsedTime = DateRange.elapsedTimeBtwDatesDays(mapReachBlockerByMaxDate.get(key).elapsedDate, new Date())+1;
            }
            
            if ( elapsedTime <= max) {
                if (mapReachBlockerByMaxDate.get(key).reach < maxReach) {
                                ++ mapReachBlockerByMaxDate.get(key).reach;
                    return true;
                } else {
                    System.out.println("reach the limit dude .....................");
                    return false;
                }

            } else {
                mapReachBlockerByMaxDate.put(key, new Obj4Map(1, new Date()));
//                System.out.println("elapse time expired .....................");
                return  true;
            }
        } else {    
            mapReachBlockerByMaxDate.put(key, new Obj4Map(1, new Date()));
            return true;
        }

    }
    
    
    
    
    class keyMap{
        String type;
        String reacherId;

        public keyMap(String type, String reacherId) {
            this.type = type;
            this.reacherId = reacherId;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 89 * hash + (this.type != null ? this.type.hashCode() : 0);
            hash = 89 * hash + (this.reacherId != null ? this.reacherId.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final keyMap other = (keyMap) obj;
            if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type)) {
                return false;
            }
            if ((this.reacherId == null) ? (other.reacherId != null) : !this.reacherId.equals(other.reacherId)) {
                return false;
            }
            return true;
        }
        
    }
    
    class Obj4Map{
        int reach;
        Date elapsedDate;

        public Obj4Map(int reach, Date elapsedDate) {
            this.reach = reach;
            this.elapsedDate = elapsedDate;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 89 * hash + this.reach;
            hash = 89 * hash + (this.elapsedDate != null ? this.elapsedDate.hashCode() : 0);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Obj4Map other = (Obj4Map) obj;
            if (this.reach != other.reach) {
                return false;
            }
            if (this.elapsedDate != other.elapsedDate && (this.elapsedDate == null || !this.elapsedDate.equals(other.elapsedDate))) {
                return false;
            }
            return true;
        }

        
        
    }
    
    
}
