package com.example.assignmentwebservice.service;

import com.example.assignmentwebservice.model.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private List<Patient> patientsList = new ArrayList<>();

    public List<Patient> getAllPatients() {
        return patientsList;
    }

    public Patient addPatient(Patient patient) {
        if (patientsList.size() != 0) {
            int lastIndex = patientsList.size() - 1;
            int id = patientsList.get(lastIndex).getPatientID();
            id += 1;
            patient.setPatientID(id);
            patientsList.add(patient);
            return patient;
        } else {
            patient.setPatientID(1);
            patientsList.add(patient);
        }
        return patient;
    }

    public Patient deletePatient(Integer id) {
        Patient patient = new Patient(0, "?", "?", "?", "?",false);
        for (int i = 0; i < patientsList.size(); i++) {
            if (patientsList.get(i).getPatientID() == id) {
                patient = patientsList.get(i);
                patientsList.remove(patient);
                return patient;
            }
        }
        return patient;
    }

    public Patient editPatient(Integer id, Patient patient) {
        for (Patient value : patientsList) {
            if (value.getPatientID() == id) {
                if (patient.getContactInfo() != null) {
                    value.setContactInfo(patient.getContactInfo());
                }
                if (patient.getDateOfBirth() != null) {
                    value.setDateOfBirth(patient.getDateOfBirth());
                }
                if (patient.getMedicalHistory() != null) {
                    value.setMedicalHistory(patient.getMedicalHistory());
                }
                if (patient.getName() != null) {
                    value.setName(patient.getName());
                }
                return value;
            }
        }
        return new Patient(0, "?", "?", "?", "?",false);
    }

}

