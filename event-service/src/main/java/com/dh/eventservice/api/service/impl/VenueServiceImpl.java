package com.dh.eventservice.api.service.impl;
import com.dh.eventservice.api.Exceptions.ResourceNotFoundExceptions;
import com.dh.eventservice.api.config.ModelMapperConfig;
import com.dh.eventservice.api.service.VenueService;
import com.dh.eventservice.api.service.VenueService;
import com.dh.eventservice.domain.DTO.EventDTO;
import com.dh.eventservice.domain.DTO.VenueDTO;
import com.dh.eventservice.domain.DTO.VenueDTO;
import com.dh.eventservice.domain.model.Event;
import com.dh.eventservice.domain.model.Venue;
import com.dh.eventservice.domain.model.Venue;
import com.dh.eventservice.domain.repository.VenueRepository;
import com.dh.eventservice.domain.repository.VenueRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VenueServiceImpl implements VenueService {

    private static final Logger logger = LoggerFactory.getLogger(VenueServiceImpl.class);
    private final VenueRepository venueRepository;

    @Autowired
    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }
    @Autowired
    private ModelMapperConfig mapperM;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Set<VenueDTO> getVenuesByCountry(String country) {
        List<Venue> venues= venueRepository.findAllByCountry(country);
        Set<VenueDTO> venueDTO= new HashSet<>();
        for (Venue v: venues) {
            venueDTO.add(mapper.convertValue(v,VenueDTO.class));
        }
        return venueDTO;
    }

    @Override
    public Set<VenueDTO> getAllVenues() {
        List<Venue> venues=venueRepository.findAll();
        Set<VenueDTO> venueDTO= new HashSet<>();
        for (Venue v: venues) {
            venueDTO.add(mapper.convertValue(v,VenueDTO.class));
        }
        return venueDTO;

    }

    @Override
    public VenueDTO save(VenueDTO venueDTO) {
        Venue venue=mapper.convertValue(venueDTO, Venue.class);
        venueRepository.save(venue);
        logger.info("Se guardo el recinto "+ venueDTO );
        return venueDTO;
    }

    @Override
    public void delete(Integer idVenue) throws ResourceNotFoundExceptions{
        if (venueRepository.findById(idVenue).isEmpty()){
            logger.error("No existe el elmento a eliminar");
            throw  new ResourceNotFoundExceptions("No existe el elmento a eliminar");
        }else {
            venueRepository.deleteById(idVenue);
            logger.info("Se elimino correctamente la categoria con id: "+ idVenue);
        }
    }

    @Override
    public VenueDTO findById(Integer idVenue) throws ResourceNotFoundExceptions {
        Optional<Venue> venue= venueRepository.findById((idVenue));
        VenueDTO venueDTO= null;
        if (venue.isPresent()) {
            venueDTO = mapper.convertValue(venue, VenueDTO.class);
        }else{
            throw new ResourceNotFoundExceptions("No existe el recinto buscado con id "+ idVenue);
        }
        return venueDTO;
    }

    @Override
    public String update(VenueDTO venueDTO) throws ResourceNotFoundExceptions{
        Optional<Venue> venue = venueRepository.findById(venueDTO.getId());
        String response;
        if (venue.isPresent()) {
            venueRepository.save(this.updateDb(venue.get(), venueDTO));
            mapperM.getModelMapper().map(venueDTO, VenueDTO.class);
            response = "Successful update";
        } else {
            throw new ResourceNotFoundExceptions("El recinto no pudo ser actualizado");
        }
        return response;
    }

    private Venue updateDb(Venue venue, VenueDTO venueDTO){
        if (venueDTO.getVenue() != null) {
            venue.setVenue(venueDTO.getVenue());
        }

        if (venueDTO.getCity() != null) {
            venue.setCity(venueDTO.getCity());
        }

        if (venueDTO.getAddress() != null) {
            venue.setAddress(venueDTO.getAddress());
        }

        if (venueDTO.getCountry() != null) {
            venue.setCountry(venueDTO.getCountry());
        }

        return venue;
    }
}
