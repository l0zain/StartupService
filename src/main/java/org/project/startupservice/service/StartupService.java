package org.project.startupservice.service;

import lombok.RequiredArgsConstructor;
import org.project.startupservice.dto.*;
import org.project.startupservice.filter.StartupFilter;
import org.project.startupservice.mapper.StartupMapper;
import org.project.startupservice.model.Category;
import org.project.startupservice.model.Stage;
import org.project.startupservice.model.Startup;
import org.project.startupservice.repository.StartupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class StartupService {

    private final StartupMapper startupMapper;
    private final ImageService imageService;
    private final SlideService slideService;
    private final StartupRepository startupRepository;
    private final CategoryService categoryService;
    private final List<StartupFilter> filters;

    @Transactional
    public StartupCreateDto create(StartupCreateDto startupDto,
                                   MultipartFile cover,
                                   List<MultipartFile> slides) {

        Startup startup = startupMapper.toEntity(startupDto);

        String fileName = imageService.uploadImage(cover);
        startup.setUrl(fileName);
        startup.setUserId(1L); //blocker
        boolean flag = startup.getStage().equals(Stage.РАННИЙ);
        startup.setFlag(flag);

        Startup saved = startupRepository.save(startup);
        List<Long> categoriesId = categoryService.savedCategoties(startupDto.getCategoriesId(), saved);


        List<String> presign = slideService.handlerSlides(saved, slides);
        String preCover = imageService.generatePresignUrl(fileName);

        StartupCreateDto startupCreateDto = startupMapper.toDtoCreated(saved);
        startupCreateDto.setCategoriesId(categoriesId);
        startupCreateDto.setPaths(presign);
        startupCreateDto.setCover(preCover);
        startupCreateDto.setCategoriesId(startupDto.getCategoriesId());

        return startupCreateDto;
    }

//    public StartupUpdateDto update(Long startupId, StartupUpdateDto startupDto) {
//        Startup startup = startupRepository.findById(startupId).orElseThrow(
//                () -> new IllegalArgumentException("Startup not found"));
//
//        startupMapper.updateEntity(startup, startupDto);
//        startupRepository.save(startup);
//
//        return startupMapper.toDtoUpdated(startup);
//
//    }
//
//    public void delete(Long startupId) {
//        Startup startup = startupRepository.findById(startupId).orElseThrow();
//
//        startupRepository.delete(startup);
//    }
//
//    //TODO:paging
//    public List<StartupFeedDto> allStartup(StartupFilterDto filers, Pageable paging) {
//        Stream<Startup> startups = startupRepository.findAllByOrderByPromotionDescTitleAsc(paging).stream();
//
//        for (StartupFilter filter : filters) {
//            if (filter.isApplicable(filers)) {
//                filter.apply(startups, filers);
//            }
//        }
//
//        return startups.map(startupMapper::toStartupFeed).toList();
//    }
//
//    public List<StartupDto> allStartupForFounder(Long founderId) {
//        List<Startup> startupsByFounder = startupRepository.findAllByUserId(founderId);
//
//        return startupsByFounder.isEmpty() ? List.of() : startupsByFounder.stream().map(startupMapper::toDto).toList();
//
//    }

//    public StartupDto getStartup(Long id) {
//
//    }
}
