package ru.practicum.service;

import ru.practicum.EndpointHit;
import ru.practicum.ViewStats;

import java.time.LocalDateTime;
import java.util.List;

public interface StatsService {
    EndpointHit save(EndpointHit hit);

    List<ViewStats> getViewStats(LocalDateTime startTime, LocalDateTime endTime, List<String> uris, Boolean unique);
}
