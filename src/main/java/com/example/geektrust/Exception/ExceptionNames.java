package com.example.geektrust.Exception;

public enum ExceptionNames {
    dataInvalid("INPUT_DATA_ERROR"),
    courseFull("COURSE_FULL_ERROR");

    final String exceptionName;

    ExceptionNames(String exception) {
        this.exceptionName=exception;
    }

    public static String fetchException(String dataPassedForMapping)//dataInvalid
    {
        for (ExceptionNames exceptions:values()) {
            if(exceptions.name().equals(dataPassedForMapping))
            {
                return exceptions.exceptionName;
            }
        }
        return null;
    }
}
