package org.yascode.structuringproject.web.converter;

import org.modelmapper.ModelMapper;
import org.yascode.structuringproject.domain.model.Note;
import org.yascode.structuringproject.web.dto.NoteDTO;

public class NoteConverter {
    private static ModelMapper modelMapper = new ModelMapper();
    public static NoteDTO convertToDTO(Note note) {
        return modelMapper.map(note, NoteDTO.class);
    }

    public static Note convertToEntity(NoteDTO noteDTO) {
        return modelMapper.map(noteDTO, Note.class);
    }
}

