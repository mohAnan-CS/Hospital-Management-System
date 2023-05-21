package com.example.assignmentwebservice.service;

import com.example.assignmentwebservice.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    private List<Appointment> appointmentsList = new ArrayList<>();

    public List<Appointment> getAllAppointments() { return appointmentsList; }

    public Appointment addAppointment(Appointment appointment) {

        if (appointmentsList.size() != 0 ){

            int lastIndex = appointmentsList.size() - 1 ;
            int id = appointmentsList.get(lastIndex).getAppointmentID();
            id += 1 ;
            appointment.setAppointmentID(id);
            appointmentsList.add(appointment);
            return appointment;

        }else{

            appointment.setAppointmentID(1);
            appointmentsList.add(appointment);

        }

        return appointment;

    }

    public Appointment deleteAppointment(Integer id) {

        Appointment appointment = new Appointment(0, 0 , 0, "?", "?", "?");
        for (int i = 0; i < appointmentsList.size(); i++) {

            if (appointmentsList.get(i).getAppointmentID() == id){

                appointment = appointmentsList.get(i);
                appointmentsList.remove(appointment);
                return appointment;

            }

        }

        return appointment;

    }

    public Appointment editAppointment(Integer id, Appointment appointment) {

        for (Appointment value : appointmentsList) {

            if (value.getAppointmentID() == id) {

                if (appointment.getAppointmentDate() != null){
                    value.setAppointmentDate(appointment.getAppointmentDate());
                }

                if (appointment.getAppointmentTime() != null){
                    value.setAppointmentTime(appointment.getAppointmentTime());
                }

                if (appointment.getReason() != null){
                    value.setReason(appointment.getReason());
                }

                if (appointment.getDoctorId() != 0){
                    System.out.println("doctor id");
                    value.setDoctorId(appointment.getDoctorId());
                }

                if (appointment.getPatientId() != 0){
                    System.out.println("patient id");
                    value.setPatientId(appointment.getPatientId());
                }

                return value;
            }

        }

        return new Appointment(0, 0, 0, "?", "?", "?");

    }
}

