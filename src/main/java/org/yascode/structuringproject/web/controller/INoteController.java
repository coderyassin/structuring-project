package org.yascode.structuringproject.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.yascode.structuringproject.web.controller.request.NoteAndCategoryRequest;

import java.util.Map;

public interface INoteController {

    String createNoteWithCategory(NoteAndCategoryRequest noteAndCategoryRequest,
                                  HttpServletRequest httpServletRequest);
    Map<String, Object> creationTestNote();

}
