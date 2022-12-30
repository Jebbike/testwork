package org.irbis.testwork.irbistestwork.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sources")
public class Source {

    @Id
    @GeneratedValue(generator = "sources_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sources_id_gen", sequenceName = "sources_id_seq", allocationSize = 1)
    private Long id;
    private String domain;

    @OneToMany(mappedBy = "source")
    private List<News> news;
}
