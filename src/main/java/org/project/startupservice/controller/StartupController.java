package org.project.startupservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.project.startupservice.dto.StartupCreateDto;
import org.project.startupservice.dto.StartupResponseCreateDto;
import org.project.startupservice.service.StartupService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/startup")
public class StartupController {
    private final StartupService startupService;

    @PostMapping()
    public StartupCreateDto create(@Valid @RequestPart StartupCreateDto startupDto,
                                   @RequestPart MultipartFile cover,
                                   @RequestPart List<MultipartFile> slides) {
        return startupService.create(startupDto, cover, slides);
    }
}
