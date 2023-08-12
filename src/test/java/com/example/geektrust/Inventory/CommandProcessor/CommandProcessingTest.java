package com.example.geektrust.Inventory.CommandProcessor;

import com.example.geektrust.Exception.CommonException;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessingTest {

    @Test
    public  void getArrayListAndProcessItAsCommand() throws CommonException {

        ArrayList<String> listForInputToCommandProcessor = new ArrayList<>();


        listForInputToCommandProcessor.add("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        listForInputToCommandProcessor.add("ADD-COURSE-OFFERING PYTHON");
        listForInputToCommandProcessor.add("ADD-COURSE-OFFERING KUBERNETES WOODY 16062022 2 5");
        listForInputToCommandProcessor.add("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
        listForInputToCommandProcessor.add("REGISTER WOO@GMAIL.COM OFFERING-JAVA-JAMES");
        listForInputToCommandProcessor.add("REGISTER ALICE@GMAIL.COM OFFERING-JAVA-JAMES");
        listForInputToCommandProcessor.add("REGISTER JON");
        listForInputToCommandProcessor.add("ALLOT OFFERING-JAVA-JAMES");

        ArrayList<String> listOfNonExceptionArisingInput = new ArrayList<>();
        listOfNonExceptionArisingInput.add("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        listOfNonExceptionArisingInput.add("ADD-COURSE-OFFERING KUBERNETES WOODY 16062022 2 5");


        //when any validation error or index out of bound error then error throws.
        assertNull(CommandProcessing.getArrayListAndProcessItAsCommand(listForInputToCommandProcessor));

        //when no exception will be thrown
        assertNull(CommandProcessing.getArrayListAndProcessItAsCommand(listOfNonExceptionArisingInput));
    }
}