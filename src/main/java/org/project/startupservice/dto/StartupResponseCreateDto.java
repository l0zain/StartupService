package org.project.startupservice.dto;

import org.project.startupservice.model.Stage;

import java.util.List;

public class StartupResponseCreateDto {
    private Long id;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private List<Long> categoriesId;
    private String cover;
    private Stage stage;
}
