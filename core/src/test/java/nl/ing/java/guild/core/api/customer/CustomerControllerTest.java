package nl.ing.java.guild.core.api.customer;

import com.jayway.restassured.RestAssured;
import nl.ing.java.client.customer.Container;
import nl.ing.java.client.customer.CustomerResponse;
import nl.ing.java.guild.core.domain.order.CustomerFacade;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static com.jayway.restassured.RestAssured.given;
import static nl.ing.java.guild.core.api.Specification.ROOT;
import static nl.ing.java.guild.core.api.customer.Cointainers.apples;
import static nl.ing.java.guild.core.api.customer.Cointainers.plums;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CustomerControllerTest {

    public static final String EMAIL = "mk@gmail.com";
    @Value("${local.server.port}")
    int serverPort;

    @MockBean
    private CustomerFacade customerFacade;

    @Before
    public void setup() {
        RestAssured.port = serverPort;
        given(customerFacade.retrieveByEmail(EMAIL))
                .willReturn(new CustomerResponse(Lists.newArrayList(apples, plums)));
    }

    @Test
    public void findUserContainers() {
        //When
        CustomerResponse found =
            given()
                .pathParam("email", EMAIL)
            .when()
                .get(ROOT + "/customers/{email}")
            .as(CustomerResponse.class);
        //Then
        assertThat(found.getContainers()).hasSize(2)
                .extracting(Container::getName).contains("apples", "plums");

    }


}