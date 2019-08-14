package by.danilov.musicInstrumentAssistant.domain.entities;

import by.danilov.musicInstrumentAssistant.domain.enumeration.PostgreSqlEnumType;
import by.danilov.musicInstrumentAssistant.domain.enumeration.Role;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user\"")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSqlEnumType.class
)
public class User extends AbstractEntity {
    @NotBlank(message = "Login should not be empty")
    @Length(min = 3, max = 45,
            message = "Login should have length from 3 to 45 symbols")
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @NotBlank(message = "Password should not be empty")
    @Length(min = 4, max = 35, message =
            "Password should have length from 6 to 35 symbols")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "\"role\"", nullable = false)
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    private Role role;
}
