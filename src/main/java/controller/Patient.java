package controller;

public class Patient {

    private int patientID;
    private String name, dateOfBirth, contactInfo, medicalHistory;
    private boolean isHealthInsuranceAvailable;

    public Patient(int patientID, String name, String dateOfBirth, String contactInfo, String medicalHistory, boolean isHealthInsuranceAvailable) {
        this.patientID = patientID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactInfo = contactInfo;
        this.medicalHistory = medicalHistory;
        this.isHealthInsuranceAvailable = isHealthInsuranceAvailable;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public boolean isHealthInsuranceAvailable() {
        return isHealthInsuranceAvailable;
    }

    public void setHealthInsuranceAvailable(boolean healthInsuranceAvailable) {
        isHealthInsuranceAvailable = healthInsuranceAvailable;
    }

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

