package com.example.assignmentwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Doctor {

    private int doctorID;
    private String name, specialization, phoneNumber;
    private Double salary;
    private boolean isAvailable;

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", isAvailable=" + isAvailable +
                '}';
    }
}


