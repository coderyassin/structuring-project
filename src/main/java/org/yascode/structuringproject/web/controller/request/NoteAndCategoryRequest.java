package org.yascode.structuringproject.web.controller.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;
import org.yascode.structuringproject.web.controller.contract.Validatable;
import org.yascode.structuringproject.web.dto.CategoryDTO;
import org.yascode.structuringproject.web.dto.NoteDTO;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteAndCategoryRequest implements Validatable<NoteDTO, CategoryDTO> {
    @JsonAlias("note")
    private NoteDTO noteDTO;

    @JsonAlias("category")
    private CategoryDTO categoryDTO;

    @Override
    public NoteDTO getValidatableT() {
        return noteDTO;
    }

    @Override
    public CategoryDTO getValidatableN() {
        return categoryDTO;
    }
}
