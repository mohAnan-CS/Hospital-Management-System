package controller;

import java.util.List;

public class Doctor {
    private int doctorID;
    private String name;
    private String specialization;
    private String contactInfo;
    private String schedule;

    // Constructors
    public Doctor() {
    }

    public Doctor(int doctorID, String name, String specialization, String contactInfo, String schedule) {
        this.doctorID = doctorID;
        this.name = name;
        this.specialization = specialization;
        this.contactInfo = contactInfo;
        this.schedule = schedule;
    }

    // Getters and Setters
    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    // Custom Methods
    public static void addDoctor(List<Doctor> doctorList, Doctor doctor) {
        doctorList.add(doctor);
    }

    public static void removeDoctor(List<Doctor> doctorList, int doctorID) {
        Doctor doctorToRemove = null;
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorID() == doctorID) {
                doctorToRemove = doctor;
                break;
            }
        }
        if (doctorToRemove != null) {
            doctorList.remove(doctorToRemove);
        }
    }
}


