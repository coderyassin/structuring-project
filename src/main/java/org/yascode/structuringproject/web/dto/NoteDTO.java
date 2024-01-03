package org.yascode.structuringproject.web.dto;

import lombok.*;
import org.yascode.structuringproject.application.validation.PastDate;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteDTO {
    private Long id;
    private String title;
    private String content;
    @PastDate
    private LocalDateTime createAt;
    private Long categoryId;
}
