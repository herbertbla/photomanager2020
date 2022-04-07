package at.hb.photomanager.config;

import at.hb.photomanager.api.impl.HBPhotoshopAPIMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * === PbzJpaConfig
 *
 * Basiskonfiguration für JPA und Entities.
 */
@Configuration
@ComponentScan(basePackageClasses = {HBPhotoshopAPIMarker.class})
/*
@EntityScan(basePackageClasses = {
        HBPhotomanagerEntityPackageMarker.class
})
@EnableJpaRepositories(basePackageClasses = {
        HBPhotoshopRepositoryMarker.class
}, enableDefaultTransactions = false)*/
public class HBPhotoManagerConfig {
}
