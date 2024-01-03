package org.yascode.structuringproject.domain.service.impl;

import org.springframework.stereotype.Service;
import org.yascode.structuringproject.domain.model.Note;
import org.yascode.structuringproject.domain.service.INoteService;
import org.yascode.structuringproject.infrastructure.persistence.NoteRepository;
import org.yascode.structuringproject.web.converter.NoteConverter;
import org.yascode.structuringproject.web.dto.NoteDTO;

import java.util.List;

@Service
public class NoteService implements INoteService {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long noteId) {
        throw new UnsupportedOperationException("This method is not yet implemented.");
    }

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        Note noteSaved = noteRepository.save(NoteConverter.convertToEntity(noteDTO));
        return NoteConverter.convertToDTO(noteSaved);
    }

    @Override
    public void updateNote(Long noteId, Note updatedNote) {
        throw new UnsupportedOperationException("This method is not yet implemented.");
    }

    @Override
    public void deleteNote(Long noteId) {
        throw new UnsupportedOperationException("This method is not yet implemented.");
    }
}
