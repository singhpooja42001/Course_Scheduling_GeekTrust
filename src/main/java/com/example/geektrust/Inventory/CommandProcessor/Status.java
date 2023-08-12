package com.example.geektrust.Inventory.CommandProcessor;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;

public enum Status {
    ACCEPTED,
    CANCEL_ACCEPTED,
    CANCEL_REJECTED,
    CONFIRMED,
    COURSE_CANCELED;

    String status;

    Status(String accepted) {
        this.status = accepted;
    }

    Status() {

    }

    public static String showStatus(String status) throws CommonException {
        for (Status s:values()) {
            if(s.name().equals(status))
            {
                return s.status;
            }
        }
        throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
    }
}
