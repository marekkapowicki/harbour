package nl.ing.java.guild.core.api.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginRequest {

    private  String loginId;
    private  String password;

}
