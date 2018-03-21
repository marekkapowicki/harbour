package nl.ing.java.guild.core.api.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginRequest {

    @NotNull
    private String loginId;
    @NotNull
    private String password;

}
