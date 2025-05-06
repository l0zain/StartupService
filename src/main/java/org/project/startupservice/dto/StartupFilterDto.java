package org.project.startupservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class StartupFilterDto {
    private List<CategoryDto> categories;
    private String stage;
}
