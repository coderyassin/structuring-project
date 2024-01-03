package org.yascode.structuringproject.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.structuringproject.domain.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
