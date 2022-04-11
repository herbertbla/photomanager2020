package at.hb.flyway.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;

/**
 * @author blascheh
 */
public class PmFlywayMigrationStrategy implements FlywayMigrationStrategy {
    @Override
    public void migrate(Flyway flyway) {
        System.out.println("hi");
    }
}
