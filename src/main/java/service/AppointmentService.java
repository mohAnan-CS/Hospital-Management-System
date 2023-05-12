package service;

import controller.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AppointmentService {

    private List<Appointment> appointments = new ArrayList<>();

    // Method to get an appointment by ID
    public Appointment getAppointmentById(int appointmentID) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentID() == appointmentID) {
                return appointment;
            }
        }
        return null;
    }

    // Method to create a new appointment
    public Appointment createAppointment(Appointment appointment) {
        // Generate a unique ID for the new appointment (you can use a UUID or any other suitable method)
        int newAppointmentID = generateNewAppointmentID();

        // Set the generated ID for the appointment
        appointment.setAppointmentID(newAppointmentID);

        // Add the appointment to the list of appointments
        appointments.add(appointment);

        return appointment;
    }

    // Method to update an appointment
    public Appointment updateAppointment(Appointment updatedAppointment) {
        int appointmentID = updatedAppointment.getAppointmentID();

        // Find the appointment with the specified ID
        Appointment appointmentToUpdate = getAppointmentById(appointmentID);

        if (appointmentToUpdate != null) {
            // Update the appointment's information
            appointmentToUpdate.setAppointmentDate(updatedAppointment.getAppointmentDate());
            appointmentToUpdate.setAppointmentTime(updatedAppointment.getAppointmentTime());
            appointmentToUpdate.setReason(updatedAppointment.getReason());
            appointmentToUpdate.setStatus(updatedAppointment.getStatus());

            return appointmentToUpdate;
        }

        return null; // Appointment not found
    }

    // Method to delete an appointment
    public void deleteAppointment(int appointmentID) {
        Appointment appointmentToRemove = getAppointmentById(appointmentID);

        if (appointmentToRemove != null) {
            appointments.remove(appointmentToRemove);
        }
    }

    // Method to generate a new unique appointment ID (example implementation)
    private int generateNewAppointmentID() {
        // Generate a random number or use any other suitable method to generate unique IDs
        return new Random().nextInt(1000);
    }
}

