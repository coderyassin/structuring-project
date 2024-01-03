package org.yascode.structuringproject.web.dto;

import lombok.*;
import org.yascode.structuringproject.application.validation.NamePattern;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {
    private Long id;
    @NamePattern
    private String name;
}
