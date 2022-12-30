package org.irbis.testwork.irbistestwork.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.irbis.testwork.irbistestwork.service.NewsService;
import org.irbis.testwork.irbistestwork.service.SourcesService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final SourcesService sourcesService;
    private final NewsService newsService;
    private final FileWriterService fileWriterService;

    private final ExecutorService executor = Executors.newFixedThreadPool(4);


    @Scheduled(cron = "0 12 * * * *")
    @SneakyThrows(InterruptedException.class)
    public void runReports() {
        List<Callable<String>> tasks = sourcesService.getSourcesDomains().stream()
                .map(domain -> (Callable<String>) () -> {
                    Map<String, Long> newsCountFromSource = newsService.getNewsCountFromSource(domain);
                    fileWriterService.write(domain, newsCountFromSource);
                    return domain;
                })
                .toList();
        for (Future<String> future : executor.invokeAll(tasks)) {
            try {
                log.info("report for source {} is ended", future.get());
            } catch (ExecutionException e) {
                log.info("report for any of sources is ended with error");
            }
        }
    }

}
