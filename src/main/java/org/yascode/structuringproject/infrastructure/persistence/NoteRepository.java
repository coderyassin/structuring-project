package org.yascode.structuringproject.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.structuringproject.domain.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
