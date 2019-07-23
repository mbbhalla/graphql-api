package my.projects.graphqlapi.repository;

import java.util.ArrayList;
import java.util.List;

import my.projects.graphqlapi.pojo.Link;

public class LinkRepository {
    
    private final List<Link> links;

    public LinkRepository() {
        links = new ArrayList<>();
        
        //add some links to start off with
        links.add(new Link("http://howtographql.com", "Your favorite GraphQL page"));
        links.add(new Link("http://graphql.org/learn/", "The official docs"));
        links.add(new Link("http://a.org/learn/", "A Org"));
    }

    public List<Link> getAllLinks() {
        return links;
    }
    
    public void saveLink(Link link) {
        links.add(link);
    }
}