package org.project.startupservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.project.startupservice.dto.StartupCreateDto;
import org.project.startupservice.model.Startup;

@Mapper(componentModel = "spring")
public interface StartupMapper {
    @Mapping(target = "slides", ignore = true)
    Startup toEntity(StartupCreateDto startupDto);
}
