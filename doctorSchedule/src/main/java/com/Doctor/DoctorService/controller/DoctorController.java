package com.Doctor.DoctorService.controller;

import com.Doctor.DoctorService.model.DoctorModel;
import com.Doctor.DoctorService.service.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    /*@GetMapping("/{id}")
    public ResponseEntity<DoctorModel> getScheduleById(@PathVariable Integer id) {
    	DoctorModel schedule = doctorservices.getScheduleById(id);
        if (schedule != null) {
            return new ResponseEntity<>(schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/
    
    @GetMapping("/{id}")
    public ResponseEntity<Void> getScheduleById(@PathVariable Integer id) {
        //Optional<DoctorModel> schedule = scheduleRepository.findById(id);
    	DoctorModel schedule = doctorservices.getScheduleById(id);
        if (schedule != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
