package at.hb.photomanager;


import at.hb.flyway.config.PmFlywayConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Mainclass to start the full Server
 *
 * @author blaschek
 */
@Configuration
@Import({
        PmFlywayConfig.class,

})
@ComponentScan(basePackages = "at")
@SpringBootApplication
public class PhotomanagerServer extends SpringBootServletInitializer implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
