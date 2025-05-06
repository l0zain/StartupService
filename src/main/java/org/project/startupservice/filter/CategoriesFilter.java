package org.project.startupservice.filter;

import org.project.startupservice.dto.CategoryDto;
import org.project.startupservice.dto.StartupFilterDto;
import org.project.startupservice.model.Category;
import org.project.startupservice.model.Startup;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class CategoriesFilter implements StartupFilter {
    @Override
    public boolean isApplicable(StartupFilterDto startup) {
        return startup.getCategories() != null;
    }

    @Override
    public Stream<Startup> apply(Stream<Startup> startups, StartupFilterDto filter) {
        List<Long> categoriesId = filter.getCategories().stream().map(CategoryDto::getId).toList();

        return startups.filter(startup -> startup.getCategories().stream()
                .map(Category::getId)
                .anyMatch(categoriesId::contains));
    }
}
