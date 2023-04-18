package ru.practicum.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewStats {
    private String app;
    private String uri;
    private Long hits;

    public ViewStats(String app, Long hits) {
        this.app = app;
        this.hits = hits;
    }
}
