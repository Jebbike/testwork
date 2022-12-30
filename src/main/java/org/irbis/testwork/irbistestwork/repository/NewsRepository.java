package org.irbis.testwork.irbistestwork.repository;

import org.irbis.testwork.irbistestwork.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
    Page<News> findAllByThemes_Name(String themeName, Pageable pageable);
    Page<News> findAllBySource_Domain(String sourceDomain, Pageable pageable);
}
