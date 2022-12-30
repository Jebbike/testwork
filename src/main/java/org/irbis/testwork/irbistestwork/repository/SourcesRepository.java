package org.irbis.testwork.irbistestwork.repository;

import org.irbis.testwork.irbistestwork.model.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SourcesRepository extends JpaRepository<Source, Long> {

    @Query(nativeQuery = true, value = "select domain from sources")
    List<String> getAllSourcesDomains();
}
