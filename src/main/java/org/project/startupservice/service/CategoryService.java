package org.project.startupservice.service;

import lombok.RequiredArgsConstructor;
import org.project.startupservice.model.Category;
import org.project.startupservice.model.Startup;
import org.project.startupservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public List<Long> savedCategoties(List<Long> categoryIds, Startup startup) {
        if (verify(categoryIds)) {
            List<Category> categories = categoryRepository.findAllById(categoryIds);
            categories.forEach(
                    category -> {
                        category.getStartups().add(startup);
                    }
            );
            categoryRepository.saveAll(categories);
            return categories.stream().map(Category::getId).toList();
        }
        else throw new IllegalArgumentException();
    }


    private boolean verify(List<Long> categoryIds) {
        if (!categoryIds.isEmpty()) {
            return categoryIds.stream().allMatch(categoryRepository::existsById);
        }
        return false;
    }
}
