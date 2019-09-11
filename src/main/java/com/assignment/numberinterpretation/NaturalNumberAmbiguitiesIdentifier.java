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
       HashSet<String> phoneNumberInterpretation = new HashSet<String>();
       
       public void identifyNaturalNumberAmbiguities(){
       String phoneNumber= phoneNumberInputOutput.getPhoneNumber();
       int i;
       for(i=0; i<= phoneNumber.indexOf(" ");i++){
       
       }
       
       }
       
       
       public long countTotalSequences(String phoneNumber){
long count=phoneNumber.chars().filter(ch-> ch == ' ').count();
return count;
       }
       
}
