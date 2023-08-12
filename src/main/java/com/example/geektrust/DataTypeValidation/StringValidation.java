package com.example.geektrust.DataTypeValidation;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;

public class StringValidation  {
    public String validateTheGivenElementAndReturnTheStringFormat(String inputstring) throws CommonException {
        String stringToBbeReturned="";
        //validate that passed element is a string
        if(inputstring instanceof String)
        {
            stringToBbeReturned=inputstring;
        }else
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
        return stringToBbeReturned;
    }
}
