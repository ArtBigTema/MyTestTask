package my.av.test.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@EnableJpaAuditing
@SpringBootApplication(exclude = {
        LiquibaseAutoConfiguration.class
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setAfterMessagePrefix("REQUEST DATA : ");
        return loggingFilter;
    }
}
