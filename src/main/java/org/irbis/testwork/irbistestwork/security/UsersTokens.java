package org.irbis.testwork.irbistestwork.security;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users_tokens")
public class UsersTokens {

    @Id
    @GeneratedValue(generator = "users_tokens_id_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_tokens_id_gen", sequenceName = "users_tokens_id_seq", allocationSize = 1)
    private Long id;
    @Column(columnDefinition = "uuid")
    private UUID token;
}
