package com.example.geektrust.Inventory.CommandProcessor.model;

import com.example.geektrust.DataTypeValidation.DateValidation;
import com.example.geektrust.DataTypeValidation.IntegerValidation;
import com.example.geektrust.DataTypeValidation.StringValidation;
import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;
import com.example.geektrust.Inventory.Inventory;
import java.util.ArrayList;
import java.util.Map;

public class Course {

    public String courseName;
    public String instructorName;
    public String courseStartDate;
    Integer minNoOfEmployee;
    public String courseId;
    public Integer maximumNumberOfEmployee;
    StringValidation stringValidation = new StringValidation();
    DateValidation dateValidation = new DateValidation();
    IntegerValidation integerValidation = new IntegerValidation();

    public Course(ArrayList<String> remainingCommands) throws CommonException {
        try {
            this.courseName = stringValidation.validateTheGivenElementAndReturnTheStringFormat(remainingCommands.get(0));
            this.instructorName = stringValidation.validateTheGivenElementAndReturnTheStringFormat(remainingCommands.get(1));
            this.courseStartDate = dateValidation.validateTheGivenElementAndReturnTheDataFormat(remainingCommands.get(2));
            this.minNoOfEmployee = integerValidation.validateTheGivenElementAndReturnTheIntegefFormat(remainingCommands.get(3));
            this.maximumNumberOfEmployee = integerValidation.validateTheGivenElementAndReturnTheIntegefFormat(remainingCommands.get(4));
        }catch (IndexOutOfBoundsException e)
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
//        validateAllInput();
        this.courseId="OFFERING-"+this.courseName+"-"+this.instructorName;
        courseOutput();
    }

    private void courseOutput() {
        System.out.println("OFFERING-"+this.courseName+"-"+this.instructorName);
    }

    public Course()
    {

    }

    private void validateAllInput() throws CommonException {
        //1. no duplicate value i.e with same course name and instructor name.
        //for the CourseTest class
        if(Inventory.inventory.size() == 0)
        {
            return;
        }else {
            NoDuplicateSameCourseAndInstructorName();
        }
        //1.min should be less than max.
        minIsLessThanMax();
    }

    private void minIsLessThanMax() throws CommonException {
        if(!(this.minNoOfEmployee<this.maximumNumberOfEmployee))
        {
            throw  new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
    }

    private void NoDuplicateSameCourseAndInstructorName() throws CommonException {
        for (Map.Entry<Course,ArrayList<Register>> map:Inventory.inventory.entrySet()) {
            if(map.getKey().instructorName.equals(this.instructorName) || map.getKey().courseName.equals(this.courseName)){
                throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
            }
        }
    }

    public String allot(ArrayList<String> remainingCommands) throws CommonException { //ALLOT OFFERING-JAVA-JAMES
        Allotment allot = new Allotment(remainingCommands);
        //check if courses are there in the inventory or not.
        Inventory.checkIfCoursesExistInInventory();
        //If sufficient registrations are not received then the course offering itself gets cancelled.
        allot.checkIfSufficientRegistrationtIsRecieved(remainingCommands.get(0),allot);
        allot.updateTheStatusOfAllotmentInInventory(allot,remainingCommands.get(0));
        allot.printTheAllotedCourses(allot.courseId);//REG-COURSE-WOO-JAVA WOO@GMAIL.COM OFFERING-JAVA-JAMES JAVA JAMES 15062022 CONFIRMED
        return "sucessfully";
    }


    public void cancel(ArrayList<String> remainingCommands) throws CommonException { // CANCEL REG-COURSE-BOBY-PYTHON
        Cancel cancel =new Cancel(remainingCommands); //CANCEL REG-COURSE-BOBY-PYTHON  REG-COURSE-BOBY-PYTHON CANCEL_ACCEPTED
        //check if the courses are there in inventory or not.
        Inventory.checkIfCoursesExistInInventory();
        //check if registration is done for the course before cancelling it.
        cancel.checkIfRegistrationIsDoneForCourseByEmployee(remainingCommands.get(0),cancel); // REG-COURSE-BOBY-PYTHON
        //If course allotment is not completed then employee cannot cancel the course.
        String cancelStatus = cancel.checkIfAllotmentIsNotDoneAndUpdateStatus(remainingCommands.get(0),cancel);
        if(cancelStatus.equals("CANCEL_ACCEPTED"))
        {
            cancel.removeRegisteredCourseFromInventory(cancel.registrationId);
        }
//        cancel.updateTheCancelStatusInInventory(cancel,remainingCommands.get(0));
        cancel.printCancel(remainingCommands);
    }

    public void register(ArrayList<String> remainingCommands) throws CommonException {   //REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES
        //we will see the inventory courses and register into them.
        Register register = new Register(remainingCommands);
        try {
            Inventory.checkIfCoursesExistInInventory();
        }catch (CommonException e)
        {

        }
        register.validateTheGivenCourseExist(remainingCommands.get(1));
        String registerStatus = register.checkIfCourseIsNotFull(remainingCommands.get(1),register);
        register.computeRegistrationID(register,remainingCommands,registerStatus);
        register.registerForTheCourseInInventory(register);
        System.out.println(register.RegistrationID+" "+register.registerStatus);
    }

}

