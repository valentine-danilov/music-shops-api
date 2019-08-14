package by.danilov.musicInstrumentAssistant.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "instrument")
public class Instrument extends AbstractEntity {

    @NotNull(message = "Manufacturer should not be null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @NotNull(message = "Instrument type should not be null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", nullable = false)
    private InstrumentType instrumentType;

    @NotNull(message = "Instrument class should not be null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id", nullable = false)
    private InstrumentClass instrumentClass;

    @NotBlank(message = "Instrument model should not be blank")
    @Column(name = "model", nullable = false)
    private String model;

}
