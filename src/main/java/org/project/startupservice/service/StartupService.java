package org.project.startupservice.service;

import lombok.RequiredArgsConstructor;
import org.project.startupservice.dto.StartupCreateDto;
import org.project.startupservice.dto.StartupDto;
import org.project.startupservice.dto.StartupResponseCreateDto;
import org.project.startupservice.mapper.StartupMapper;
import org.project.startupservice.model.Startup;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final StartupMapper startupMapper;
    private final ImageService imageService;

    public StartupResponseCreateDto create(StartupCreateDto startupDto) {

        Startup startup = startupMapper.toEntity(startupDto);
        String fileName = imageService.uploadImage(startupDto.getCover());

        startup.setUrl(fileName);

        savedSlides();



        return new StartupResponseCreateDto();
    }

    public StartupUpdate update(Long startupId) {

    }

    public void delete(Long startupId) {

    }

    public List<StartupFeedDto> allStartup(List<CategoryDto> filter) {

    }

    public List<StartupDto> allStartupForFounder(Long founderId) {

    }

    public StartupDto getStartup(Long id) {

    }
}
