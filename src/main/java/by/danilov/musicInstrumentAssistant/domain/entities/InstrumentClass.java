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
@Table(name = "instrument_class")
public class InstrumentClass extends AbstractEntity {

    @NotBlank(message = "Instrument class name should not be null")
    @Column(name = "name")
    private String name;
}
