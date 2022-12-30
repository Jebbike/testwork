package org.irbis.testwork.irbistestwork.scheduler;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FileWriterService {

    private static final String HEADER_ROW = "Тема;Количество новостей";

    public void write(String sourceDomain, Map<String, Long> newsCountFromSource) throws IOException {
        List<String> reportRows = newsCountFromSource.entrySet().stream()
                .map(entry -> String.join(";", entry.getKey(), entry.getValue().toString()))
                .collect(Collectors.toList());

        reportRows.add(0, HEADER_ROW);

        Files.write(Path.of(sourceDomain), reportRows, StandardOpenOption.CREATE_NEW, StandardOpenOption.APPEND);
    }

}
