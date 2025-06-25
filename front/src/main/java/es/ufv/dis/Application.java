package es.ufv.dis;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@PWA(name = "Masterclass Vaadin", shortName = "Masterclass Vaadin",
        description = "Aplicación de ejemplo con Vaadin y Spring Boot")
public class Application implements AppShellConfigurator {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}