package com.example.geektrust.Inventory.CommandProcessor;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;

import java.util.ArrayList;
public class CommandProcessing {

    //it will give each command to the commands and it will execute according to the command.
    public static Object getArrayListAndProcessItAsCommand(ArrayList<String> input) throws CommonException {
        // this command processor will take the arraylist of string i.e command and provide it one by open to Commands
        // class which will send further to desired commands.
        for (String commands:input) {

            //passing the input string i.e command to the Command constructor.
            Commmands command = new Commmands(commands);

            try {
                //execute-command will be called giving Command object as parameter.
                command.executeCommand(command);
            }catch (CommonException e)
            {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}
