package model;

public class Doctor {

    private int doctorID;
    private String name, specialization, phoneNumber;
    private double salary;
    private boolean isAvailable;

    public Doctor(int doctorID, String name, String specialization, String phoneNumber, double salary, boolean isAvailable) {
        this.doctorID = doctorID;
        this.name = name;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.isAvailable = isAvailable;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorID=" + doctorID +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                ", isAvailable=" + isAvailable +
                '}';
    }
}


