/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.numberinterpretation;

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
public class GreekNumberValidationTest {
    
    public GreekNumberValidationTest() {
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
    }

    /**
     * Test of checkIfPhoneNumberIsValid method, of class GreekNumberValidation.
     */
    @Test
    public void testCheckIfPhoneNumberIsValid() {
        System.out.println("checkIfPhoneNumberIsValid");
        String phoneNumber = "";
        boolean expResult = false;
        boolean result = GreekNumberValidation.checkIfPhoneNumberIsValid(phoneNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkInputValidation method, of class GreekNumberValidation.
     */
    @Test
    public void testCheckInputValidation() {
        System.out.println("checkInputValidation");
        GreekNumberValidation instance = new GreekNumberValidation();
        boolean expResult = false;
        boolean result = instance.checkInputValidation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
