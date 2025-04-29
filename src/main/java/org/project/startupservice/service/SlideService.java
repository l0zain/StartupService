package org.project.startupservice.service;

import lombok.RequiredArgsConstructor;
import org.project.startupservice.model.Slide;
import org.project.startupservice.model.Startup;
import org.project.startupservice.model.Status;
import org.project.startupservice.repository.SlideRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SlideService {
    private final ImageService imageService;
    private final SlideRepository slideRepository;

    public void handlerSlides(Startup startup, List<MultipartFile> slides) {
        if (slides.isEmpty()) {
            throw new IllegalArgumentException();
        }

        List<String> paths = slides.stream()
                .map(imageService::uploadImage)
                .toList();
        List<Slide> slidesForSave = new ArrayList<>();

        for (int i = 0; i < paths.size(); i++) {
            slidesForSave.add(
                    Slide.builder()
                            .startup(startup)
                            .url(paths.get(i))
                            .order(i)
                            .status(Status.МОДЕРАЦИЯ)
                            .build()
            );
        }

        //TODO:идентити не принимает, поменять!!
        slideRepository.saveAll(slidesForSave);
    }

}
