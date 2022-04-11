package at.hb.photomanager.main.repository;

import at.hb.photomanager.main.domain.PmConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author blaschek
 */
public interface PmConfigurationRepository extends JpaRepository<PmConfiguration, Long> {
}
