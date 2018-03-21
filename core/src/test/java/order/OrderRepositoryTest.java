package nl.ing.java.guild.core.domain.order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        ClientEntity client = new ClientEntity("Tijmen", null);
        OrderEntity order = new OrderEntity(client, "newOrder", 1000.50);
        orderId = orderRepository.save(order).getId();

    }

    @Test
    public void shouldFindById() {
        Optional<OrderEntity> found = orderRepository.findById(orderId);

        assertThat(found).isPresent();
    }
}