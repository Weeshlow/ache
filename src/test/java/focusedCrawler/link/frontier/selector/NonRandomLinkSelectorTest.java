package focusedCrawler.link.frontier.selector;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import focusedCrawler.link.frontier.LinkRelevance;

public class NonRandomLinkSelectorTest {

    @Test
    public void shouldSelectLinks() throws Exception {
        // given
        NonRandomLinkSelector selector = new NonRandomLinkSelector();
        List<LinkRelevance> frontier = asList(
            new LinkRelevance("http://localhost/299/1", 299),
            new LinkRelevance("http://localhost/299/2", 299),
            new LinkRelevance("http://localhost/199", 199),
            new LinkRelevance("http://localhost/099", 99),
            new LinkRelevance("http://localhost/001", 1)
        );
        int numberOfLinks = 2;
        
        // when
        selector.startSelection(numberOfLinks);
        for(LinkRelevance link : frontier) {
            selector.evaluateLink(link); 
        }
        List<LinkRelevance> links = selector.getSelectedLinks();
        
        // then
        assertThat(links, is(notNullValue()));
        assertThat(links.size(), is(2));
        assertThat(links.get(0).getRelevance(), is(299d));
        assertThat(links.get(0).getRelevance(), is(299d));
    }
    
}
