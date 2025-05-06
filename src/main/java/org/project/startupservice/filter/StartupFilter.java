package org.project.startupservice.filter;

import org.project.startupservice.dto.StartupFilterDto;
import org.project.startupservice.model.Startup;

import java.util.stream.Stream;

public interface StartupFilter {
    boolean isApplicable(StartupFilterDto startup);
    Stream<Startup> apply(Stream<Startup> startups, StartupFilterDto filter);
}
