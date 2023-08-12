package com.example.geektrust.IOManager;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HandleInputFile {

    private static final ArrayList<String> outputStringsFromFile = new ArrayList<String>();

    public static ArrayList<String> openFileAndGetArrayListOfCommands(String input) throws CommonException {

        try {
            //1.after validating that value is there we will open file and fill the value to an arraylist.
            //suppose the given file name is incorrect, then error will be thrown.
            FileInputStream fileHandle = new FileInputStream(input);
            Scanner scanner = new Scanner(fileHandle);
            while (scanner.hasNext()) {
                outputStringsFromFile.add(scanner.nextLine().trim());
            }
        }catch(Exception e)
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }

        return outputStringsFromFile;
    }
}
