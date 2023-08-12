package com.example.geektrust.Inventory.CommandProcessor;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;

public enum BaseCommands {

    FIRST("ADD-COURSE-OFFERING"),
    SECOND ("REGISTER"),
    THIRD ("CANCEL"),
    FOURTH ("ALLOT");

    final String commands;

    BaseCommands(java.lang.String s) {
        this.commands=s;
    }

    public static String from(String commands) throws CommonException {
        for (BaseCommands baseCommands:values()) {
            if(commands.equalsIgnoreCase(baseCommands.commands))
            {
                return commands;
            }
        }
        throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
    }
}
