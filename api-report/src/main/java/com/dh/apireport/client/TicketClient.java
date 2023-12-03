package com.dh.apireport.client;

import com.dh.apireport.domain.dto.TicketDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "api-event", name = "api-event")
public interface TicketClient {

    @GetMapping("/event/ticket/event/{eventId}")
    List<TicketDTO> listTicketsByEvent(@PathVariable Integer eventId);
}
