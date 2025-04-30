package org.project.startupservice.dto;

import java.util.List;

public class StartupResponseCreateDto {
    private Long id;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private List<CategoryDto> categories;
    private String cover;
    private String stage;
}
