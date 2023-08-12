package com.example.geektrust.Inventory.CommandProcessor;

import com.example.geektrust.Exception.CommonException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommmandsTest {

    String baseCommand="ADD-COURSE-OFFERING";
    ArrayList<String> remainingCommands = new ArrayList<String>();
    String notEnoughElementProvided="ADD-COURSE-OFFERING JAVA";
    String ElementProvidedButNotValidBaseCommand="COURSE-OFFERING JAVA";
    String validElementProvided="ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2";

    @Test
    public void executeCommandExceptionOccurs() throws CommonException {
        assertThrows(CommonException.class, new Executable() {
            @Override
            public void execute() throws Throwable,CommonException {
                Commmands commands = new Commmands(notEnoughElementProvided);
                commands.executeCommand(commands);
            }
        });
    }

  /*  @Test
    public void executeCommandExceptionNotOccurs() throws CommonException {
        *//*
        Commmands commands = new Commmands(validElementProvided);
        assertNull(commands.executeCommand(commands));
         *//*
    }

    @Test
    public void ConstructorTest() throws CommonException {
//        Commmands command = new Commmands(validElementProvided);
//        remainingCommands.add();
    }*/
}