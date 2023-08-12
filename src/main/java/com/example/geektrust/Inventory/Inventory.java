package com.example.geektrust.Inventory;

import com.example.geektrust.Exception.CommonException;
import com.example.geektrust.Exception.ExceptionNames;
import com.example.geektrust.Inventory.CommandProcessor.Status;
import com.example.geektrust.Inventory.CommandProcessor.model.Allotment;
import com.example.geektrust.Inventory.CommandProcessor.model.Course;
import com.example.geektrust.Inventory.CommandProcessor.model.Register;

import java.util.*;

public class Inventory {

    static ArrayList<Register> registers = new ArrayList<>();

    public static HashMap<Course,ArrayList<Register>> inventory = new HashMap<>();

    public Inventory()
    {

    }

    public static void checkIfCoursesExistInInventory() throws CommonException {
        if(Inventory.inventory.size()==0)
        {
            throw new CommonException(ExceptionNames.fetchException("dataInvalid"));
        }
    }

    public static ArrayList<Register> getRegisterByCourseName(String courseName)
    {
        for (Map.Entry<Course,ArrayList<Register>> map:Inventory.inventory.entrySet()) {
            if (map.getKey().courseName.equals(courseName)) {
                return map.getValue();
            }
        }
        return registers;
    }

    public static ArrayList<Register> getRegisterByInstructorName(String instructorName)
    {
        for (Map.Entry<Course,ArrayList<Register>> map:Inventory.inventory.entrySet()) {
            if (map.getKey().instructorName.equals(instructorName)) {
                return map.getValue();
            }
        }
        return registers;
    }

    public static ArrayList<Register> getRegisterByCourseId(String courseId)
    {
        for (Map.Entry<Course,ArrayList<Register>> map:Inventory.inventory.entrySet()) {
            if (map.getKey().courseId.equals(courseId)) {
                return map.getValue();
            }
        }
        return registers;
    }

    public static Course getCourseByCourseId(String courseId)
    {
        for (Map.Entry<Course,ArrayList<Register>> map:Inventory.inventory.entrySet()) {
            if (map.getKey().courseId.equals(courseId)) {
                return map.getKey();
            }
        }
        return new Course();
    }

    public static Course getCourseByCourseName(String courseName) {
        for (Map.Entry<Course,ArrayList<Register>> map:Inventory.inventory.entrySet()) {
            if (map.getKey().courseName.equals(courseName)) {
                return map.getKey();
            }
        }
        return new Course();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
