/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.numberinterpretation;

import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bizmi
 */
public class NumberAmbiguitiesIdentifierTest {

    public NumberAmbiguitiesIdentifierTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        NumberAmbiguitiesIdentifier.phoneNumberInterpretationSet.clear();
    }

    /**
     * Test of identifyNaturalNumberAmbiguities method, of class
     * NumberAmbiguitiesIdentifier.
     */
    @Test
    public void testIdentifyNaturalNumberAmbiguities() {
        NumberAmbiguitiesIdentifier instance = new NumberAmbiguitiesIdentifier();
        instance.getPhoneNumberInputOutput().setPhoneNumber("2 10 6 9 30 6 6 4");
        instance.setParts("2 10 6 9 30 6 6 4".split("\\s"));
        String[] expResult = {"2106930664", "210693664", "216930664", "21693664"};
        instance.identifyNaturalNumberAmbiguities();
        for (String number : expResult) {
            //tests if the above interpretations are included in the hashSet
            assertEquals(false, NumberAmbiguitiesIdentifier.phoneNumberInterpretationSet.add(number));
        }
        //test if only the above interpretations are included in the hashset
        assertEquals(4, NumberAmbiguitiesIdentifier.phoneNumberInterpretationSet.size());
    }

    @Test
    public void testIdentifyNaturalNumberAmbiguities2() {
        NumberAmbiguitiesIdentifier instance = new NumberAmbiguitiesIdentifier();
        instance.getPhoneNumberInputOutput().setPhoneNumber("69 106 6 9 30 6");
        instance.setParts("69 106 6 9 30 6".split("\\s"));
        String[] expResult = {"6910669306","69100669306","6910066936","691066936","60910669306","609100669306","60910066936","6091066936"};
        instance.identifyNaturalNumberAmbiguities();
        for (String number : expResult) {
            assertEquals(false, NumberAmbiguitiesIdentifier.phoneNumberInterpretationSet.add(number));
        }
                assertEquals(8, NumberAmbiguitiesIdentifier.phoneNumberInterpretationSet.size());
    }

    /**
     * Test of interprentTwoDigitNotEndingWithZeroParts method, of class NumberAmbiguitiesIdentifier.
     */
    @Test
    public void testInterprentTwoDigitNotEndingWithZeroParts() {
        String phoneNumberPart = "23";
        NumberAmbiguitiesIdentifier instance = new NumberAmbiguitiesIdentifier();
        String expResult = "20 3";
        String result = instance.interprentTwoDigitNotEndingWithZeroParts(phoneNumberPart);
        assertEquals(expResult, result);
    }

    /**
     * Test of interprentTwoDigitEndingWithZeroParts method, of class NumberAmbiguitiesIdentifier.
     */
    @Test
    public void testInterprentTwoDigitEndingWithZeroParts() {
        String phoneNumberPart = "30";
        NumberAmbiguitiesIdentifier instance = new NumberAmbiguitiesIdentifier();
        String expResult = "3";
        String result = instance.interprentTwoDigitEndingWithZeroParts(phoneNumberPart);
        assertEquals(expResult, result);
    }

    /**
     * Test of interprentTreeDigitEndingWithTwoZeroParts method, of class NumberAmbiguitiesIdentifier.
     */
    @Test
    public void testInterprentTreeDigitEndingWithTwoZeroParts() {
        System.out.println("interprentTreeDigitEndingWithTwoZeroParts");
        String phoneNumberPart = "300";
        NumberAmbiguitiesIdentifier instance = new NumberAmbiguitiesIdentifier();
        String expResult = "3";
        String result = instance.interprentTreeDigitEndingWithTwoZeroParts(phoneNumberPart);
        assertEquals(expResult, result);
    }

    /**
     * Test of interprentTreeDigitEndingWithZeroPartsFollowedByOneDigit method, of class NumberAmbiguitiesIdentifier.
     */
    @Test
    public void testInterprentTreeDigitEndingWithZeroPartsFollowedByOneDigit() {
        String phoneNumberPart = "300";
        NumberAmbiguitiesIdentifier instance = new NumberAmbiguitiesIdentifier();
        String expResult = "30";
        String result = instance.interprentTreeDigitEndingWithZeroPartsFollowedByOneDigit(phoneNumberPart);
        assertEquals(expResult, result);;
    }

    /**
     * Test of interprentTreeDigitWithZeroInTheMiddleParts method, of class NumberAmbiguitiesIdentifier.
     */
    @Test
    public void testInterprentTreeDigitWithZeroInTheMiddleParts() {
        String phoneNumberPart = "305";
        NumberAmbiguitiesIdentifier instance = new NumberAmbiguitiesIdentifier();
        String expResult = "3005";
        String result = instance.interprentTreeDigitWithZeroInTheMiddleParts(phoneNumberPart);
        assertEquals(expResult, result);
    }

    /**
     * Test of interprentTreeDigitWithoutZeroParts method, of class NumberAmbiguitiesIdentifier.
     */
    @Test
    public void testInterprentTreeDigitWithoutZeroParts() {
        String phoneNumberPart = "345";
        NumberAmbiguitiesIdentifier instance = new NumberAmbiguitiesIdentifier();
        String expResult = "30045";
        String result = instance.interprentTreeDigitWithoutZeroParts(phoneNumberPart);
        assertEquals(expResult, result);
    }

    /**
     * Test of interprentTreeDigitWithoutZerosPartsB method, of class NumberAmbiguitiesIdentifier.
     */
    @Test
    public void testInterprentTreeDigitWithoutZerosPartsB() {
        String phoneNumberPart = "345";
        NumberAmbiguitiesIdentifier instance = new NumberAmbiguitiesIdentifier();
        String expResult = "3405";
        String result = instance.interprentTreeDigitWithoutZerosPartsB(phoneNumberPart);
        assertEquals(expResult, result);
    }
}
