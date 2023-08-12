package com.example.geektrust.DataTypeValidation;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;

public class EmailValidation {
    public String validateTheGivenElementAndReturnTheEmailFormat(String inputstring) throws CommonException {

        if(!(inputstring.endsWith("@GMAIL.COM")))
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
        return inputstring;
    }

}
