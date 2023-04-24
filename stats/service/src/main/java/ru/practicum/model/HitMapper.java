package ru.practicum.model;

import lombok.experimental.UtilityClass;
import ru.practicum.EndpointHit;

@UtilityClass
public class HitMapper {

    public static Hit toHit(EndpointHit endpointHit) {
        return new Hit(
                endpointHit.getId(),
                endpointHit.getApp(),
                endpointHit.getUri(),
                endpointHit.getIp(),
                endpointHit.getTimestamp()

        );
    }

    public static EndpointHit toEndpointHit(Hit hit) {
        return new EndpointHit(
                hit.getId(),
                hit.getApp(),
                hit.getUri(),
                hit.getIp(),
                hit.getTimestamp()
        );
    }
}
