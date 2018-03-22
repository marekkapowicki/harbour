package nl.ing.java.guild.port.api;

import nl.ing.java.client.customer.Container;

public class Cointainers {
    static Container apples = Container.builder()
            .containerId("someId_1")
            .name("Shipment # 1")
            .size("40 ft")
            .location("Utrecht")
            .info("some apples")
            .build();
    static Container plums = Container.builder()
            .containerId("someId_2")
            .name("Shipment # 2")
            .size("50 ft")
            .location("Venlo")
            .info("some plums")
            .build();
    static Container mangos = Container.builder()
            .containerId("someId_3")
            .name("Shipment # 3")
            .size("60 ft")
            .location("Amsterdam")
            .info("some plums")
            .build();
    static Container number1 = Container.builder()
            .containerId("someId_4")
            .name("Shipment # 4")
            .size("60 ft")
            .location("Brussels")
            .info("some plums")
            .build();
    static Container number2 = Container.builder()
            .containerId("someId_5")
            .name("Shipment # 5")
            .size("30 ft")
            .location("Bruges")
            .info("some plums")
            .build();
    static Container number3 = Container.builder()
            .containerId("someId_6")
            .name("Shipment # 6")
            .size("40 ft")
            .location("Delft")
            .info("some plums")
            .build();
}
