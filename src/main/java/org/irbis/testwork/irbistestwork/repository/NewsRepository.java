package org.irbis.testwork.irbistestwork.repository;

import org.irbis.testwork.irbistestwork.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    Page<News> findAllByThemes_Name(String themeName, Pageable pageable);
    Page<News> findAllNewsBySourceDomain(String sourceDomain, Pageable pageable);

    @Query("from Source s join Theme t where s.domain = :sourceDomain")
    List<News> findAllNewsBySourceDomain(@Param("sourceDomain") String sourceDomain);

}
