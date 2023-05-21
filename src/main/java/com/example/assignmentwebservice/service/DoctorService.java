package com.example.assignmentwebservice.service;

import com.example.assignmentwebservice.model.Doctor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    private List<Doctor> doctorsList = new ArrayList<>();

    public List<Doctor> getAllDoctors(){
        return doctorsList;
    }

    public Doctor addDoctor(Doctor doctor){

        if (doctorsList.size() != 0 ){

            int lastIndex = doctorsList.size() - 1 ;
            int id = doctorsList.get(lastIndex).getDoctorID();
            id += 1 ;
            doctor.setDoctorID(id);
            doctorsList.add(doctor);
            return doctor;

        }else{

            doctor.setDoctorID(1);
            doctorsList.add(doctor);

        }

        return doctor;

    }
}

