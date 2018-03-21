package nl.ing.java.guild.port;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Port {
    private Long id;
    private String name;
    private String phone;
}
