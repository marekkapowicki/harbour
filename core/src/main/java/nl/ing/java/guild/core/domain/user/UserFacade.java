package nl.ing.java.guild.core.domain.user;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.guild.common.login.LoginRequest;
import nl.ing.java.guild.common.login.LoginResponse;
import nl.ing.java.guild.core.domain.error.ResourceNotFound;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Component
@Slf4j
public class UserFacade {
    private final UserRepository userRepository;

    @Transactional
    public LoginResponse login(LoginRequest loginRequest) {
      log.info("the login request", loginRequest);
      return userRepository.findByLoginIdAndPassword(loginRequest.getLoginId(), loginRequest.getPassword())
              .map(user -> LoginResponse.builder().role(user.getRole()).build())
              .orElseThrow(() -> new ResourceNotFound(loginRequest.getLoginId()));
    }
}
