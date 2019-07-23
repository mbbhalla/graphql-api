package my.projects.graphqlapi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
    "my.projects.graphqlapi.provider",
    "my.projects.graphqlapi.datafetcher"
})
public class GraphqlApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApiApplication.class, args);
	}

}
