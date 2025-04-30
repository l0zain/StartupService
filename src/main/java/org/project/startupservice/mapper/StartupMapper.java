package org.project.startupservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.project.startupservice.dto.StartupCreateDto;
import org.project.startupservice.dto.StartupUpdateDto;
import org.project.startupservice.model.Startup;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StartupMapper {
    @Mapping(target = "slides", ignore = true)
    Startup toEntity(StartupCreateDto startupDto);

    void updateEntity(@MappingTarget Startup startup, StartupUpdateDto startupUpdateDto);

    StartupUpdateDto toDtoUpdated(Startup startup);


}
