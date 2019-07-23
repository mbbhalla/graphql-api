package my.projects.graphqlapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import my.projects.graphqlapi.pojo.Link;

@Repository
@Getter
public class LinkRepository {
    
    private final List<Link> links;

    public LinkRepository() {
        links = new ArrayList<>();
        
        //add some links to start off with
        links.add(new Link("http://howtographql.com", "Your favorite GraphQL page"));
        links.add(new Link("http://graphql.org/learn/", "The official docs"));
        links.add(new Link("http://a.org/learn/", "A Org"));
    }
   
    public void saveLink(Link link) {
        links.add(link);
    }
}