package at.hb.flyway.config;

import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author blascheh
 */
@Configuration
@Import({
        FlywayAutoConfiguration.class
})
public class PmFlywayConfig {

    @Bean
    FlywayMigrationStrategy getPmFlywayMigrationStrategy() {
        return new PmFlywayMigrationStrategy();
    }

}
