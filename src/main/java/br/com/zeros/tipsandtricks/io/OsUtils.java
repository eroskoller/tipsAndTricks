/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.zeros.tipsandtricks.io;

import java.util.Locale;
import java.util.Map;


/**
 *
 * @author eros
 */
public final class OsUtils
{
   private static String OS = null;
   public static String getOsName()
   {
      if(OS == null) { OS = System.getProperty("os.name"); }
      return OS;
   }
   public static boolean isWindows()
   {
      return getOsName().startsWith("Windows");
   }

   public static boolean isUnix(){
             return getOsName().startsWith("Unix");
   }
   public static boolean isLinux(){
             return getOsName().startsWith("Linux");
   }
       // and so on


}
