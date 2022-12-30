package org.irbis.testwork.irbistestwork.repository;

import org.irbis.testwork.irbistestwork.model.News;
import org.irbis.testwork.irbistestwork.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
