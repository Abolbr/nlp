package cfg;

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ContextConfiguration

@Configuration
@ComponentScan(["cfg"])
class TestNlpConfig {
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
    @ContextConfiguration(classes = TestNlpConfig)
    static abstract class Specification extends spock.lang.Specification {
    }
}