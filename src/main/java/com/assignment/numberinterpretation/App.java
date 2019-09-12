package com.assignment.numberinterpretation;



public class App 
{
    public static void main( String[] args )
    {
       PhoneNumberInputOutput nio=new PhoneNumberInputOutput();
       GreekNumberValidation gnv=new GreekNumberValidation();
       NaturalNumberAmbiguitiesIdentifier nnai=new NaturalNumberAmbiguitiesIdentifier();
       nio.numberInput();
//       nio.numberOutput();
//       gnv.checkIfPhoneNumberIsValid();
nnai.identifyNaturalNumberAmbiguities();
nio.numberOutput(nnai);

    }
}
