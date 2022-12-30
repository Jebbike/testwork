package org.irbis.testwork.irbistestwork.service;

import lombok.RequiredArgsConstructor;
import org.irbis.testwork.irbistestwork.model.News;
import org.irbis.testwork.irbistestwork.repository.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    public Page<News> getNews(int page, int size) {
        return newsRepository.findAll(PageRequest.of(page, size));
    }

    public Page<News> getNewsWithTheme(String themeName, int page, int size) {
        return newsRepository.findAllByThemes_Name(themeName, PageRequest.of(page, size));
    }

    public Page<News> getNewsFromSource(String sourceDomain, int page, int size) {
        return newsRepository.findAllBySource_Domain(sourceDomain, PageRequest.of(page, size));
    }

}
