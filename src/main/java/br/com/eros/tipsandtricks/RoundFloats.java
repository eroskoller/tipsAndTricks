/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.eros.tipsandtricks;



/**
 *
 * @author eros
 */
public class RoundFloats {

    public static float Round(float Rval, int Rpl) {
                      float p = (float)Math.pow(10,Rpl);
                      Rval = Rval * p;
                      float tmp = Math.round(Rval);
                      return (float)tmp/p;
    }


}
