package by.danilov.musicInstrumentAssistant.domain.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "country")
public class Country extends AbstractEntity {

    @NotBlank(message = "Country name should not be empty")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
