package my.projects.graphqlapi.provider;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeRuntimeWiring;
import lombok.val;
import my.projects.graphqlapi.datafetcher.GraphqlDataFetchers;

@Component 
public class GraphqlProvider {
    
    private GraphQL graphQL;
    
    @Autowired
    GraphqlDataFetchers graphQlDataFetchers;
    
    
    @PostConstruct
    public void init() throws IOException {
        val url = Resources.getResource("graphql/schema.graphqls");
        val sdl = Resources.toString(url, Charsets.UTF_8);
        val graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }
    
    private GraphQLSchema buildSchema(final String sdl) {
        
        val typeDefinitionRegistry = new SchemaParser().parse(sdl);
        val runtimeWiring = buildWiring();
        val schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }
    
    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
            .type(TypeRuntimeWiring.newTypeWiring("Query")
                    .dataFetcher("allLinks", graphQlDataFetchers.getAllLinksDataFetcher()))
            .build();
    }

    @Bean
    public GraphQL graphQL() {
        return this.graphQL;
    }

}
