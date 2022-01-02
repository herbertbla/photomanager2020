package at.hb.photomanager;

import at.hb.photomanager.config.HBPhotoManagerConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Mainclass to start the full Server
 *
 * @author blaschek
 */
@Configuration
@EnableAutoConfiguration
@Import({HBPhotoManagerConfig.class})
public class HBPhotomanagerServer extends SpringBootServletInitializer implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
