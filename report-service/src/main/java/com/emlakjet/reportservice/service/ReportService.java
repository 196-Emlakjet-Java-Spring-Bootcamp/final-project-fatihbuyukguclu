package com.emlakjet.reportservice.service;


import com.emlakjet.advertiseservice.model.AdvertiseDTO;
import com.emlakjet.reportservice.model.Report;
import com.emlakjet.reportservice.repository.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void createReport(AdvertiseDTO advertise){

        Report report = Report.builder()
                .advertId(advertise.getId())
                .viewed(advertise.getViewCount())
                .build();

        report.setMessage("Advertise Id: " + report.getAdvertId()
                + " Viewed: " + report.getViewed()
                + " createdAt:");

        reportRepository.save(report);
    }
}
