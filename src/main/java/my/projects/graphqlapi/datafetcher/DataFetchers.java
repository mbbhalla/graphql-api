package my.projects.graphqlapi.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import my.projects.graphqlapi.pojo.Link;
import my.projects.graphqlapi.repository.LinkRepository;

@Component
public class DataFetchers {

    @Autowired
    private LinkRepository linkRepository; 
    
    public DataFetcher<List<Link>> getAllLinksDataFetcher() {
        return dataFetchingEnvironment -> this.linkRepository.getLinks();
    }
    
    public DataFetcher<Link> createLinkDataFetcher() {
        return dataFetchingEnvironment -> {
          
           String url = dataFetchingEnvironment.getArgument("url");
           String description = dataFetchingEnvironment.getArgument("description");

           Link link = new Link(url, description);
           this.linkRepository.saveLink(link);
           return link;
        };
    }
}
