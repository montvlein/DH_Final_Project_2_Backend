package com.dh.apireport.api.service.impl;
import com.dh.apireport.api.config.ModelMapperConfig;

import com.dh.apireport.api.service.ReportService;
import com.dh.apireport.domain.dto.ReportDTO;
import com.dh.apireport.domain.model.Report;
import com.dh.apireport.domain.repository.ReportRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
    private final ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
    @Autowired
    private ModelMapperConfig mapperM;
    @Autowired
    ObjectMapper mapper;

    @Override
    public List<ReportDTO> getSalesByEvent(Integer IdEvent, LocalDate startDate, LocalDate endDate) {
        List<ReportDTO> response = new ArrayList<>();

        ReportDTO item = new ReportDTO();
        item.setDay(LocalDate.now());
        item.setEvent("Foo Fighters");
        item.setAmount(30000.0f);
        item.setQuantity(321);

        response.add(item);

        return response;
    }
}
