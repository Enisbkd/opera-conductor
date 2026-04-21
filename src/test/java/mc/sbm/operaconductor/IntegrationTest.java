package mc.sbm.operaconductor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import mc.sbm.operaconductor.config.AsyncSyncConfiguration;
import mc.sbm.operaconductor.config.EmbeddedSQL;
import mc.sbm.operaconductor.config.JacksonConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(
    classes = {
        OperaConductorApp.class,
        JacksonConfiguration.class,
        AsyncSyncConfiguration.class,
        mc.sbm.operaconductor.config.JacksonHibernateConfiguration.class,
    }
)
@EmbeddedSQL
public @interface IntegrationTest {}
