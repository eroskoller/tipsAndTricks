/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eros.tipsandtricks;

import br.com.eros.tipsandtricks.io.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author eros
 */
public class RegexUtils {

    static Pattern pattern; //
    static Matcher matcher;

    public static String getStringFromFileBySeparator(String fileName, String charaterSeparator1, String charaterSeparator2) {

        String s = IOUtils.getStringFromFile(fileName);

        return getStringFromStringBySeparator(s, charaterSeparator1, charaterSeparator2);
    }

    public static String getStringFromStringBySeparator(String stringStream, String charaterSeparator1, String charaterSeparator2) {

        CharSequence s = stringStream;//IOUtils.getStringFromFile(fileName);
        pattern = Pattern.compile("\\" + charaterSeparator1 + "((\\s*?.*?)*?)\\" + charaterSeparator2 + "");

        StringBuffer sb = new StringBuffer();
        matcher = pattern.matcher(s);

        while (matcher.find()) {

            String email = matcher.group();

            if (email != null && email.length() > 2) {
                email = email.substring(1, email.length() - 1);

                sb.append(email + "\n");
            }

        }

        return sb.toString();

    }

    /**
     * @param String
     * @return Long number of tags <br> and <t*>
     */
    public static Long tagsCounterDefault(String stringStream) {
        Long brTags = tagsCounter(stringStream, "<br", ">");
        Long tTags = tagsCounter(stringStream, "<t", ">");
        //Long tTags = tagsCounter(stringStream, "<t", ">");
        return brTags + tTags;
    }

    public static Long tagsCounter(String stringStream, String charaterSeparator1, String charaterSeparator2) {

        //System.out.println(stringStream.length());
        //stringStream = stringStream.substring(0, 9000);
        CharSequence s = stringStream;//IOUtils.getStringFromFile(fileName);
        pattern = Pattern.compile("\\" + charaterSeparator1 + "((\\s*?.*?)*?)\\" + charaterSeparator2 + "");

        //long i = 0;
        Long y = new Long(0);
        StringBuffer sb = new StringBuffer();
        matcher = pattern.matcher(s);

        while (matcher.find()) {
            y++;

        }

        return y;
    }

    @Deprecated
    public static String replaceAllParameters(String stringStream, List<String> listValues, List<String> listParameters) {

//         Pattern pattern; //
//         Matcher matcher;
        if (listValues != null && listParameters != null && listValues.size() == listParameters.size() && stringStream != null) {
            for (int i = 0; i < listParameters.size(); i++) {
                pattern = Pattern.compile(listParameters.get(i));
                matcher = pattern.matcher(stringStream);
                stringStream = matcher.replaceAll(listValues.get(i));
            }
        }

        return stringStream;
    }

    public static String replaceAllParameters(String stringStream, Map<String, String> mapItems) {

        CharSequence sequenceChar = stringStream.subSequence(0, stringStream.length());
        pattern = Pattern.compile("\\<#((\\s*?.*?)*?)\\>");
        matcher = pattern.matcher(sequenceChar);
        StringBuffer myStringBuffer = new StringBuffer();

        int tagLength = 0;
        String strItemKey;
        String tag;
        while (matcher.find()) {
            tag = matcher.group();
            if (tag != null && tag.length() > 1) {

                tagLength = tag.length();
                strItemKey = tag.substring(2, tagLength - 1);
                String item = mapItems.get(strItemKey);
                //System.out.println("strItemKey: "+strItemKey+" - item: "+item );
                if (item != null) {
                    matcher.appendReplacement(myStringBuffer, item);
                }
            }

        }
        matcher.appendTail(myStringBuffer);

        return myStringBuffer.toString();
    }

//     public static String replaceAllParametersTest(String stringStream,Map<String,String> mapItems){
//            System.out.println("Inside replaceAllParametersTest");
//            CharSequence sequenceChar = stringStream.subSequence(0, stringStream.length());
//            pattern = Pattern.compile("\\<#((\\s*?.*?)*?)\\>");
//            matcher = pattern.matcher(sequenceChar);
//            StringBuffer myStringBuffer = new StringBuffer();
//
//            int tagLength = 0;
//            String strItemKey ;
//            String tag ;
//            while(matcher.find()){
//                tag = matcher.group();
//                if(tag != null && tag.length()>1){
//
//                    tagLength = tag.length();
//                    strItemKey = tag.substring(2,tagLength-1);
//                    String item = mapItems.get(strItemKey);
//                    System.out.println("strItemKey: "+strItemKey+" - item: "+item );
//                    if(item != null){
//                         matcher.appendReplacement(myStringBuffer, item);
//                    }
//                }
//
//            }
//            matcher.appendTail(myStringBuffer);
//
//        return myStringBuffer.toString();
//    }
    public static String spaceLessAndUpperCase(String nome) {

        List<String> list;
        String strResut = null;

        if (nome != null && nome.trim().length() > 2) {

            pattern = Pattern.compile("[,\\s]+");
            list = new ArrayList<String>();
            //nome = nome.trim();
            strResut = "";
            String[] result = pattern.split(nome);

            for (int i = 0; i < result.length; i++) {
                //System.out.println(result[i]);
                list.add(result[i]);
            }

            for (int i = 0; i < list.size(); i++) {
                if (i < list.size()) {
                    strResut = strResut + list.get(i) + " ";
                } else {
                    strResut = strResut + list.get(i);
                }
            }
            strResut = strResut.toUpperCase().trim();
            //System.out.println(nome);
        }

        return strResut;

    }

    //25783526x
    public static String rgFormater(String rg) {
        if (rg != null && rg.length() > 7) {
            rg = rg.trim().toUpperCase();
            String ultimoDigito = null;
            if (rg.length() > 8) {
                ultimoDigito = rg.substring(rg.length() - 1, rg.length());
                rg = rg.substring(0, rg.length() - 1);
            }
            rg = rg.replaceAll("\\D", "");

            if (ultimoDigito != null) {
                return rg + ultimoDigito;
            } else {
                return rg;
            }

        }
        return null;
    }

    public static List<String> giveMeListByRegexSeparator(String strRegex, String strText) {

        pattern
                = Pattern.compile(strRegex);

        matcher = pattern.matcher(strText);
        List<String> list = new ArrayList<String>();

        int base = 0;
        while (matcher.find()) {

            list.add(strText.substring(base, matcher.end() - 1));
            base = matcher.end();

        }
        list.add(strText.substring(base, strText.length()));

        return list;
    }

    public static String replaceTokenWithValue(String stringStream, Map<String, String> mapParameters) {
        StringBuilder sb = null;
        if (stringStream != null && stringStream.trim().length() > 0 && mapParameters != null && mapParameters.size() > 0) {
            sb = new StringBuilder(256);
            char[] charArray = stringStream.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (mapParameters.containsKey((new Character(charArray[i])).toString())) {
                    sb.append(mapParameters.get((new Character(charArray[i])).toString()));
                } else {
                    sb.append(charArray[i]);
                }
            }
            return sb.toString();
        } else {
            return null;
        }

    }

    public static String replaceCharacterSpecial(String text) {
        text = text.replaceAll("[ÂÀÁÄÃ]", "A");
        text = text.replaceAll("[âãàáä]", "a");
        text = text.replaceAll("[ÊÈÉË]", "E");
        text = text.replaceAll("[êèéë]", "e");
        text = text.replaceAll("ÎÍÌÏ", "I");
        text = text.replaceAll("îíìï", "i");
        text = text.replaceAll("[ÔÕÒÓÖ]", "O");
        text = text.replaceAll("[ôõòóö]", "o");
        text = text.replaceAll("[ÛÙÚÜ]", "U");
        text = text.replaceAll("[ûúùü]", "u");
        text = text.replaceAll("Ç", "C");
        text = text.replaceAll("ç", "c");
        text = text.replaceAll("[ýÿ]", "y");
        text = text.replaceAll("Ý", "Y");
        text = text.replaceAll("ñ", "n");
        text = text.replaceAll("Ñ", "N");
        return text;
    }

    
    public static List<String>  buildListByToken(String strLine,String token){
        
        StringTokenizer stringTokenizer = new StringTokenizer(strLine, token);
        List<String>  listStr = new ArrayList<String>();
        int index = 0;
        while (stringTokenizer.hasMoreElements()) {
            listStr.add(stringTokenizer.nextElement().toString());
            System.out.println(listStr.get(index));
            index++;
        }
        return listStr;
    }
    
    
}
