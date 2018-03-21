package nl.ing.java.guild.mp.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class MarketPlace {

    private Long id;
    private Long transportId;
    private String marketName;
    private LocalDateTime marketSendDate;
    private LocalDateTime marketArrivalDate;
    private BigDecimal marketTotalPrice;
    private Long marketPercPositiveFeedback;
}
