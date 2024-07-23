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

    @PostMapping("/add")
    public ResponseEntity<String> addSchedule(@RequestBody DoctorModel doctormodel){
        return  doctorservices.addSchedule(doctormodel);
    }

    @GetMapping("/DocById/{id}")
    public ResponseEntity<Void> getScheduleById(@PathVariable Integer id) {
        //Optional<DoctorModel> schedule = scheduleRepository.findById(id);
    	DoctorModel schedule = doctorservices.getScheduleById(id);
        if (schedule != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("location/{location}")
    public ResponseEntity<List<DoctorModel>> getSchedulesByLocation(@PathVariable String location){
        return doctorservices.getSchedulesByLocation(location);

    }
    
    @GetMapping("doctorId/{doctorId}")
    public ResponseEntity<List<DoctorModel>> getSchedulesByDoctorId(@PathVariable Integer doctorId){
        return doctorservices.getSchedulesByDoctorId(doctorId);
    }

     @GetMapping("/{doctorId}/appointments")
     public ResponseEntity<List<AppointmentModel>> getAppointmentsByDoctorId(@PathVariable Integer doctorId){
         return doctorservices.getAppointmentsByDoctorId(doctorId);
     }

     @GetMapping("/{doctorId}/labReports")
     public ResponseEntity<List<LabReportModel>> getLabReportsByDoctorId(@PathVariable Integer doctorId){
         return doctorservices.getLabReportsByDoctorId(doctorId);
     }

    @PutMapping("/update/{doctorId}")
    public ResponseEntity<String> updateSchedule(@PathVariable Integer doctorId, @RequestBody DoctorModel doctormodel) {
        return doctorservices.updateSchedule(doctorId, doctormodel);
    }

    @DeleteMapping("/delete/{doctorId}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Integer doctorId) {
        return doctorservices.deleteSchedule(doctorId);
    }
}
