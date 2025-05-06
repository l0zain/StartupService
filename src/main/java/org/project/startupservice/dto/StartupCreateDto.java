package org.project.startupservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Data
public class StartupCreateDto {
    private Long id;
    @NotBlank(message = "")
    @NotNull(message = "")
    @Size(max = 100, message = "")
    private String title;
    @NotBlank(message = "")
    @NotNull(message = "")
    @Size(max = 100, message = "")
    private String shortDescription;
    @NotBlank(message = "")
    @NotNull(message = "")
    @Size(max = 100, message = "")
    private String longDescription;
    @NotNull(message = "")
    private List<Long> categoriesId;
    @NotNull(message = "")
    private String stage;

    private boolean flag;
    private List<String> paths;
    private String cover;
}
