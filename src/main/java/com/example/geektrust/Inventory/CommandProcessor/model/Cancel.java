package com.example.geektrust.Inventory.CommandProcessor.model;

import com.example.geektrust.DataTypeValidation.StringValidation;
import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;
import com.example.geektrust.Inventory.CommandProcessor.Status;
import com.example.geektrust.Inventory.Inventory;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

public class Cancel {
    String cancelStatus;
    String registrationId;
    String employeeName;
    String courseName;

    ArrayList<Register> register = new ArrayList<Register>();
    Course course = new Course();

    public Cancel(ArrayList<String> inputCommands) throws CommonException {

        try {
            StringValidation stringValidation = new StringValidation();
            this.registrationId = stringValidation.validateTheGivenElementAndReturnTheStringFormat(inputCommands.get(0));
            ArrayList<String> arrayList = new ArrayList<String>();
            StringTokenizer tokens = new StringTokenizer(inputCommands.get(0), "-");
            while (tokens.hasMoreTokens()) {
                arrayList.add(tokens.nextToken());
            }
            this.employeeName = arrayList.get(2);
            this.courseName = arrayList.get(3);
        } catch (IndexOutOfBoundsException e) {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
    }


    public String checkIfAllotmentIsNotDoneAndUpdateStatus(String s, Cancel cancel) throws CommonException {//CANCEL REG-COURSE-ANDY-JAVA
        //if allotment status for the given registration id is null then can be cancelled.
        course = Inventory.getCourseByCourseName(cancel.courseName);
        if (course == null) {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
        for (Register r : Inventory.getRegisterByCourseName(cancel.courseName)) {
            if (r.RegistrationID.equals(cancel.registrationId) && r.allotmentStatus == null) {
                cancel.cancelStatus=Status.CANCEL_ACCEPTED.name();
                return Status.CANCEL_ACCEPTED.name();
            }
        }
        return Status.CANCEL_REJECTED.name();
    }


   /* public void updateTheCancelStatusInInventory(Cancel cancel, String s) {
        for (Map.Entry<Course, ArrayList<Register>> map : Inventory.inventory.entrySet()) {
            if (map.getKey().instructorName.equals(cancel.employeeName) && map.getKey().courseName.equals(cancel.courseName)) {
                for (Register r : map.getValue()) {
                    if (r.RegistrationID.equals(s))
                        r.cancelStatus = cancel.cancelStatus;
                }
            }
        }
    }*/

    public void checkIfRegistrationIsDoneForCourseByEmployee(String s, Cancel cancel) throws CommonException { //  REG-COURSE-BOBY-PYTHON
        ArrayList<Register> register = Inventory.getRegisterByCourseName(cancel.courseName);
        for (Register r : register) {
            if (r.employeeName.equals(cancel.employeeName) && !r.registerStatus.equals("ACCEPTED")) {
                throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
            }
        }
    }

    public void removeRegisteredCourseFromInventory(String registrationId) {
        for (Map.Entry<Course, ArrayList<Register>> map : Inventory.inventory.entrySet()) {
            for (Register r : map.getValue()) {
                if(r.RegistrationID.equals(registrationId))
                {
                    map.getValue().remove(r);
                    break;
                }
            }
        }
    }

    public void printCancel(ArrayList<String> remainingCommands) {
        System.out.println(remainingCommands.get(0)+" "+cancelStatus);
    }
}
