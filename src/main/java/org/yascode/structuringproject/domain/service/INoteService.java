package org.yascode.structuringproject.domain.service;

import org.yascode.structuringproject.domain.model.Note;
import org.yascode.structuringproject.web.dto.NoteDTO;

import java.util.List;

public interface INoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long noteId);
    NoteDTO createNote(NoteDTO noteDTO);
    void updateNote(Long noteId, Note updatedNote);
    void deleteNote(Long noteId);

}
