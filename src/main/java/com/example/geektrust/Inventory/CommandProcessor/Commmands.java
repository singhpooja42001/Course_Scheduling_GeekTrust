package com.example.geektrust.Inventory.CommandProcessor;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;
import com.example.geektrust.Inventory.CommandProcessor.model.Course;
import com.example.geektrust.Inventory.Inventory;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Commmands {

    String baseCommand="";
    ArrayList<String> remainingCommands = new ArrayList<String>();
    Course course = new Course();

    // It will take each command which is whole string and initialize the instance variable baseCommand,remainingCommand
    // and baseCommandsAndTheirRemainingString.
    public  Commmands(String inputcommand) throws CommonException {
        //ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2
        ArrayList<String> tokensOfCommand = new ArrayList<String>();

       StringTokenizer tokens = new StringTokenizer(inputcommand);
       while(tokens.hasMoreTokens())
       {
           tokensOfCommand.add(tokens.nextToken());
       }

        this.baseCommand=tokensOfCommand.get(0);

       //add base command to the enums.

        for (int i = 0; i < tokensOfCommand.size(); i++) {
            if(i!=0)
            {
                this.remainingCommands.add(tokensOfCommand.get(i));
            }
        }
    }

    public void executeCommand(Commmands commands) throws CommonException {
        String basecommand = BaseCommands.from(commands.baseCommand);
        switch(basecommand)
        {
            case "ADD-COURSE-OFFERING": Inventory.inventory.put(new Course(commands.remainingCommands),new ArrayList<>()); //adding the course object to inventory.
                break;
            case "ALLOT" : course.allot(commands.remainingCommands);
                break;
            case "REGISTER" : course.register(commands.remainingCommands);                                       //giving the inventory object and the remaining commands of register.
                break ;
            case "CANCEL" : course.cancel(commands.remainingCommands);
                break;
            default:
                    throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
    }

}
