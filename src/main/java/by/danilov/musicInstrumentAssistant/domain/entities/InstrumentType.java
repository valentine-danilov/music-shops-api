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
@Table(name = "instrument_type")
public class InstrumentType extends AbstractEntity {

    @NotBlank(message = "Instrument type should not be null")
    @Column(name = "name", nullable = false)
    private String name;
}
