package org.irbis.testwork.irbistestwork.service;

import lombok.RequiredArgsConstructor;
import org.irbis.testwork.irbistestwork.model.News;
import org.irbis.testwork.irbistestwork.model.Theme;
import org.irbis.testwork.irbistestwork.repository.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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
        return newsRepository.findAllNewsBySourceDomain(sourceDomain, PageRequest.of(page, size));
    }

    public Map<String, Long> getNewsCountFromSource(String sourceDomain) {
        Map<String, Long> themeCountMap = new HashMap<>();
        for (News news : newsRepository.findAllNewsBySourceDomain(sourceDomain)) {
            for (Theme theme : news.getThemes()) {
                themeCountMap.compute(theme.getName(), (key, value) -> value == null ? 1L : value + 1);
            }
        }
        return themeCountMap;
    }

}
