package org.yascode.structuringproject.application.workflow.impl;

import org.springframework.stereotype.Service;
import org.yascode.structuringproject.application.workflow.INoteCreationWorkflow;
import org.yascode.structuringproject.domain.model.Category;
import org.yascode.structuringproject.domain.model.Note;
import org.yascode.structuringproject.domain.service.ICategoryService;
import org.yascode.structuringproject.domain.service.INoteService;
import org.yascode.structuringproject.web.dto.CategoryDTO;
import org.yascode.structuringproject.web.dto.NoteDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the {@link INoteCreationWorkflow} interface for creating notes with categories.
 */
@Service
public class NoteCreationWorkflow implements INoteCreationWorkflow {
    /**
     * Service for handling notes.
     */
    private final INoteService noteService;

    /**
     * Service for handling categories.
     */
    private final ICategoryService categoryService;


    /**
     * Constructor for NoteCreationWorkflow.
     *
     * @param noteServiceA     The service for handling notes.
     * @param categoryServiceA The service for handling categories.
     */
    public NoteCreationWorkflow(final INoteService noteServiceA,
                                final ICategoryService categoryServiceA) {
        this.noteService = noteServiceA;
        this.categoryService = categoryServiceA;
    }

    /**
     * Creates a note with a specified category.
     *
     * @param noteDTO     The DTO representing the note.
     * @param categoryDTO The DTO representing the category.
     * @return A map containing the saved category and note.
     * @throws RuntimeException if there is an issue with number formatting.
     */
    @Override
    public Map<String, Object> createNoteWithCategory(final NoteDTO noteDTO,
                                                      final CategoryDTO categoryDTO) {
        try {
            Map<String, Object> savedItems = new HashMap<>();
            CategoryDTO categorySaved = categoryService.createCategory(categoryDTO);
            noteDTO.setCategoryId(categorySaved.getId());
            NoteDTO noteSaved = noteService.createNote(noteDTO);
            savedItems.put(Category.class.getSimpleName(), categorySaved);
            savedItems.put(Note.class.getSimpleName(), noteSaved);
            return savedItems;
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
