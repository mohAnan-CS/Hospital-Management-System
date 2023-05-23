package com.example.assignmentwebservice.controller;

import com.example.assignmentwebservice.model.Patient;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Get patients", notes = "Get all patients record")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PostMapping()
    @ApiOperation(value = "Post patient", notes = "Add patient record")
    public Patient addPatient(@RequestBody Patient patient) { return  patientService.addPatient(patient); }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete patient", notes = "Delete patient record by patient id")
    public Patient deletePatient(@PathVariable("id") Integer id){ return patientService.deletePatient(id); }

    @PutMapping("{id}")
    @ApiOperation(value = "Put patient", notes = "Edit patient record by patient id")
    public Patient editAppointment(@PathVariable("id") Integer id,  @RequestBody Patient patient){
        return patientService.editPatient(id, patient);
    }
}

