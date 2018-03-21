package nl.ing.java.guild.port.domain.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("nl.ing.java.guild.port.domain.person")
class PersonConfiguration {

    @Bean
    PersonFacade personFacade(PersonRepository personRepository) {
        return new PersonFacade(personRepository, new PersonFactory());
    }
}
