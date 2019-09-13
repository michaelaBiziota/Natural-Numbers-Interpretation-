/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.numberinterpretation;

import java.util.regex.Pattern;

/**
 *
 * @author bizmi
 */
public class GreekNumberValidation {

    private PhoneNumberInputOutput phoneNumberInputOutput = new PhoneNumberInputOutput();

    public static boolean checkIfPhoneNumberIsValid(String phoneNumber) {

        //checks if phone number has 10 or 14 digits and starts with 2 or 69 and 00302 or 003069 respectively.
        if (phoneNumber.length() == 10 && (phoneNumber.startsWith("2") || phoneNumber.startsWith("69"))) {
            return true;
        } else if (phoneNumber.length() == 14 && (phoneNumber.startsWith("0032") || phoneNumber.startsWith("003069"))) {
            return true;
        } else {
            return false;
        }
    }

    //checks if the given input includes only numbers
    public boolean checkInputValidation() {
        String recordedPhoneNumber = phoneNumberInputOutput.getPhoneNumber();
        String recordedPhoneNumberWithoutSpaces = recordedPhoneNumber.replaceAll("\\s", "");
        if (!recordedPhoneNumberWithoutSpaces.matches("[0-9]+")) {
            System.out.println("Your input does not include only digits");
            return true;
        }
        return false;
    }
}
