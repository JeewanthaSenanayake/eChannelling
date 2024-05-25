package com.Doctor.DoctorService.controller;

import com.Doctor.DoctorService.model.DoctorModel;
import com.Doctor.DoctorService.service.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorServices doctorservices;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test endpoint working");
    }

    @GetMapping("/AllSchedules")
    public ResponseEntity<List<DoctorModel>> getAllSchedules(){
        return doctorservices.getAllSchedules();
    }

    @PostMapping("add")
    public ResponseEntity<String> addSchedule(@RequestBody DoctorModel doctormodel){
        return  doctorservices.addSchedule(doctormodel);
    }
}
