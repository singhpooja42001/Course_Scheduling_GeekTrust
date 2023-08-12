package com.example.geektrust.Inventory.CommandProcessor.model;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Inventory.Inventory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void allot() throws CommonException {

        ArrayList<String> courseOfferingAdded = new ArrayList<>();
        courseOfferingAdded.add("JAVA");
        courseOfferingAdded.add("JAMES");
        courseOfferingAdded.add("15062022");
        courseOfferingAdded.add("1");
        courseOfferingAdded.add("2");
        Course inventoryKey = new Course(courseOfferingAdded);

        //register
        ArrayList<Register> inventoryValue= new ArrayList<>();

        ArrayList<String> registerCourseOffering1 = new ArrayList<>();
        registerCourseOffering1.add("ANDY@GMAIL.COM");
        registerCourseOffering1.add("OFFERING-JAVA-JAMES");

        ArrayList<String> registerCourseOffering2 = new ArrayList<>();
        registerCourseOffering2.add("WOO@GMAIL.COM");
        registerCourseOffering2.add("OFFERING-JAVA-JAMES");

        ArrayList<String> registerCourseOffering3 = new ArrayList<>();
        registerCourseOffering3.add("ALICE@GMAIL.COM");
        registerCourseOffering3.add("OFFERING-JAVA-JAMES");

        //register
        Register r1 = new Register(registerCourseOffering1);
        ArrayList<String> inputforComputeRegistraion1 = new ArrayList<>();
        inputforComputeRegistraion1.add("ANDY");
        inputforComputeRegistraion1.add("ACCEPTED");
        r1.computeRegistrationID(r1,inputforComputeRegistraion1,"ACCEPTED");
        r1.registerForTheCourseInInventory(r1);

        //register
        Register r2 = new Register(registerCourseOffering2);
        ArrayList<String> inputforComputeRegistraion2 = new ArrayList<>();
        inputforComputeRegistraion2.add("WOO");
        inputforComputeRegistraion2.add("ACCEPTED");
        r1.computeRegistrationID(r2,inputforComputeRegistraion2,"ACCEPTED");
        r1.registerForTheCourseInInventory(r2);

        //register
        Register r3 = new Register(registerCourseOffering3);
        ArrayList<String> inputforComputeRegistraion3 = new ArrayList<>();
        inputforComputeRegistraion3.add("ALICE");
        inputforComputeRegistraion3.add("ACCEPTED");
        r1.computeRegistrationID(r3,inputforComputeRegistraion3,"ACCEPTED");
        r1.registerForTheCourseInInventory(r3);

        inventoryValue.add(r1);
        inventoryValue.add(r2);
        inventoryValue.add(r3);

        //adding to inventory
        Inventory.inventory.put(inventoryKey,inventoryValue);

        //allot
        ArrayList<String> inputFforAllotment = new ArrayList<>();
        inputFforAllotment.add("OFFERING-JAVA-JAMES");
        Allotment a1 = new Allotment(inputFforAllotment);
        a1.checkIfSufficientRegistrationtIsRecieved("OFFERING-JAVA-JAMES",a1);
        a1.updateTheStatusOfAllotmentInInventory(a1,"OFFERING-JAVA-JAMES");

        assertEquals(inventoryKey.allot(inputFforAllotment),"sucessfully");
    }

  /*  @Test
    void cancel() {
    }

    @Test
    void register() {
    }*/
}