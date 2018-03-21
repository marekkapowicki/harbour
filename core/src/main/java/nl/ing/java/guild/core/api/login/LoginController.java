package nl.ing.java.guild.core.api.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.client.login.LoginRequest;
import nl.ing.java.client.login.LoginResponse;
import nl.ing.java.guild.core.domain.user.UserFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static nl.ing.java.guild.core.api.Specification.ROOT;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = ROOT + "/login")
public class LoginController {

    @NotNull
    private final UserFacade userFacade;

    @PostMapping(consumes = APPLICATION_JSON_VALUE , produces = APPLICATION_JSON_VALUE)
    public LoginResponse login(@RequestBody @Valid @NotNull LoginRequest loginRequest) {
        log.info("new request arrived {}", loginRequest);
        return userFacade.login(loginRequest);

    }


}
