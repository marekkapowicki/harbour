package nl.ing.java.guild.core.domain.order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest(showSql = true)
@RunWith(SpringRunner.class)
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    private long orderId;

    @Before
    public void setUp() {
        ContainerEntity order = new ContainerEntity(Clients.MAREK, null, new StatusEntity(), BigDecimal.ONE, "Utrecht", "10", "description");
        orderId = orderRepository.save(order).getId();

    }

    @Test
    public void shouldFindById() {
        Optional<ContainerEntity> found = orderRepository.findById(orderId);

        assertThat(found).isPresent();
    }
}