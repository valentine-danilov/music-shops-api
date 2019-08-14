package by.danilov.musicInstrumentAssistant.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product extends AbstractEntity {

    @NotBlank(message = "Instrument in product should not be null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instrument_id", nullable = false)
    private Instrument instrument;

    @NotBlank(message = "Country should not be null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @NotNull(message = "Product should have price")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotNull(message = "Product quantity should not be null")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
