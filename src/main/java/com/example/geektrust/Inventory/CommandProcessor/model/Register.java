package com.example.geektrust.Inventory.CommandProcessor.model;

import com.example.geektrust.DataTypeValidation.EmailValidation;
import com.example.geektrust.DataTypeValidation.StringValidation;
import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;
import com.example.geektrust.Inventory.CommandProcessor.Status;
import com.example.geektrust.Inventory.Inventory;
import java.util.ArrayList;


public class Register implements Comparable<Register>{
    String email;
    String RegistrationID;
    String registerStatus;
    String courseId;
    String allotmentStatus;
    String cancelStatus;
    String employeeName;

    Course course = new Course();
    ArrayList<Register> registers = new ArrayList<>();

    public Register(ArrayList<String> remainingCommands) throws CommonException {  //ANDY@GMAIL.COM OFFERING-JAVA-JAMES
        try {
            StringValidation stringValidation = new StringValidation();
            EmailValidation emailValidation = new EmailValidation();

            this.email = emailValidation.validateTheGivenElementAndReturnTheEmailFormat(remainingCommands.get(0));
            this.courseId = stringValidation.validateTheGivenElementAndReturnTheStringFormat(remainingCommands.get(1));
        }catch (IndexOutOfBoundsException e)
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
    }

    public Register() {

    }

    //checking if the given course exist or not.
    public  void validateTheGivenCourseExist(String courseId) throws CommonException {
        course = Inventory.getCourseByCourseId(courseId);
        if(course==null)
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
    }

    public String checkIfCourseIsNotFull(String courseId,Register register) throws CommonException {
        //checking that the course seat is available or not.
        registers = Inventory.getRegisterByCourseId(courseId);
        course = Inventory.getCourseByCourseId(courseId);
        if((registers.size() >= course.maximumNumberOfEmployee))
        {
            throw new CommonException(ExceptionNames.fetchException("courseFull"));
        }else
        {
            return Status.ACCEPTED.name();
        }
    }

    public void registerForTheCourseInInventory(Register register) {
        registers = Inventory.getRegisterByCourseId(register.courseId);
        registers.add(register);
    }


    public void computeRegistrationID(Register register,ArrayList<String> a,String status) {//REG-COURSE-ANDY-PYTHON ACCEPTED
        String courseName;
        course = Inventory.getCourseByCourseId(register.courseId);
        courseName = course.courseName;
        register.RegistrationID= "REG-COURSE-"+a.get(0).substring(0,register.email.length()-"@gmail.com".length())+"-"+courseName;
        register.registerStatus=status;
        register.employeeName=a.get(0).substring(0,register.email.length()-"@gmail.com".length());
    }

    public void checkIfCoursesExistInInventoryBeforeRegistration() throws CommonException {
        if(Inventory.inventory.size()==0)
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
    }

    @Override
    public int compareTo(Register o) {
        return this.RegistrationID.compareTo(o.RegistrationID);
    }
}
/*
 If the minimum number of employees for the course offering is not reached before the course date,
 the status of the course offering would be COURSE_CANCELED
 */
