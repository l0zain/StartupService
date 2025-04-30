package org.project.startupservice.service;

import lombok.RequiredArgsConstructor;
import org.project.startupservice.model.Category;
import org.project.startupservice.model.Startup;
import org.project.startupservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findCategories(Startup startup, List<Long> categoryIds) {
        if (verify(categoryIds)) {
            return categoryRepository.findAllById(categoryIds);
        }
        throw new IllegalArgumentException();
    }

    private boolean verify(List<Long> categoryIds) {
        if (!categoryIds.isEmpty()) {
            return categoryIds.stream().allMatch(categoryRepository::existsById);
        }
        return false;
    }
}
