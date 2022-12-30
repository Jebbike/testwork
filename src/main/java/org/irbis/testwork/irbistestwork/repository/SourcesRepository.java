package org.irbis.testwork.irbistestwork.repository;

import org.irbis.testwork.irbistestwork.model.Source;
import org.irbis.testwork.irbistestwork.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourcesRepository extends JpaRepository<Source, Long> {
}
