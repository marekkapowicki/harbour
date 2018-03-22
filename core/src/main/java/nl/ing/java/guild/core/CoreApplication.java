package nl.ing.java.guild.core;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.ing.java.guild.core.client.PortImporter;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

    @Component
    @AllArgsConstructor
    @Slf4j
    @Profile("prod")
    static class SampleDataInitializer implements ApplicationRunner {

        private final PortImporter portImporter;

        @Override
        public void run(ApplicationArguments args) throws Exception {

            log.info("import data from port");
            portImporter.importData();
        }
    }
}
