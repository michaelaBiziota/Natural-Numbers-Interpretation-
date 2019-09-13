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
public class NumberAmbiguitiesIdentifier {

    private PhoneNumberInputOutput phoneNumberInputOutput = new PhoneNumberInputOutput();
    public static HashSet<String> phoneNumberInterpretationSet = new HashSet<String>();
    private String[] parts;

    public void identifyNaturalNumberAmbiguities() {
        phoneNumberInterpretationSet.add(phoneNumberInputOutput.getPhoneNumber().replaceAll("\\s", ""));

        for (int i = 0; i < parts.length; i++) {
            //element of input list is 13-19, 21-29 , 31-39, ... , 91-99   
            if (parts[i].length() == 2 && !parts[i].endsWith("0")
                    && !parts[i].equals("11") && !parts[i].equals("12")) {
                String temp = new String(parts[i]);
                parts[i] = interprentTwoDigitNotEndingWithZeroParts(parts[i]);
                String interpretation = String.join("",parts);
                phoneNumberInterpretationSet.add(interpretation.replaceAll(" ",""));
                identifyNaturalNumberAmbiguities();
                parts[i] =temp;
                
            }
            if (parts.length - i > 1) {
                if (parts[i].length() == 2 && parts[i].endsWith("0")
                        && parts[i + 1].length() == 1 && !parts[i + 1].equals("0")
                        && !(parts[i].equals("10") && (parts[i + 1].equals("1") || parts[i + 1].equals("2")))) {
                    String temp = new String(parts[i]);
                    parts[i] = interprentTwoDigitEndingWithZeroParts(parts[i]);
                    String interpretation = String.join("", parts);
                    phoneNumberInterpretationSet.add(interpretation.replaceAll(" ",""));
                    identifyNaturalNumberAmbiguities();
                    parts[i] = temp;
                }
                //e.g 800 34->80034 or 834
                if (parts[i].length() == 3 && parts[i].endsWith("00")
                        && parts[i + 1].length() == 2) {
                    String temp = new String(parts[i]);
                    parts[i] = interprentTreeDigitEndingWithTwoZeroParts(parts[i]);
                    String interpretation = String.join("", parts);
                    phoneNumberInterpretationSet.add(interpretation.replaceAll(" ",""));
                    identifyNaturalNumberAmbiguities();
                    parts[i] = temp;
                }
                //e.g 800 3-> 8003 or 803 but 800 0-> 8000
                if (parts[i].length() == 3 && parts[i].endsWith("00")
                        && parts[i + 1].length() == 1 && !parts[i + 1].equals("0")) {
                    String temp = new String(parts[i]);
                    parts[i] = interprentTreeDigitEndingWithZeroPartsFollowedByOneDigit(parts[i]);
                    String interpretation = String.join("", parts);
                    phoneNumberInterpretationSet.add(interpretation.replaceAll(" ",""));
                    identifyNaturalNumberAmbiguities();
                    parts[i] = temp;
                }
                //e.g 820 4->8204 or 824 but 820 0->8200
                if (parts[i].length() == 3 && parts[i].charAt(1) != '0' && parts[i].endsWith("0")
                        && parts[i + 1].length() == 1 && !parts[i + 1].equals("0")) {
                    String temp = new String(parts[i]);
                    parts[i] = interprentTreeDigitEndingWithZeroPartsFollowedByOneDigit(parts[i]);
                    String interpretation = String.join("", parts);
                    phoneNumberInterpretationSet.add(interpretation.replaceAll(" ",""));
                    identifyNaturalNumberAmbiguities();
                    parts[i] = temp;
                }
            }
            //e.g 802 ->802 or 800 2 but 800 0->8000
            if (parts[i].length() == 3 && parts[i].charAt(1) == '0' && !parts[i].endsWith("0")) {
                String temp = new String(parts[i]);
                parts[i] = interprentTreeDigitWithZeroInTheMiddleParts(parts[i]);
                String interpretation = String.join("", parts);
                phoneNumberInterpretationSet.add(interpretation.replaceAll(" ",""));
                identifyNaturalNumberAmbiguities();
                parts[i] = temp;
            }
//            //e.g 825->80025 and 820 5 and 800 20 5 (but 811->800 11 and 812->80012)
            if (parts[i].length() == 3 && parts[i].indexOf("0") < 0) {
                String temp = new String(parts[i]);
                String temp1 = new String(parts[i]);
                parts[i] = interprentTreeDigitWithoutZeroParts(parts[i]);
                String interpretation = String.join("", parts);
                phoneNumberInterpretationSet.add(interpretation.replaceAll(" ",""));
                if (!temp.endsWith("11") && !temp.endsWith("12")) {
                    parts[i] = parts[i].substring(0, 3) + interprentTwoDigitNotEndingWithZeroParts(temp.substring(1, 3));
                    String secondInterpretation = String.join("", parts);
                    phoneNumberInterpretationSet.add(secondInterpretation.replaceAll(" ",""));
                }
                parts[i] = temp;
                parts[i] = interprentTreeDigitWithoutZerosPartsB(parts[i]);
                String secondInterpretation = String.join("", parts);
                phoneNumberInterpretationSet.add(secondInterpretation.replaceAll(" ",""));
                identifyNaturalNumberAmbiguities();
                parts[i] = temp1;
            }
            }}
    

    public void setParts(String[] parts) {
        this.parts = parts;
    }

    public void splitPhoneNumberIntoParts() {
        setParts(phoneNumberInputOutput.getPhoneNumber().split("\\s"));
    }

    public String interprentTwoDigitNotEndingWithZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).insert(1,"0 ").toString();
        return modifiedPart;
    }

    public String interprentTwoDigitEndingWithZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).deleteCharAt(1).toString();
        return modifiedPart;
    }

    public String interprentTreeDigitEndingWithTwoZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).delete(1,3).toString();
        return modifiedPart;
    }

    public String interprentTreeDigitEndingWithZeroPartsFollowedByOneDigit(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).deleteCharAt(2).toString();
        return modifiedPart;
    }

    public String interprentTreeDigitWithZeroInTheMiddleParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).insert(1,"0").toString();
        return modifiedPart;
    }

    public String interprentTreeDigitWithoutZeroParts(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).insert(1,"00").toString();
        return modifiedPart;
    }

    public String interprentTreeDigitWithoutZerosPartsB(String phoneNumberPart) {
        String modifiedPart = new StringBuilder().append(phoneNumberPart).insert(2,"0").toString();
        return modifiedPart;
    }

    public HashSet<String> getPhoneNumberInterpretationSet() {
        return phoneNumberInterpretationSet;
    }

}
