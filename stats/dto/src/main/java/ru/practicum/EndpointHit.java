package ru.practicum;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EndpointHit {
    private Long id;
    private String app;
    private String uri;
    private String ip;
    private LocalDateTime timestamp; //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
}
