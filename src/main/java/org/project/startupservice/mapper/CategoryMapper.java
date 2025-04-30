package org.project.startupservice.mapper;

import org.mapstruct.Mapper;
import org.project.startupservice.dto.CategoryDto;
import org.project.startupservice.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDto(Category category);
}
