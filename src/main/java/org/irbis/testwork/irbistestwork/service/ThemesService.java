package org.irbis.testwork.irbistestwork.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.irbis.testwork.irbistestwork.model.Theme;
import org.irbis.testwork.irbistestwork.repository.ThemesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ThemesService {

    private final ThemesRepository themesRepository;

    public Page<Theme> getThemes(int page, int size) {
        return themesRepository.findAll(PageRequest.of(page, size));
    }

}
