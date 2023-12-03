package com.dh.apireport.api.service;

import java.util.List;
import java.time.LocalDate;
import com.dh.apireport.domain.dto.ReportDTO;
public interface ReportService {

    ReportDTO getSalesByEvent(Integer IdEvent, LocalDate startDate, LocalDate endDate);
}
