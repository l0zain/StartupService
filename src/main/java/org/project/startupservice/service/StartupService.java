package org.project.startupservice.service;

import lombok.RequiredArgsConstructor;
import org.project.startupservice.dto.*;
import org.project.startupservice.mapper.StartupMapper;
import org.project.startupservice.model.Stage;
import org.project.startupservice.model.Startup;
import org.project.startupservice.repository.StartupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final StartupMapper startupMapper;
    private final ImageService imageService;
    private final SlideService slideService;
    private final StartupRepository startupRepository;
    private final CategoryService categoryService;

    @Transactional
    public StartupResponseCreateDto create(StartupCreateDto startupDto) {

        Startup startup = startupMapper.toEntity(startupDto);

        String fileName = imageService.uploadImage(startupDto.getCover());
        startup.setUrl(fileName);

        List<MultipartFile> slides = startupDto.getSlides();
        slideService.handlerSlides(startup, slides);

        startup.setCategories(categoryService.findCategories(startup, startupDto.getCategoriesId()));
        startup.setPromotion();
        startup.setUserId();
        startup.setFlag();
        startup.setStatus();
        startup.setCreated();

        Startup saved = startupRepository.save(startup);


        return new StartupResponseCreateDto();
    }

    public StartupUpdateDto update(Long startupId, StartupUpdateDto startupDto) {
        Startup startup = startupRepository.findById(startupId).orElseThrow(
                () -> new IllegalArgumentException("Startup not found"));

        startupMapper.updateEntity(startup, startupDto);
        startupRepository.save(startup);

        return startupMapper.toDtoUpdated(startup);

    }

    public void delete(Long startupId) {
        Startup startup = startupRepository.findById(startupId).orElseThrow();

        startupRepository.delete(startup);
    }

    //paging
    public List<StartupFeedDto> allStartup(List<CategoryDto> filter, Stage stage, Pageable paging) {

    }

    public List<StartupDto> allStartupForFounder(Long founderId) {

    }

    public StartupDto getStartup(Long id) {

    }
}
