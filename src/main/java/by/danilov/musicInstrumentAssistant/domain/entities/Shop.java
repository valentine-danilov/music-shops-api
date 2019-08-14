package by.danilov.musicInstrumentAssistant.domain.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shop")
public class Shop extends AbstractEntity {

    @NotBlank(message = "Shop name should not be blank")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Shop address should not be null")
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank(message = "Shop phone number should not be null")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "website")
    private String website;
}
