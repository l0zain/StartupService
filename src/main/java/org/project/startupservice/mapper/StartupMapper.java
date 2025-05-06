package org.project.startupservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.startupservice.dto.StartupCreateDto;
import org.project.startupservice.dto.StartupDto;
import org.project.startupservice.dto.StartupFeedDto;
import org.project.startupservice.dto.StartupUpdateDto;
import org.project.startupservice.model.Startup;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StartupMapper {
    @Mapping(target = "slides", ignore = true)
    @Mapping(source = "longDescription", target = "longDescription")
    Startup toEntity(StartupCreateDto startupDto);

    StartupCreateDto toDtoCreated(Startup startup);

    void updateEntity(@MappingTarget Startup startup, StartupUpdateDto startupUpdateDto);

    @Mapping(target = "cover", ignore = true)
    @Mapping(target = "slides", ignore = true)
    StartupUpdateDto toDtoUpdated(Startup startup);

    StartupFeedDto toStartupFeed(Startup startup);

    StartupDto toDto(Startup startup);


}
