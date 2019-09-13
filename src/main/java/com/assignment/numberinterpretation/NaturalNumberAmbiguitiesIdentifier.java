/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.numberinterpretation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bizmi
 */
public class NaturalNumberAmbiguitiesIdentifier {

    private PhoneNumberInputOutput phoneNumberInputOutput = new PhoneNumberInputOutput();
    public static HashSet<String> phoneNumberInterpretationSet = new HashSet<String>();
    private String[] phoneNumberPartsA;
    private String[] phoneNumberPartsB;

    public void setPhoneNumberPartsA() {
        this.phoneNumberPartsA = phoneNumberInputOutput.getPhoneNumber().split("\\s");
        phoneNumberInterpretationSet.add(String.join("", phoneNumberPartsA));
    }

    public String[] getPhoneNumberPartsA() {
        return phoneNumberPartsA;
    }

    public void identifyNaturalNumberAmbiguities(String[] phoneNumberPartsA) {
        for (int i = 0; i < phoneNumberPartsA.length; i++) {
            if (phoneNumberPartsA[i].length() == 2) {
                if (phoneNumberPartsA[i].endsWith("0") && phoneNumberPartsA.length - i > 1) {
                    if (phoneNumberPartsA[i + 1].length() == 1 && !phoneNumberPartsA[i + 1].equals("0")) {
                        if (!(phoneNumberPartsA[i].equals("10") && (phoneNumberPartsA[i + 1].equals("1") || phoneNumberPartsA[i + 1].equals("2")))) { //element of input list is 10,20, 30, ... , 90 and its next element is 1-9 excluding(10 1, 10 2)
                            phoneNumberPartsA[i] = interprentTwoDigitEndingWithZeroParts(phoneNumberPartsA[i]);
                            String interpretation = String.join("", phoneNumberPartsA);
                            phoneNumberInterpretationSet.add(interpretation);
                            identifyNaturalNumberAmbiguities(phoneNumberPartsA);
//                            setPhoneNumberPartsA();
                        }
                    }
                }
            }
            if ((phoneNumberPartsA[i].length() == 2 && !phoneNumberPartsA[i].endsWith("0")
                    && !phoneNumberPartsA[i].equals("11") && !phoneNumberPartsA[i].equals("12"))) { //element of input list is 13-19, 21-29 , 31-39, ... , 91-99
                phoneNumberPartsA[i] = interprentTwoDigitNotEndingWithZeroParts(phoneNumberPartsA[i]);
                String interpretation = String.join("", phoneNumberPartsA);
                phoneNumberInterpretationSet.add(interpretation);
                identifyNaturalNumberAmbiguities(phoneNumberPartsA);
//                setPhoneNumberPartsA();
            }
            //e.g 800 34->80034 or 834
            if (phoneNumberPartsA.length - i > 1) {
                if (phoneNumberPartsA[i].length() == 3 && phoneNumberPartsA[i].endsWith("00")
                        && phoneNumberPartsA[i + 1].length() == 2) {
                    phoneNumberPartsA[i] = interprentTreeDigitEndingWithTwoZeroParts(phoneNumberPartsA[i]);
                    String interpretation = String.join("", phoneNumberPartsA);
                    phoneNumberInterpretationSet.add(interpretation);
                    identifyNaturalNumberAmbiguities(phoneNumberPartsA);
//                setPhoneNumberPartsA();
                }
                //e.g 800 3-> 8003 or 803 but 800 0-> 8000
                if (phoneNumberPartsA[i].length() == 3 && phoneNumberPartsA[i].endsWith("00")
                        && phoneNumberPartsA[i + 1].length() == 1 && !phoneNumberPartsA[i + 1].equals("0")) {
                    interprentTreeDigitEndingWithZeroPartsFollowedByOneDigit(phoneNumberPartsA[i]);
                    identifyNaturalNumberAmbiguities(phoneNumberPartsA);
//                setPhoneNumberPartsA();
                }
                //e.g 820 4->8204 or 824 but 820 0->8200
                if (phoneNumberPartsA[i].length() == 3 && phoneNumberPartsA[i].charAt(1) != '0' && phoneNumberPartsA[i].endsWith("0")
                        && phoneNumberPartsA[i + 1].length() == 1 && !phoneNumberPartsA[i + 1].equals("0")) {
                    phoneNumberPartsA[i] = interprentTreeDigitEndingWithZeroPartsFollowedByOneDigit(phoneNumberPartsA[i]);
                    String interpretation = String.join("", phoneNumberPartsA);
                    phoneNumberInterpretationSet.add(interpretation);
                    identifyNaturalNumberAmbiguities(phoneNumberPartsA);
//                setPhoneNumberPartsA();
                }
            }
            //e.g 802 ->802 or 800 2 but 800 0->8000
            if (phoneNumberPartsA[i].length() == 3 && phoneNumberPartsA[i].charAt(1) == '0' && !phoneNumberPartsA[i].endsWith("0")) {
                phoneNumberPartsA[i] = interprentTreeDigitWithZeroInTheMiddleParts(phoneNumberPartsA[i]);
                String interpretation = String.join("", phoneNumberPartsA);
                phoneNumberInterpretationSet.add(interpretation);
                identifyNaturalNumberAmbiguities(phoneNumberPartsA);
//                setPhoneNumberPartsA();
            }
            //e.g 825->80025 and 800 20 5 (but 811->800 11 and 812->80012)
            if (phoneNumberPartsA[i].length() == 3 && phoneNumberPartsA[i].indexOf("0") < 0) {
                String temp = new String(phoneNumberPartsA[i]);
                String temp1 = new String(phoneNumberPartsA[i]);
                phoneNumberPartsA[i] = interprentTreeDigitWithoutZeroParts(phoneNumberPartsA[i]);
                String interpretation = String.join("", phoneNumberPartsA);
                phoneNumberInterpretationSet.add(interpretation);
                phoneNumberPartsA[i] = temp;
                phoneNumberPartsA[i] = interprentTreeDigitWithoutZerosPartsB(phoneNumberPartsA[i]);
                String secondInterpretation = String.join("", phoneNumberPartsA);
                phoneNumberInterpretationSet.add(secondInterpretation);
                if (!temp1.endsWith("11") && !temp1.endsWith("12")) {
                    phoneNumberPartsA[i] = temp1;
                    phoneNumberPartsA[i] = phoneNumberPartsA[i] + interprentTwoDigitNotEndingWithZeroParts(temp1.substring(1, 3));
                    String thirdInterpretation = String.join("", phoneNumberPartsA);
                    phoneNumberInterpretationSet.add(thirdInterpretation);
                }
                identifyNaturalNumberAmbiguities(phoneNumberPartsA);
//                setPhoneNumberPartsA();
            }
        }

    }

//    public void identifyNaturalNumberAmbiguities(String[] phoneNumberPartsB) {
//        phoneNumberPartsB = phoneNumberInputOutput.getPhoneNumber().split("\\s");
//        for (int i = 0; i < phoneNumberPartsB.length; i++) {
//            if (phoneNumberPartsB[i].length() == 2) {
//                if (phoneNumberPartsB[i].endsWith("0") && phoneNumberPartsB.length - i > 1) {
//                    if (phoneNumberPartsB[i + 1].length() == 1 && !(phoneNumberPartsB[i].equals("10") && (phoneNumberPartsB[i + 1].equals("1") || phoneNumberPartsB[i + 1].equals("2")))) { //element of input list is 10,20, 30, ... , 90 and its next element is 1-9 excluding(10 1, 10 2)                      
//                        phoneNumberPartsB[i] = interprentTwoDigitEndingWithZeroParts(phoneNumberPartsB[i]);
//                        String interpretation = String.join("", phoneNumberPartsB);
//                        phoneNumberInterpretationSet.add(interpretation);
//                    }
//                } else if ((phoneNumberPartsB[i].length() == 2 && !(phoneNumberPartsB[i].endsWith("0")
//                        && phoneNumberPartsB[i].equals("11") && phoneNumberPartsB[i].equals("12")))) { //element of input list is 13-19, 21-29 , 31-39, ... , 91-99
//                    phoneNumberPartsB[i] = interprentTwoDigitNotEndingWithZeroParts(phoneNumberPartsB[i]);
//                    String interpretation = String.join("", phoneNumberPartsA);
//                    phoneNumberInterpretationSet.add(interpretation);
//                }
//            }
//            phoneNumberPartsB = phoneNumberInputOutput.getPhoneNumber().split("\\s");
//        }
//    }
    public String interprentTwoDigitNotEndingWithZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).insert(1, '0').toString();
        return modifiedPart;
    }

    public String interprentTwoDigitEndingWithZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).deleteCharAt(1).toString();
        return modifiedPart;
    }

    public String interprentTreeDigitEndingWithTwoZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).delete(1, 3).toString();
        return modifiedPart;
    }

    public String interprentTreeDigitEndingWithZeroPartsFollowedByOneDigit(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).deleteCharAt(2).toString();
        return modifiedPart;
    }

    public String interprentTreeDigitWithZeroInTheMiddleParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).append("0", 1, 1).toString();
        return modifiedPart;
    }

    public String interprentTreeDigitWithoutZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).append("00", 1, 3).toString();
        return modifiedPart;
    }

    public String interprentTreeDigitWithoutZerosPartsB(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).append("0", 2, 3).toString();
        return modifiedPart;
    }

    public HashSet<String> getPhoneNumberInterpretationSet() {
        return phoneNumberInterpretationSet;
    }

}
