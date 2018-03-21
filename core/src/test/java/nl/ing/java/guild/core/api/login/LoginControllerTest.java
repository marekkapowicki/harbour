package nl.ing.java.guild.core.api.login;

import com.jayway.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static nl.ing.java.guild.core.api.Specification.ROOT;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LoginControllerTest {

    @Value("${local.server.port}")
    int serverPort;

    @Before
    public void setup() {
        RestAssured.port = serverPort;
    }

    @Test
    public void shouldLoginUser() {
        given()
                .contentType(APPLICATION_JSON_VALUE)
                .body(LoginUserRequests.valid_user)
        .when()
                .post(ROOT + "/login")
        .then()
                .statusCode(HttpStatus.SC_OK);
    }
}