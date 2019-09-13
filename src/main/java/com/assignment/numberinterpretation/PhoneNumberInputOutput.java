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
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public PhoneNumberInputOutput() {
    }

    public void setPhoneNumber() {
        phoneNumber = sc.nextLine();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //prints the possible phone numbers that come of after identifing number ambiguities
    public void numberOutput(NumberAmbiguitiesIdentifier interpretations) {
        System.out.println("Your phone number is:");
        for (String i : interpretations.getPhoneNumberInterpretationSet()) {
            System.out.println(i.replace("\\s", ""));
        }
    }

}
