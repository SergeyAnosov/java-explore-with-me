package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.dto.EndpointHit;
import ru.practicum.dto.ViewStats;
import ru.practicum.db.HitRepository;
import ru.practicum.model.Hit;
import ru.practicum.model.HitMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {
    private final HitRepository hitRepository;

    @Override
    public EndpointHit save(EndpointHit endpointHit) {

        Hit save = HitMapper.toHit(endpointHit);
        hitRepository.save(save);
        return HitMapper.toEndpointHit(save);
    }

    @Override
    public List<ViewStats> getViewStats(LocalDateTime start, LocalDateTime end, List<String> uris, Boolean unique) {

        List<ViewStats> stats;
        if (uris == null || uris.isEmpty()) {
            if (unique) {
                stats = hitRepository.findAllByIpUniqueNoUris(start, end);
            } else {
                stats = hitRepository.findAllByIpNoUris(start, end);
            }
        } else {
            if (unique) {
                stats =  hitRepository.findAllByIpUnique(start, end, uris);
            } else {
                stats =  hitRepository.findAllByIp(start, end, uris);
            }
        }
        return stats;
    }
}
