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

        }else{

            doctor.setDoctorID(1);

        }

        doctorsList.add(doctor);
        return doctor;

    }

    public Doctor editDoctor(Integer id, Doctor doctor) {

        for (Doctor value : doctorsList) {

            if (value.getDoctorID() == id) {

                if (doctor.getName() != null){
                    value.setName(doctor.getName());
                }

                if (doctor.getSpecialization() != null){
                    value.setSpecialization(doctor.getSpecialization());
                }

                if (doctor.getSalary() != null){
                    value.setSalary(doctor.getSalary());
                }

                if (doctor.getPhoneNumber() != null){
                    value.setPhoneNumber(doctor.getPhoneNumber());
                }

                return value;
            }

        }

        return new Doctor(0, "?", "?", "?", 0.0, false);

    }
}

