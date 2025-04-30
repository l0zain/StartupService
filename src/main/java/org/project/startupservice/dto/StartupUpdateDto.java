package org.project.startupservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class StartupUpdateDto {
    @Size(max = 100, message = "")
    private String title;
    @Size(max = 100, message = "")
    private String shortDescription;
    @Size(max = 100, message = "")
    private String fullDescription;
    @Size(min = 1, message = "")
    private List<Long> categoriesId;
    private MultipartFile cover;
    private List<MultipartFile> slides;
}
