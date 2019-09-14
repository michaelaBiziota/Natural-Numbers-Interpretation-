/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.numberinterpretation;

import java.util.Scanner;

/**
 *
 * @author bizmi
 */
public class Menu {

    private PhoneNumberInputOutput phoneNumberInputOutput = new PhoneNumberInputOutput();
    private NumberAmbiguitiesIdentifier numberAmbiguitiesIdentifier = new NumberAmbiguitiesIdentifier();
    private GreekNumberValidation greekNumberValidation = new GreekNumberValidation();

    public void startTheApp() {
        do {
            System.out.println("Please enter your phone number.");
            System.out.println("Your input should be a sequence of numbers separated by space.");
            System.out.println("Each number in a sequence should be up to a three digit number.");
            System.out.println("Press 'e' to exit");           
            phoneNumberInputOutput.setPhoneNumber();
            
            exitTheApp();
        } while (greekNumberValidation.checkInputValidation(phoneNumberInputOutput.getPhoneNumber()));

        numberAmbiguitiesIdentifier.setParts(phoneNumberInputOutput.splitPhoneNumberIntoParts(phoneNumberInputOutput.getPhoneNumber()));
        numberAmbiguitiesIdentifier.identifyNaturalNumberAmbiguities();
        phoneNumberInputOutput.numberOutput(numberAmbiguitiesIdentifier);
        
    }

    public void exitTheApp() {
        if(phoneNumberInputOutput.getPhoneNumber().equalsIgnoreCase("e")) {
            System.exit(0);
        }
    }

}
