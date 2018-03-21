package nl.ing.java.guild.port;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController("/ports")
public class PortController {

    @GetMapping
    public List<Port> ports() {
        Port port1 = Port.builder().id(1L).name("Rotherdam").phone("3124214211").build();
        Port port2 = Port.builder().id(2L).name("Rotherdam").phone("3124214211").build();
        Port port3 = Port.builder().id(3L).name("Rotherdam").phone("3124214211").build();
        Port port4 = Port.builder().id(4L).name("Rotherdam").phone("3124214211").build();
        Port port5 = Port.builder().id(5L).name("Rotherdam").phone("3124214211").build();
        Port port6 = Port.builder().id(6L).name("Rotherdam").phone("3124214211").build();
        Port port7 = Port.builder().id(7L).name("Rotherdam").phone("3124214211").build();
        Port port8 = Port.builder().id(8L).name("Rotherdam").phone("3124214211").build();
        Port port9 = Port.builder().id(9L).name("Rotherdam").phone("3124214211").build();
        List<Port> ports = Arrays.asList(port1,port2,port3,port4,port5,port6,port7,port8,port9);
        return ports;
    }
}
