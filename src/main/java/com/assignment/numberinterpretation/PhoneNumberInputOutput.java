/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.numberinterpretation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bizmi
 */
public class PhoneNumberInputOutput {

    private Scanner sc = new Scanner(System.in);
    private static String phoneNumber;


    public PhoneNumberInputOutput() {
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumberInputOutput.phoneNumber = phoneNumber;
    }

//    public void setPhoneNumber() {
//        phoneNumber = sc.nextLine().trim();
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //prints the possible phone numbers that come of after identifing number ambiguities
    public void numberOutput(NumberAmbiguitiesIdentifier interpretations) {
        System.out.println("Your phone number is:");
        int interpretationNumber = 1;
        for (String i : interpretations.getPhoneNumberInterpretationSet()) {          
            System.out.println("Interpretation" + interpretationNumber + ":" + i +" "+ showPhoneNumberValidation(i) );
            interpretationNumber++;
        }
    }

    public String showPhoneNumberValidation(String phoneNumber) {       
        if (GreekNumberValidation.checkIfPhoneNumberIsValid(phoneNumber) == true) {
            return("phone Number: Valid");
        } else {
            return("phone Number: Invalid");
        }
    }

    public String[] splitPhoneNumberIntoParts(String phoneNumber) {
        return phoneNumber.split("\\s");
    }

}
