package itacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"itacademy"}, exclude = HibernateJpaAutoConfiguration.class)
public class WebApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "8080");
        SpringApplication.run(WebApplication.class);
    }

}
