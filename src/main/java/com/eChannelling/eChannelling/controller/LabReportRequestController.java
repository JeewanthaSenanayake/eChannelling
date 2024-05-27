package com.eChannelling.eChannelling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eChannelling.eChannelling.repository.LabReportRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.eChannelling.eChannelling.entity.LabReportRequest;

import java.util.List;

@RestController
@RequestMapping("/lab_reports")
public class LabReportRequestController {
    @Autowired
    private LabReportRequestRepository LabReport;

    @PostMapping("/request_to_lab")
    public String request_to_lab(@RequestBody LabReportRequest item) {
        LabReport.save(item);
        return "Item added successfully";
    }

    @GetMapping("/get_all_requests")
    public List<LabReportRequest> get_all_requests() {
        return LabReport.findAll();
    }

    @GetMapping("/get_request_by_status/{status}")
    public List<LabReportRequest> get_request_by_status(@PathVariable int status) {
        return LabReport.findByStatus(status);
    }



}
