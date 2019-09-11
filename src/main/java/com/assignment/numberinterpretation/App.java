package com.assignment.numberinterpretation;



public class App 
{
    public static void main( String[] args )
    {
       PhoneNumberInputOutput nio=new PhoneNumberInputOutput();
       GreekNumberValidation gnv=new GreekNumberValidation();
       nio.numberInput();
       nio.numberOutput();
       gnv.checkIfPhoneNumberIsValid();

    }
}
