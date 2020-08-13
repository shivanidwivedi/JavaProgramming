package leetcode;

import java.util.*;

/**
 * @author shivanidwivedi on 13/08/20
 * @project JavaProgramming
 * Given a url startUrl and an interface HtmlParser, implement a web crawler to crawl all links that are under the same hostname as startUrl.
 *
 * Return all urls obtained by your web crawler in any order.
 *
 * Your crawler should:
 * Start from the page: startUrl
 * Call HtmlParser.getUrls(url) to get all urls from a webpage of given url.
 * Do not crawl the same link twice.
 * Explore only the links that are under the same hostname as startUrl.
 * Example 1:
 *
 * Input:
 * urls = [
 *   "http://news.yahoo.com",
 *   "http://news.yahoo.com/news",
 *   "http://news.yahoo.com/news/topics/",
 *   "http://news.google.com",
 *   "http://news.yahoo.com/us"
 * ]
 * edges = [[2,0],[2,1],[3,2],[3,1],[0,4]]
 * startUrl = "http://news.yahoo.com/news/topics/"
 * Output: [
 *   "http://news.yahoo.com",
 *   "http://news.yahoo.com/news",
 *   "http://news.yahoo.com/news/topics/",
 *   "http://news.yahoo.com/us"
 * ]
 */

interface HtmlParser {
      public List<String> getUrls(String url);
  }
public class WebCrawler implements HtmlParser {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        if(startUrl == null || startUrl.length() == 0) return null;

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        String hostname = getHostByName(startUrl);

        visited.add(startUrl);
        q.add(startUrl);

        while(!q.isEmpty()){
            String current = q.remove();
            for(String url : htmlParser.getUrls(current)){
                if(hostname.equals(getHostByName(url)) && !visited.contains(url)){
                    visited.add(url);
                    q.add(url);
                }
            }
        }
        return new ArrayList<String>(visited);
    }

    private String  getHostByName( String url)
    {
        String [] parts= url.split("/");
        return (parts[2]);
    }

    @Override
    public List<String> getUrls(String url) {
        // return list of adjacent urls
        return new LinkedList<>();
    }
}
