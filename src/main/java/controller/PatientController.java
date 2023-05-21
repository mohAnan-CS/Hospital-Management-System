package controller;

import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/{patientID}")
    public ResponseEntity<Patient> getPatient(@PathVariable int patientID) {
        Patient patient = patientService.getPatientById(patientID);

        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @PutMapping("/{patientID}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable int patientID,
            @RequestBody Patient updatedPatient
    ) {
        Patient patient = patientService.getPatientById(patientID);

        if (patient != null) {
            // Update the patient's information with the updatedPatient object
            patient.setName(updatedPatient.getName());
            patient.setDateOfBirth(updatedPatient.getDateOfBirth());
            patient.setContactInfo(updatedPatient.getContactInfo());
            patient.setMedicalHistory(updatedPatient.getMedicalHistory());

            updatedPatient = patientService.updatePatient(patient);
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{patientID}")
    public ResponseEntity<Void> deletePatient(@PathVariable int patientID) {
        patientService.deletePatient(patientID);
        return ResponseEntity.noContent().build();
    }
}

