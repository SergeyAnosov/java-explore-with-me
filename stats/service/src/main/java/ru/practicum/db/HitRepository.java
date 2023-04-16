package ru.practicum.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.practicum.dto.ViewStats;
import ru.practicum.model.Hit;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HitRepository extends JpaRepository<Hit, Long> {
    @Query("SELECT NEW ru.practicum.dto.ViewStats(h.app, COUNT(DISTINCT h.ip)) " +
            "FROM Hit h WHERE h.timestamp BETWEEN :start AND :end " +
            "GROUP BY h.ip, h.app " +
            "ORDER BY COUNT(DISTINCT h.ip) DESC")
    List<ViewStats> findAllByIpUniqueNoUris(LocalDateTime start, LocalDateTime end);

    @Query("SELECT NEW ru.practicum.dto.ViewStats(h.app, COUNT(h.ip)) " +
            "FROM Hit h WHERE h.timestamp BETWEEN :start AND :end " +
            "GROUP BY h.ip, h.app " +
            "ORDER BY COUNT(h.ip) DESC")
    List<ViewStats> findAllByIpNoUris(LocalDateTime start, LocalDateTime end);

    @Query("SELECT NEW ru.practicum.dto.ViewStats(h.app, h.uri, COUNT(DISTINCT h.ip)) " +
            "FROM Hit h WHERE h.timestamp BETWEEN :start AND :end AND h.uri IN (:uris) " +
            "GROUP BY h.uri, h.ip, h.app " +
            "ORDER BY COUNT(DISTINCT h.ip) DESC")
    List<ViewStats> findAllByIpUnique(LocalDateTime start, LocalDateTime end, List<String> uris);

    @Query("SELECT NEW ru.practicum.dto.ViewStats(h.app, h.uri, COUNT(h.ip)) " +
            "FROM Hit h WHERE h.timestamp BETWEEN :start AND :end AND h.uri IN (:uris) " +
            "GROUP BY h.uri, h.ip, h.app " +
            "ORDER BY COUNT(h.ip) DESC")
    List<ViewStats> findAllByIp(LocalDateTime start, LocalDateTime end, List<String> uris);
}


