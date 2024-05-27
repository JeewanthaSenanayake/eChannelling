package com.eChannelling.eChannelling.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eChannelling.eChannelling.repository.LabReportRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.eChannelling.eChannelling.entity.LabReportRequest;

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

}
