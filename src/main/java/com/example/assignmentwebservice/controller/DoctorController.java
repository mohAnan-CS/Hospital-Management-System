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

    @PostMapping()
    public Doctor createDoctor(@RequestBody Doctor doctor) { return  doctorService.addDoctor(doctor); }

    @PutMapping("{id}")
    public Doctor editDoctor(@PathVariable("id") Integer id,  @RequestBody Doctor doctor){
        return doctorService.editDoctor(id, doctor);
    }

    @DeleteMapping("{id}")
    public Doctor deleteDoctor(@PathVariable("id") Integer id){ return doctorService.deleteDoctor(id); }

}

