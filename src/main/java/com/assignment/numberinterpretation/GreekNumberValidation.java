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

    public void checkIfPhoneNumberIsValid() {
        String recordedPhoneNumber = phoneNumberInputOutput.getPhoneNumber();
        String recordedPhoneNumberWithoutSpaces = recordedPhoneNumber.replaceAll("\\s", "");

//first checks if the given input includes only numbers
        if (recordedPhoneNumberWithoutSpaces.matches("[0-9]+")) {

//checks if phone number has 10 or 14 digits and starts with 2 or 69 and 00302 or 003069 respectively.
            if (!(recordedPhoneNumberWithoutSpaces.length() == 10 && (recordedPhoneNumberWithoutSpaces.startsWith("2") || recordedPhoneNumberWithoutSpaces.startsWith("69")))) {
                if (!(recordedPhoneNumberWithoutSpaces.length() == 14 && (recordedPhoneNumberWithoutSpaces.startsWith("0032") || recordedPhoneNumberWithoutSpaces.startsWith("003069")))) {
                    System.out.println("invalid phone number please enter your phone number again");
                    phoneNumberInputOutput.setPhoneNumber();
                    checkIfPhoneNumberIsValid();
                } else {
                    System.out.println("valid phone number");

                }

            } else {
                System.out.println("valid phone number");

            }

        } else {
            System.out.println("invalid number please enter your phone number again again");
            phoneNumberInputOutput.setPhoneNumber();
            checkIfPhoneNumberIsValid();
        }

    }
}
