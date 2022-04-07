package at.gv.brz.justiz3.sv.svpersonenbeziehungen;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Mainclass to start the full Server
 *
 * @author blaschek
 */
@Configuration
@ComponentScan(basePackages = "at")
@SpringBootApplication
public class SvPersonenbeziehungenServer  extends SpringBootServletInitializer implements InitializingBean {


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
