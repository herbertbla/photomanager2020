package at.gv.brz.justiz3.sv.photomanager.pbz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author rettenbl
 */
@Configuration
@PropertySource("classpath:/config/pbz-${justiz3.stage}.properties")
public class PbzApiConfig {
}
