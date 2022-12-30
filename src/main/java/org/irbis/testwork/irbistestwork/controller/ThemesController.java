package org.irbis.testwork.irbistestwork.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.irbis.testwork.irbistestwork.model.News;
import org.irbis.testwork.irbistestwork.model.Theme;
import org.irbis.testwork.irbistestwork.service.ThemesService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/themes")
@RequiredArgsConstructor
public class ThemesController {

    private final ThemesService themesService;

    @GetMapping
    public Page<Theme> getThemes(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return themesService.getThemes(page, size);
    }

}
