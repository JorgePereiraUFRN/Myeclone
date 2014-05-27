package br.ufrn.Myeclone.feeds;

public class ReadTest {
	
	  public static void main(String[] args) {
		  
	    RSSFeedParser parser = new RSSFeedParser("http://globoesporte.globo.com/servico/semantica/editorias/plantao/futebol/brasileirao-serie-a/feed.rss");
	    Feed feed = parser.readFeed();
	    System.out.println(feed);
	    for (FeedMessage message : feed.getMessages()) {
	      System.out.println(message);

	    }

	  }
}
