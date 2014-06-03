/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.zeros.play;

import java.util.Scanner;

/**
 *
 * @author eros
 */
public class ScannerValidateInput {
    
    public static void main(String[] args) {
        ScannerValidateInput demo = new ScannerValidateInput();
//        demo.validatePositiveNumber();
        demo.scannerPlay();
    }
 
    private void validatePositiveNumber() {
        Scanner scanner = new Scanner(System.in);
 
        int number;
        do {
            System.out.println("Please enter a positive number: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            number = scanner.nextInt();
        } while (number < 0);
 
        System.out.printf("You have entered a positive number %d.\n", number);
    }
    
    private void scannerPlay() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
    
}
