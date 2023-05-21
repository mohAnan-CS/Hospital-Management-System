package controller;

import model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DoctorService;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/{doctorID}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable int doctorID) {
        Doctor doctor = doctorService.getDoctorByID(doctorID);

        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor);
    }

    @PutMapping("/{doctorID}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable int doctorID,
            @RequestBody Doctor updatedDoctor
    ) {
        Doctor doctor = doctorService.getDoctorByID(doctorID);

        if (doctor != null) {

            doctor.setName(updatedDoctor.getName());
            doctor.setSpecialization(updatedDoctor.getSpecialization());
            doctor.setContactInfo(updatedDoctor.getContactInfo());
            doctor.setSchedule(updatedDoctor.getSchedule());

            updatedDoctor = doctorService.updateDoctor(doctor);
            return ResponseEntity.ok(updatedDoctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{doctorID}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int doctorID) {
        doctorService.deleteDoctor(doctorID);
        return ResponseEntity.noContent().build();
    }
}

