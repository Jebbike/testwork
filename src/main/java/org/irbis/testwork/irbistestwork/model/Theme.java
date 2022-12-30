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
@Table(name = "themes")
public class Theme {

    @Id
    @GeneratedValue(generator = "news_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "news_id_gen", sequenceName = "news_id_seq", allocationSize = 1)
    private Long id;
    private String name;

    @ManyToMany
    private List<News> news;
}
