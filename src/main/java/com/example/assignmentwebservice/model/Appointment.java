package com.example.assignmentwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor

public class Appointment {
    private Integer appointmentID, doctorId, patientId ;
    private String appointmentDate, appointmentTime, reason;

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID=" + appointmentID +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}

