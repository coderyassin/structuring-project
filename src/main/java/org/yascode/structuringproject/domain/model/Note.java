package org.yascode.structuringproject.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import org.yascode.structuringproject.application.validation.PastDate;

import java.time.LocalDateTime;

/**
 * Represents a note in the application domain model.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Note {
    /**
     * Unique identifier for the note.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title of the note.
     */
    private String title;

    /**
     * Content of the note.
     */
    private String content;

    /**
     * Creation date of the note. Must be a past date.
     */
    @PastDate
    private LocalDateTime createAt;

    /**
     * Category to which the note belongs.
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
