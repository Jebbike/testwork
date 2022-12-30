package org.irbis.testwork.irbistestwork.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.irbis.testwork.irbistestwork.model.News;
import org.irbis.testwork.irbistestwork.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController("/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public Page<News> getNews(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return newsService.getNews(page, size);
    }

    @GetMapping("/theme/{themeName}")
    public Page<News> getNewsWithTheme(
            @PathVariable String themeName,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return newsService.getNewsWithTheme(themeName, page, size);
    }

    @GetMapping("/source/{sourceName}")
    public Page<News> getNewsFromSource(
            @PathVariable String sourceName,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        return newsService.getNewsFromSource(sourceName, page, size);
    }

}
