package org.yascode.structuringproject.application.workflow;

import org.yascode.structuringproject.web.dto.CategoryDTO;
import org.yascode.structuringproject.web.dto.NoteDTO;

import java.util.Map;

/**
 * Interface defining the workflow for creating notes with categories.
 */
public interface INoteCreationWorkflow {

    /**
     * Creates a note with a specified category.
     *
     * @param noteDTO     The DTO representing the note.
     * @param categoryDTO The DTO representing the category.
     * @return A map containing the saved category and note.
     */
    Map<String, Object> createNoteWithCategory(NoteDTO noteDTO, CategoryDTO categoryDTO);

}
