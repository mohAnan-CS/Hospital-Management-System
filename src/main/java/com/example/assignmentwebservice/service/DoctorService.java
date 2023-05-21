package com.example.assignmentwebservice.service;

import com.example.assignmentwebservice.model.Doctor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private List<Doctor> doctorsList = new ArrayList<>();

    public List<Doctor> getAllDoctors(){
        doctorsList.add(new Doctor(1, " Mohammad Anan" , "heart doctor", "059569399", 2500, true));
        return doctorsList;
    }
}

