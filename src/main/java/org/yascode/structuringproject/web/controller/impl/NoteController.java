/**
 * The class org.yascode.structuringproject.web.controller.impl is designed to provide api rest for managing notes and categories
 * and other functionalities related to the business of the application.
 *
 * @version 1.0.0
 * @since 2023-11-10
 * @author Yassin MELLOUKI
 */
package org.yascode.structuringproject.web.controller.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Validator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yascode.structuringproject.application.util.ValidationUtil;
import org.yascode.structuringproject.application.workflow.INoteCreationWorkflow;
import org.yascode.structuringproject.domain.model.Category;
import org.yascode.structuringproject.domain.model.Note;
import org.yascode.structuringproject.web.controller.INoteController;
import org.yascode.structuringproject.web.controller.request.NoteAndCategoryRequest;
import org.yascode.structuringproject.web.converter.CategoryConverter;
import org.yascode.structuringproject.web.converter.NoteConverter;
import org.yascode.structuringproject.web.dto.CategoryDTO;
import org.yascode.structuringproject.web.dto.NoteDTO;

import java.util.Map;
/**
 * The NOTES variable contains the url prefix of all api rests for this controller.
 */
import static org.yascode.structuringproject.web.api.NoteApiPaths.NOTES;
/**
 * The NOTE_WITH_CATEGORY variable contains l'url the rest of the api, which saves a note with its category
 */
import static org.yascode.structuringproject.web.api.NoteApiPaths.NOTE_WITH_CATEGORY;
/**
 * The NOTE_WITH_CATEGORY_TEST variable contains the rest of the api, which saves a note with its category for testing purposes
 */
import static org.yascode.structuringproject.web.api.NoteApiPaths.NOTE_WITH_CATEGORY_TEST;

@RestController
@RequestMapping(NOTES)
public class NoteController implements INoteController {

    protected final Log logger = LogFactory.getLog(this.getClass());
    private final Validator validator;
    private final INoteCreationWorkflow noteCreationService;
    private  final Note note;
    private  final Category category;

    public NoteController(final INoteCreationWorkflow noteCreationService,
                          final @Qualifier("noteBean") Note note,
                          final @Qualifier("categoryBean") Category category,
                          Validator validator) {
        this.noteCreationService = noteCreationService;
        this.note = note;
        this.category = category;
        this.validator = validator;
    }

    @Override
    @PostMapping(NOTE_WITH_CATEGORY)
    public String createNoteWithCategory(@RequestBody NoteAndCategoryRequest noteAndCategoryRequest,
                                         HttpServletRequest request) {


        if (ValidationUtil.validateRequest(noteAndCategoryRequest)) {

            /*String correlationId = (String) request.getAttribute("correlationId");

            System.out.println("Correlation ID : " + correlationId);*/

            NoteDTO noteDTO = noteAndCategoryRequest.getNoteDTO();

            CategoryDTO categoryDTO = noteAndCategoryRequest.getCategoryDTO();

            noteCreationService.createNoteWithCategory(noteDTO, categoryDTO);

            return "Note with category created successfully.";
        }
        return "Note with category not created.";
    }

    @Override
    @PostMapping(NOTE_WITH_CATEGORY_TEST)
    public Map<String, Object> creationTestNote() {

        Map<String, Object> savedItems = noteCreationService.createNoteWithCategory(NoteConverter.convertToDTO(cloneNote(note)),
                CategoryConverter.convertToDTO(cloneCategory(category)));

        logger.info("Note with category created successfully.");

        return savedItems;
    }

    private Note cloneNote(Note note) {
        return Note.builder()
                .title(note.getTitle())
                .content(note.getContent())
                .createAt(note.getCreateAt())
                .build();
    }

    private Category cloneCategory(Category category) {
        return Category.builder()
                .name(category.getName())
                .build();
    }
}
