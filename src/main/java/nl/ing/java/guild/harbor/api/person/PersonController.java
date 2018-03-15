package nl.ing.java.guild.harbor.api.person;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.guild.harbor.domain.person.PersonFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static nl.ing.java.guild.harbor.api.Specification.ROOT;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = ROOT + "/people")
@Api(value = "People")
public class PersonController {

    private final PersonFacade personFacade;
}
