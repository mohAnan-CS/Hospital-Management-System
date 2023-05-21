package com.example.assignmentwebservice.controller;

import com.example.assignmentwebservice.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.assignmentwebservice.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping()
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @PostMapping()
    public Appointment createAppointment(@RequestBody Appointment appointment) { return  appointmentService.addAppointment(appointment); }

    @DeleteMapping("{id}")
    public Appointment deleteAppointment(@PathVariable("id") Integer id){ return appointmentService.deleteAppointment(id); }

    @PutMapping("{id}")
    public Appointment editAppointment(@PathVariable("id") Integer id,  @RequestBody Appointment appointment){
        return appointmentService.editAppointment(id, appointment);
    }

}

