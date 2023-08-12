package com.example.geektrust.DataTypeValidation;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidation {

    final static String DATE_FORMAT = "ddMMyyyy";

    public String validateTheGivenElementAndReturnTheDataFormat(String date) throws CommonException {
        if(date.length()!=8)
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
        try {
            Date d=new Date();
            SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return date;
        } catch (ParseException e) {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
    }

}