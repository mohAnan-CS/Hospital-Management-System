package service;

import controller.Doctor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DoctorService {

    private List<Doctor> doctors = new ArrayList<>();

    // Method to get a doctor by ID
    public Doctor getDoctorByID(int doctorID) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorID() == doctorID) {
                return doctor;
            }
        }
        return null;
    }

    // Method to create a new doctor
    public Doctor createDoctor(Doctor doctor) {
        // Generate a unique ID for the new doctor (you can use a UUID or any other suitable method)
        int newDoctorID = generateNewDoctorID();

        // Set the generated ID for the doctor
        doctor.setDoctorID(newDoctorID);

        // Add the doctor to the list of doctors
        doctors.add(doctor);

        return doctor;
    }

    // Method to update a doctor
    public Doctor updateDoctor(Doctor updatedDoctor) {
        int doctorID = updatedDoctor.getDoctorID();

        // Find the doctor with the specified ID
        Doctor doctorToUpdate = getDoctorByID(doctorID);

        if (doctorToUpdate != null) {
            // Update the doctor's information
            doctorToUpdate.setName(updatedDoctor.getName());
            doctorToUpdate.setSpecialization(updatedDoctor.getSpecialization());
            doctorToUpdate.setContactInfo(updatedDoctor.getContactInfo());
            doctorToUpdate.setSchedule(updatedDoctor.getSchedule());

            return doctorToUpdate;
        }

        return null; // Doctor not found
    }

    // Method to delete a doctor
    public void deleteDoctor(int doctorID) {
        Doctor doctorToRemove = getDoctorByID(doctorID);

        if (doctorToRemove != null) {
            doctors.remove(doctorToRemove);
        }
    }

    // Method to generate a new unique doctor ID (example implementation)
    private int generateNewDoctorID() {

        return new Random().nextInt(1000);
    }
}

