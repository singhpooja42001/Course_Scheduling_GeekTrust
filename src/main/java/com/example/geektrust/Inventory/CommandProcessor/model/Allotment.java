package com.example.geektrust.Inventory.CommandProcessor.model;

import com.example.geektrust.DataTypeValidation.StringValidation;
import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;
import com.example.geektrust.Inventory.CommandProcessor.Status;
import com.example.geektrust.Inventory.Inventory;

import java.util.*;

public class Allotment {

    String courseId;
    String StatusOfAllotment;
    Course course = new Course();

    public Allotment(ArrayList<String> remainingCommands) throws CommonException {

        try {
            StringValidation stringValidation = new StringValidation();
            this.courseId = stringValidation.validateTheGivenElementAndReturnTheStringFormat(remainingCommands.get(0));
        }catch (IndexOutOfBoundsException e)
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }

            }
        public Allotment()
        {

        }

    public boolean checkIfSufficientRegistrationtIsRecieved(String courseId, Allotment allot) { //ALLOT OFFERING-DATASCIENCE-BOB
       /* If sufficient registrations are not received then the course offering itself gets cancelled.
        I will see the accepted status of the registration-status.*/
        int acceptedStatus = getNoOfAcceptedStatusForCourseRegistration(courseId);
        course= Inventory.getCourseByCourseId(courseId);
        /* If the minimum number of employees for the course offering is not reached before the course date,
         the status of the course offering would be COURSE_CANCELED */
        if(acceptedStatus>=course.minNoOfEmployee && acceptedStatus<=course.maximumNumberOfEmployee)
        {
            allot.StatusOfAllotment= Status.CONFIRMED.name();
            return true;
        }else
        {
            allot.StatusOfAllotment= Status.COURSE_CANCELED.name();
        }
        return false;
    }

    private int getNoOfAcceptedStatusForCourseRegistration(String courseId) {
        int count=0;
        for (Register register: Inventory.getRegisterByCourseId(courseId)) {
            if(register.registerStatus.equals("ACCEPTED"))
            {
                count++;
            }
        }
        return count;
    }


    public void updateTheStatusOfAllotmentInInventory(Allotment allot,String courseId) {
        for(Register r:Inventory.getRegisterByCourseId(courseId))
        {
            if(r.registerStatus.equals(Status.ACCEPTED.name()))
            {
                r.allotmentStatus=allot.StatusOfAllotment;
            }
        }
    }

    public void printTheAllotedCourses(String courseId) {//REG-COURSE-WOO-JAVA WOO@GMAIL.COM OFFERING-JAVA-JAMES JAVA JAMES 15062022 CONFIRMED
        sortInventory();
        course = Inventory.getCourseByCourseId(courseId);
        for (Register r : Inventory.getRegisterByCourseId(courseId)) {
            System.out.println(r.RegistrationID+" "+r.email+" "+r.courseId+" "+course.courseName+" "+course.instructorName+" "+course.courseStartDate+" "+r.allotmentStatus);
        }
    }

    //The list should be sorted based on the Registration number, The output should be sorted by course-registration-id in ascending order
    public void sortInventory()
    {
        for (Map.Entry<Course,ArrayList<Register>> i:Inventory.inventory.entrySet()) {

            Collections.sort(i.getValue(), new Comparator<Register>() {
                @Override
                public int compare(Register o1, Register o2) {
                    return o1.RegistrationID.compareTo(o2.RegistrationID);
                }
            });
        }
    }
}
/*

The employees who have registered will get confirmed unless the minimum number of registrations is not received.
Even if the course offering gets canceled due to the minimum number of employees not registered, the list should be printed.
 */
