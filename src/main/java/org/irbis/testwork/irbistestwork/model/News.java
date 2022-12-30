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
@Table(name = "news")
public class News {

    @Id
    @GeneratedValue(generator = "news_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "news_id_gen", sequenceName = "news_id_seq", allocationSize = 1)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "source_id")
    private Source source;
    @ManyToMany
    private List<Theme> themes;

}
