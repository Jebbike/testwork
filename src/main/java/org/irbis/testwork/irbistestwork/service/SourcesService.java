package org.irbis.testwork.irbistestwork.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.irbis.testwork.irbistestwork.model.Source;
import org.irbis.testwork.irbistestwork.repository.SourcesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SourcesService {

    private final SourcesRepository sourcesRepository;

    public Page<Source> getSources(int page, int size) {
        return sourcesRepository.findAll(PageRequest.of(page, size));
    }

}
