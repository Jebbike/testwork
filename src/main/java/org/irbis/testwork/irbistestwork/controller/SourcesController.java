package org.irbis.testwork.irbistestwork.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.irbis.testwork.irbistestwork.model.Source;
import org.irbis.testwork.irbistestwork.service.SourcesService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/v1/sources")
@RequiredArgsConstructor
public class SourcesController {

    private final SourcesService sourcesService;

    @GetMapping
    public Page<Source> getSources(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return sourcesService.getSources(page, size);
    }

}
