package com.example.assignmentwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Patient {

    private int patientID;
    private String name, dateOfBirth, contactInfo, medicalHistory;
    private boolean isHealthInsuranceAvailable;

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", isHealthInsuranceAvailable=" + isHealthInsuranceAvailable +
                '}';
    }
}

