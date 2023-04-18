package ru.practicum.model;

import lombok.experimental.UtilityClass;
import ru.practicum.dto.EndpointHit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class HitMapper {

    public static Hit toHit(EndpointHit endpointHit) {
        return new Hit(
                endpointHit.getId(),
                endpointHit.getApp(),
                endpointHit.getUri(),
                endpointHit.getIp(),
                LocalDateTime.parse(endpointHit.getTimestamp(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

        );
    }

    public static EndpointHit toEndpointHit(Hit hit) {
        return new EndpointHit(
                hit.getId(),
                hit.getApp(),
                hit.getUri(),
                hit.getIp(),
                hit.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        );
    }
}
