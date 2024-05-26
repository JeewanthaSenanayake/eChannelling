package com.Doctor.DoctorService.service;

import com.Doctor.DoctorService.dao.DoctorDao;
import com.Doctor.DoctorService.model.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServices {

    @Autowired
    DoctorDao doctordao;
    
    public ResponseEntity<List<DoctorModel>> getAllSchedules(){
        try{
            return new ResponseEntity<>(doctordao.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

        public ResponseEntity<String> addSchedule(DoctorModel doctormodel) {
            doctordao.save(doctormodel);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }

		/*public DoctorModel getScheduleById(Integer id) {
			ResponseEntity<DoctorModel> response = restTemplate.getForEntity("http://localhost:8080/doctor/" + id, DoctorModel.class);
	        return response.getBody();
		}*/
        
        public DoctorModel getScheduleById(Integer id) {
            return doctordao.findById(id).orElse(null);
        }

}
