package com.example.assignmentwebservice.controller;

import com.example.assignmentwebservice.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.assignmentwebservice.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping()
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping()
    public Patient addPatient(@RequestBody Patient patient) { return  patientService.addPatient(patient); }

    @DeleteMapping("{id}")
    public Patient deletePatient(@PathVariable("id") Integer id){ return patientService.deletePatient(id); }

    @PutMapping("{id}")
    public Patient editAppointment(@PathVariable("id") Integer id,  @RequestBody Patient patient){
        return patientService.editPatient(id, patient);
    }
}

