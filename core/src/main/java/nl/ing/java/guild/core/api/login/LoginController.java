package nl.ing.java.guild.core.api.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping(consumes = APPLICATION_JSON_VALUE , produces = APPLICATION_JSON_VALUE)
    public LoginResponse login(@RequestBody @Valid @NotNull LoginRequest loginRequest) {
        log.info("new request arrived {}", loginRequest);
        LoginResponse loginResponse = null;
            if (loginRequest.getLoginId().equalsIgnoreCase("ashish.jain@ing.com")){
                log.info("matching email");

                 loginResponse = LoginResponse.builder().role(Login.CUSTOMERROLE).build();
        }

        return loginResponse;

    }


}
