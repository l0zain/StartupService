package org.project.startupservice.filter;

import org.project.startupservice.dto.StartupFilterDto;
import org.project.startupservice.model.Startup;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;
@Component
public class StageFilter implements StartupFilter {
    @Override
    public boolean isApplicable(StartupFilterDto startup) {
        return startup.getStage() != null;
    }

    @Override
    public Stream<Startup> apply(Stream<Startup> startups, StartupFilterDto filter) {
        return startups.filter(startup -> startup.getStage().name().equalsIgnoreCase(filter.getStage()));
    }
}
