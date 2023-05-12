package service;

import controller.Patient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PatientService {

    private List<Patient> patients = new ArrayList<>();

    // Method to get a patient by ID
    public Patient getPatientById(int patientID) {
        for (Patient patient : patients) {
            if (patient.getPatientID() == patientID) {
                return patient;
            }
        }
        return null;
    }

    // Method to create a new patient
    public Patient createPatient(Patient patient) {
        // Generate a unique ID for the new patient (you can use a UUID or any other suitable method)
        int newPatientID = generateNewPatientID();

        // Set the generated ID for the patient
        patient.setPatientID(newPatientID);

        // Add the patient to the list of patients
        patients.add(patient);

        return patient;
    }

    // Method to update a patient
    public Patient updatePatient(Patient updatedPatient) {
        int patientID = updatedPatient.getPatientID();

        // Find the patient with the specified ID
        Patient patientToUpdate = getPatientById(patientID);

        if (patientToUpdate != null) {
            // Update the patient's information
            patientToUpdate.setName(updatedPatient.getName());
            patientToUpdate.setDateOfBirth(updatedPatient.getDateOfBirth());
            patientToUpdate.setContactInfo(updatedPatient.getContactInfo());
            patientToUpdate.setMedicalHistory(updatedPatient.getMedicalHistory());

            return patientToUpdate;
        }

        return null; // Patient not found
    }

    public void deletePatient(int patientID) {
        Patient patientToRemove = getPatientById(patientID);

        if (patientToRemove != null) {
            patients.remove(patientToRemove);
        }
    }

    private int generateNewPatientID() {
        return new Random().nextInt(1000);
    }
}

