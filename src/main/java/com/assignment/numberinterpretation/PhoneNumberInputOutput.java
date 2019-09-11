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

    public void setPhoneNumber() {
        phoneNumber = sc.nextLine();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void numberInput() {
        System.out.println("Phone number:");
        setPhoneNumber();
    }

    //prints phone number as entered by the user   
    public void numberOutput() {
        System.out.println("Your phone number is:");
        System.out.println(getPhoneNumber());
    }

    //prints the possible phone numbers that come of after identifing number ambiguities
    public void numberOutput(ArrayList<String> possiblePhoneNumbers) {
        System.out.println("Your phone number is:");
        for (String i : possiblePhoneNumbers) {
            System.out.println(i);
        }
    }

}
