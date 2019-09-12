/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.numberinterpretation;

import java.util.HashSet;

/**
 *
 * @author bizmi
 */
public class NaturalNumberAmbiguitiesIdentifier {

    private PhoneNumberInputOutput phoneNumberInputOutput = new PhoneNumberInputOutput();
    private HashSet<String> phoneNumberInterpretationSet = new HashSet<String>();
    private String[] phoneNumberPartsA;

    public void identifyNaturalNumberAmbiguities() {
        phoneNumberPartsA = phoneNumberInputOutput.getPhoneNumber().split("\\s");
        for (int i = 0; i < phoneNumberPartsA.length; i++) {
            if (phoneNumberPartsA[i].length() == 2) {
                if (phoneNumberPartsA[i].endsWith("0") && phoneNumberPartsA.length - i > 1) {
                    if (phoneNumberPartsA[i + 1].length() == 1 && (phoneNumberPartsA[i].equals("10") && (phoneNumberPartsA[i + 1].equals("1") || phoneNumberPartsA[i + 1].equals("2")))) { //element of input list is 10,20, 30, ... , 90 and its next element is 1-9 excluding(10 1, 10 2)
                        phoneNumberPartsA[i] = interprentTwoDigitEndingWithZeroParts(phoneNumberPartsA[i]);
                        String interpretation = String.join("", phoneNumberPartsA);
                        phoneNumberInterpretationSet.add(interpretation);
                    }
                } else if ((phoneNumberPartsA[i].length() == 2 && !phoneNumberPartsA[i].endsWith("0")
                        && !phoneNumberPartsA[i].equals("11") && !phoneNumberPartsA[i].equals("12"))) { //element of input list is 13-19, 21-29 , 31-39, ... , 91-99
                    phoneNumberPartsA[i] = interprentTwoDigitNotEndingWithZeroParts(phoneNumberPartsA[i]);
                    String interpretation = String.join("", phoneNumberPartsA);
                    phoneNumberInterpretationSet.add(interpretation);
                }
            }
        }

    }

    public String interprentTwoDigitNotEndingWithZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).insert(1, '0').toString();
        return modifiedPart;
    }

    public String interprentTwoDigitEndingWithZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).deleteCharAt(1).toString();
        return modifiedPart;
    }

    public HashSet<String> getPhoneNumberInterpretationSet() {
        return phoneNumberInterpretationSet;
    }

}
