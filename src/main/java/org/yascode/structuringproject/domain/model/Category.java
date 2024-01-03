package org.yascode.structuringproject.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import org.yascode.structuringproject.application.validation.NamePattern;

import java.util.List;

/**
 * Represents a category in the application domain model.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category {
    /**
     * Unique identifier for the category.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the category. Must adhere to the specified name pattern.
     */
    @NamePattern
    private String name;

    /**
     * List of notes associated with this category.
     */
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Note> notes;
}
