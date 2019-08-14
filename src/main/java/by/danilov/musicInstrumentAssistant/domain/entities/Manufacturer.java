package by.danilov.musicInstrumentAssistant.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "manufacturer")
public class Manufacturer extends AbstractEntity {

    @NotBlank(message = "Name should not be null")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Country should not be null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
