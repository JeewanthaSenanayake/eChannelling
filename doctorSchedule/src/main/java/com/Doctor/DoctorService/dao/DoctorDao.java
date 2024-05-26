package com.Doctor.DoctorService.dao;

import com.Doctor.DoctorService.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorDao extends JpaRepository<DoctorModel, Integer> {
}
