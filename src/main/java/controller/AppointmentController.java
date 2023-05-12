package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/{appointmentID}")
    public ResponseEntity<Appointment> getAppointment(@PathVariable int appointmentID) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentID);

        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        Appointment createdAppointment = appointmentService.createAppointment(appointment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAppointment);
    }

    @PutMapping("/{appointmentID}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable int appointmentID,
            @RequestBody Appointment updatedAppointment
    ) {
        Appointment appointment = appointmentService.getAppointmentById(appointmentID);

        if (appointment != null) {
            // Update the appointment's information with the updatedAppointment object
            appointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
            appointment.setAppointmentTime(updatedAppointment.getAppointmentTime());
            appointment.setReason(updatedAppointment.getReason());
            appointment.setStatus(updatedAppointment.getStatus());

            updatedAppointment = appointmentService.updateAppointment(appointment);
            return ResponseEntity.ok(updatedAppointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{appointmentID}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable int appointmentID) {
        appointmentService.deleteAppointment(appointmentID);
        return ResponseEntity.noContent().build();
    }
}

