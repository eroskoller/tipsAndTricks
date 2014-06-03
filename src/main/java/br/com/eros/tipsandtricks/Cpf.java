/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.eros.tipsandtricks;

/**
 *
 * @author eros
 */
public class Cpf {

//    private String nome;
    private String cpf;
    private int dig1;
    private int dig2;

    public Cpf() {
    }

    public Cpf(String cpf, int dig1, int dig2) {
        this.cpf = cpf;
        this.dig1 = dig1;
        this.dig2 = dig2;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getDig1() {
        return dig1;
    }

    public void setDig1(int dig1) {
        this.dig1 = dig1;
    }

    public int getDig2() {
        return dig2;
    }

    public void setDig2(int dig2) {
        this.dig2 = dig2;
    }

    public Boolean calcDigVerificador() {

        if (this.cpfValido()) {
            if (this.calcDig1() == this.dig1) {
//                 System.out.println ("Dig1 OK!");
                if (this.calcDig2() == this.dig2) {
//                     System.out.println ("Dig2 OK!");
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }//FIM SENAO
        } else {
            return false;
        }//FIM SENAO
    }//FIM calcDigVerificador

    //Verifica a validade do cpf, indicando como 
    //todos os digitos repetidos. Ex.: 111.111.111-11 
    public Boolean cpfValido() {
        int i;
        String digInicial = this.cpf.substring(0, 1);
        Boolean valido = false;

        for (i = 1; i < 9; i++) {
            if (!digInicial.equals(this.cpf.substring(i, i + 1))) {
                valido = true;
            }//FIM SE
        }//FIM PARA
        return valido;
    }//FIM cpfValido

    public int calcDig1() {
        int i, resto, dig, soma = 0;

        for (i = 0; i < 9; i++) {
            soma += ((Integer.parseInt(this.cpf.substring(i, i + 1))) * (i + 1));
        }//FIM PARA

        resto = soma % 11;

        if (resto == 10) {
            dig = 0;
        } else {
            dig = resto;
        }//FIM SENAO

        return dig;

    }//FIM calcDig1

    public int calcDig2() {
        int i, resto, dig, soma = 0;

        for (i = 0; i < 9; i++) {
            soma += ((Integer.parseInt(this.cpf.substring(i, i + 1))) * (12 - (i + 1)));
        }//FIM PARA

        soma += this.calcDig1() * 2;
        soma *= 10;

        resto = soma % 11;

        if (resto == 10) {
            dig = 0;
        } else {
            dig = resto;
        }//FIM SENAO

        return dig;

    }// FIM calcDig2

    public static boolean cpfValidador(String cpf) {
        boolean retorno = false;

        cpf = cpf.replaceAll("\\D", "").trim();

        if (cpf != null && cpf.length() > 10) {

            String strCpf = cpf.trim();
            String strCpf2;
            String cpfDig0;
            String cpfDig1;

            int control = strCpf.length() - 2;

            strCpf2 = strCpf.substring(0, control);
            cpfDig0 = strCpf.substring(control, control + 1);
            cpfDig1 = strCpf.substring(control + 1, control + 2);

            Integer dig0 = new Integer(cpfDig0);
            Integer dig1 = new Integer(cpfDig1);

            if (dig0 != null && dig1 != null && strCpf2 != null) {
                Cpf c = new Cpf(strCpf2, dig0, dig1);
                retorno = (c.cpfValido() && c.calcDigVerificador());
            }
            return retorno;
        } else {
            return retorno;
        }

    }

    public static String formatingCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", "").trim();
        String result = "";
        if (cpf != null && cpf.length() > 10) {
            int control = cpf.length() - 2;
            String cpfPartial = cpf.substring(0, control);
            String strDig = cpf.substring(control, control + 2);

            if (cpfPartial.length() == 9) {

                String cpfFrist3 = cpfPartial.substring(0, 3);
                String cpfSecond3 = cpfPartial.substring(3, 6);
                String cpfThrid3 = cpfPartial.substring(6, 9);

                result = cpfFrist3 + "." + cpfSecond3 + "." + cpfThrid3 + "-" + strDig;
            }
        }
        return result;
    }

    public static void main(String... args) {
        System.out.println(Cpf.formatingCpf("213---043///65875"));
        System.out.println(Cpf.cpfValidador(Cpf.formatingCpf("21304365875")));
    }

}
