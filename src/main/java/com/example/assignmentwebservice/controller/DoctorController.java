package com.example.assignmentwebservice.controller;

import com.example.assignmentwebservice.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.assignmentwebservice.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping()
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }
    
}

