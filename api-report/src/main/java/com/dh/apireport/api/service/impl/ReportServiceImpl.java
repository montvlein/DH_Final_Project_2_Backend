package com.dh.apireport.api.service.impl;
import com.dh.apireport.api.config.ModelMapperConfig;

import com.dh.apireport.api.service.ReportService;
import com.dh.apireport.client.TicketClient;
import com.dh.apireport.domain.dto.ReportDTO;
import com.dh.apireport.domain.dto.TicketDTO;
import com.dh.apireport.domain.model.Report;
//import com.dh.apireport.domain.repository.ReportRepository;
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

//    @Autowired
//    ReportRepository reportRepository;

    @Autowired
    private ModelMapperConfig mapperM;
    @Autowired
    ObjectMapper mapper;

    @Autowired
    TicketClient ticketClient;

    @Override
    public ReportDTO getSalesByEvent(Integer idEvent, LocalDate startDate, LocalDate endDate) {
        ReportDTO response = new ReportDTO();

        List<TicketDTO> ticketDTOList= ticketClient.listTicketsByEvent(idEvent);

        List<Integer> quantityList = new ArrayList<>();

        List<LocalDate> dateList = new ArrayList<>();
        for (LocalDate d = startDate; !d.isAfter(endDate); d = d.plusDays(1)) {
            dateList.add(d);
        }

        for (int i = 0; i < dateList.size(); i++) {
            quantityList.add(0);
        }

        for (TicketDTO ticket: ticketDTOList) {
            LocalDate date = ticket.getPurchaseDate();
            int i = dateList.indexOf(date);
            if (i >= 0) {
                quantityList.set(i, quantityList.get(i) + 1);
            }

        }
        if (ticketDTOList.size()>0) {
            response.setEvent(ticketDTOList.get(0).getEvent().getName());
        }
        response.setDateList(dateList);
        response.setQuantityList(quantityList);


        return response;
    }
}
