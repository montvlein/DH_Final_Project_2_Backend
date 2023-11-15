package com.dh.eventservice.api.service.impl;

import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.config.ModelMapperConfig;
import com.dh.eventservice.api.service.DateTimeService;
import com.dh.eventservice.domain.DTO.DateTimeDTO;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.model.Category;
import com.dh.eventservice.domain.model.DateTime;
import com.dh.eventservice.domain.model.Event;
import com.dh.eventservice.domain.repository.DateTimeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DateTimeServiceImpl implements DateTimeService {

    private static final Logger logger = LoggerFactory.getLogger(EventServiceImpl.class);

    @Autowired
    DateTimeRepository dateTimeRepository;

    @Autowired
    private ModelMapperConfig mapper;

    @Autowired
    private ObjectMapper obmapper;

    @Override
    public DateTimeDTO save(DateTimeDTO dateTimeDTO) {
        DateTime date = mapper.getModelMapper().map(dateTimeDTO, DateTime.class);
        dateTimeRepository.save(date);

        logger.info("Se guardó la fecha: {}", date);

        return mapper.getModelMapper().map(dateTimeRepository.save(date), DateTimeDTO.class);
    }

    @Override
    public DateTimeDTO findById(Integer id) throws ResourceNotFoundExceptions {
        Optional<DateTime> date= dateTimeRepository.findById((id));
        DateTimeDTO dateTimeDTO= null;
        if (date.isPresent()) {
            dateTimeDTO = obmapper.convertValue(date, DateTimeDTO.class);
        }else{
            throw new ResourceNotFoundExceptions("No existe la fecha buscada con id "+ id);
        }
        return dateTimeDTO;
    }

    @Override
    public List<DateTimeDTO> getAllDates() {
        List<DateTime> dates = dateTimeRepository.findAll();

        logger.info("Se listaron todas las fechas");

        return mapper.getModelMapper().map(dates, List.class);
    }


    @Override
    public void delete(Integer id) throws ResourceNotFoundExceptions {
        if (dateTimeRepository.findById((id))==null){
            throw  new ResourceNotFoundExceptions("No existe la fecha a eliminar");
        }else {
            dateTimeRepository.deleteById(id);
            logger.info("Se elimino correctamente la fecha con id: "+ id);
        }
    }

    @Override
    public String update(DateTimeDTO dateTimeDTO) throws ResourceNotFoundExceptions {
        Optional<DateTime> date = dateTimeRepository.findById(dateTimeDTO.getId());
        String response;
        if (date.isPresent()){
            dateTimeRepository.save(this.updateDb(date.get(), dateTimeDTO));
            mapper.getModelMapper().map(dateTimeDTO, DateTimeDTO.class);
            response = "Successful update";
        } else {
            throw new ResourceNotFoundExceptions("La fecha no pudo ser actualizada");
        }
        return response;
    }

    /*@Override
    public List<DateTime> findAllByDateTime(LocalDateTime date) throws ResourceNotFoundExceptions{
        Optional<DateTime> dateTime= dateTimeRepository.findAllByDateTime((date));
        EventDTO eventDTO= null;
        if (event.isPresent()) {
            eventDTO = obmapper.convertValue(event, EventDTO.class);
        }else{
            throw new ResourceNotFoundExceptions("No existe el elemento buscado con id "+ id);
        }
        return eventDTO;
    }*/

    private DateTime updateDb(DateTime dateTime, DateTimeDTO dateTimeDTO) {
        if (dateTimeDTO.getDateTime() != null) {
            dateTime.setDateTime(dateTimeDTO.getDateTime());
        }
        return dateTime;
    }
}
