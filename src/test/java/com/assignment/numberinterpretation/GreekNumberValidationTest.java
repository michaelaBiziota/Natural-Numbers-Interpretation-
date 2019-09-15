/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.numberinterpretation;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;

/**
 *
 * @author bizmi
 */
public class GreekNumberValidationTest {

    public GreekNumberValidationTest() {
    }

    @Test
    public void testCheckInvalidPhoneNumber() {
        boolean expResult = false;
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("69889089"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("69889089001"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("6788908900"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("288908900"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("28890890008"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("003028908900086"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("0030289089000"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("003069890890005"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("0030698908900"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("00326989089003"));

    }

    @Test
    public void testCheckValidPhoneNumber() {
        boolean expResult = true;
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("6988908967"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("2188908900"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("00302890890006"));
        assertEquals(expResult, GreekNumberValidation.checkIfPhoneNumberIsValid("00306989089000"));
    }

    /**
     * Test of checkInputValidation method, of class GreekNumberValidation.
     */
    @Test
    public void testCheckInputValidation() {
        GreekNumberValidation instance = new GreekNumberValidation();
        assertEquals(false, instance.checkInputValidation("69 88 89 89 35"));
        assertEquals(false, instance.checkInputValidation("69 885 896 897 35"));
        assertEquals(false, instance.checkInputValidation("6 885 896 8 35"));
        assertEquals(true, instance.checkInputValidation("6985898731"));
        assertEquals(true, instance.checkInputValidation("asd 34 5"));
        assertEquals(true, instance.checkInputValidation("asd gfd g"));
        assertEquals(true, instance.checkInputValidation("asdgfdg"));

    }

}
