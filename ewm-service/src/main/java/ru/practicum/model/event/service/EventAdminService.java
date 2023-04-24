package ru.practicum.model.event.service;

import ru.practicum.model.event.StatusEvent;
import ru.practicum.model.event.dto.EventFullDto;
import ru.practicum.model.event.dto.UpdateEventAdminRequestDto;

import java.util.List;

public interface EventAdminService {

    EventFullDto updateEventAdmin(Long eventId, UpdateEventAdminRequestDto updateEventAdminRequestDto);

    List<EventFullDto> getAllEventsByFilter(List<Long> users, List<StatusEvent> states,
                                            List<Long> categories, String rangeStart, String rangeEnd,
                                            Integer from, Integer size);
}
