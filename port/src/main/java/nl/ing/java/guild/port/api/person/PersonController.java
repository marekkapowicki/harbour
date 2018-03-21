package nl.ing.java.guild.port.api.person;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.guild.port.domain.person.PersonFacade;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static nl.ing.java.guild.port.api.Specification.ROOT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = ROOT + "/people")
@Api(value = "People")
public class PersonController {

    private final PersonFacade personFacade;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Long register(@RequestBody @Valid @NotNull PersonCreateRequest createRequest) {
        log.info("new request arrived {}", createRequest);
        return personFacade.create(createRequest);
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public PersonDTO retrieve(@PathVariable("id") String id) {
        log.info("retrieve person by id={}", id);
        return personFacade.retrieve(id);
    }
}