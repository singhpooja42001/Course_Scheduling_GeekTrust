package com.example.geektrust.DataTypeValidation;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;

public class IntegerValidation {
    public Integer validateTheGivenElementAndReturnTheIntegefFormat(String inputstring) throws CommonException {
        Integer integerToBeReturned=Integer.parseInt(inputstring);
        //validate that passed element is a string
        if(integerToBeReturned instanceof Integer)
        {
           return integerToBeReturned;
        }else
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
    }
}
