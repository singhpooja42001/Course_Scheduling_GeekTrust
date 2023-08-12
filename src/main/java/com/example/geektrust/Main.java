package com.example.geektrust;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.IOManager.HandleInputFile;
import com.example.geektrust.Inventory.CommandProcessor.CommandProcessing;

public class Main {
    public static void main(String[] args) {
        try {//ADD-COURSE-OFFERING JAVA JAMES 15062023 1 2
            CommandProcessing.getArrayListAndProcessItAsCommand(HandleInputFile.openFileAndGetArrayListOfCommands(args[0]));
        } catch (CommonException e) {
            System.out.println("INPUT_DATA_ERROR");
        }
    }
}
/*
ADD-COURSE-OFFERING is correct
REGISTER is correct
CANCEL is incorrect
ALLOT after reg info name should not appear confirmed is showing not confirmed  and course_cancelled is good
 */