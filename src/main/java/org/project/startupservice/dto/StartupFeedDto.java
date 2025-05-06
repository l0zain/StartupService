package org.project.startupservice.dto;

import lombok.Data;

@Data
public class StartupFeedDto {
    private Long id;
    private String title;
    private String shortDescription;
    private String url;
    private String stage;
}
