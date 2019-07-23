package my.projects.graphqlapi.datafetcher;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import my.projects.graphqlapi.pojo.Link;
import my.projects.graphqlapi.repository.LinkRepository;

@Component
public class GraphqlDataFetchers {

    private LinkRepository linkRepository = new LinkRepository(); 
    
    public DataFetcher<List<Link>> getAllLinksDataFetcher() {
        return dataFetchingEnvironment -> linkRepository.getAllLinks();
    }
    
}
