package com.example.geektrust.IOManager;

import com.example.geektrust.Exception.CommonException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;
import java.util.*;

import static com.example.geektrust.IOManager.HandleInputFile.openFileAndGetArrayListOfCommands;
import static org.junit.jupiter.api.Assertions.*;

class HandleInputFileTest {

    String FileNameGivenButItDoesNotExist="input.txt";

    @Test
    public void openFileAndGetCommandAsStringTestWithNoInputTest() throws FileNotFoundException, CommonException {

        ArrayList<String> FileNameGivenAndItExist = new ArrayList<String>();
        ArrayList<String> outputOfTestWithWrongFileInput = new ArrayList<String>();

        FileNameGivenAndItExist.add("ADD-COURSE-OFFERING JAVA JAMES 15062023 1 2");
        FileNameGivenAndItExist.add("ADD-COURSE-OFFERING PYTHON");
        FileNameGivenAndItExist.add("ADD-COURSE-OFFERING KUBERNETES WOODY 16062022 2 5");
        FileNameGivenAndItExist.add("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
        FileNameGivenAndItExist.add("REGISTER WOO@GMAIL.COM OFFERING-JAVA-JAMES");
        FileNameGivenAndItExist.add("REGISTER ALICE@GMAIL.COM OFFERING-JAVA-JAMES");
        FileNameGivenAndItExist.add("REGISTER JON");
        FileNameGivenAndItExist.add("ALLOT OFFERING-JAVA-JAMES");

        assertThrows(CommonException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                openFileAndGetArrayListOfCommands(FileNameGivenButItDoesNotExist);
            }
        });
        assertEquals(FileNameGivenAndItExist, HandleInputFile.openFileAndGetArrayListOfCommands("sample_input\\input1.txt"));
    }

}