package org.project.startupservice.controller;

import lombok.RequiredArgsConstructor;
import org.project.startupservice.dto.StartupCreateDto;
import org.project.startupservice.dto.StartupResponseCreateDto;
import org.project.startupservice.service.StartupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/startup")
public class StartupController {
    private final StartupService startupService;

    @GetMapping()
    public StartupResponseCreateDto create(StartupCreateDto startupDto) {
        startupService.create(startupDto);
        return new StartupResponseCreateDto();
    }
}
