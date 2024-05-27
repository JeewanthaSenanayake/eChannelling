package com.eChannelling.eChannelling.repository;
import com.eChannelling.eChannelling.entity.LabReportRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LabReportRequestRepository extends JpaRepository<LabReportRequest, Long>{
    List<LabReportRequest> findByStatus(int status);
}
