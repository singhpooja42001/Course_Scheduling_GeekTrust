package com.example.geektrust.Inventory;

import com.example.geektrust.Inventory.CommandProcessor.model.Course;
import com.example.geektrust.Inventory.CommandProcessor.model.Register;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    static ArrayList<Register> registers = new ArrayList<>();

    public static HashMap<Course,ArrayList<Register>> inventory = new HashMap<>();

    /*@Test
    void checkIfCoursesExistInInventory() {
    }

    @Test
    void getRegisterByCourseName() {
    }

    @Test
    void getRegisterByInstructorName() {
    }

    @Test
    void getRegisterByCourseId() {
    }

    @Test
    void getCourseByCourseId() {
    }

    @Test
    void getCourseByCourseName() {
    }*/
}