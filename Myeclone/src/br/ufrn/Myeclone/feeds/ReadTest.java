package br.ufrn.Myeclone.feeds;

import br.ufrn.Myeclone.DAO.FeedDao;
import br.ufrn.Myeclone.Exceptions.DAOException;
import br.ufrn.Myeclone.Exceptions.ServiceException;
import br.ufrn.Myeclone.controler.Service.FeedService;
import br.ufrn.Myeclone.model.FeedMessage;
import br.ufrn.Myeclone.model.Feed;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadTest {
	
	  public static void main(String[] args) {
		  
	    RSSFeedParser parser = new RSSFeedParser("http://globoesporte.globo.com/servico/semantica/editorias/plantao/futebol/brasileirao-serie-a/feed.rss");
	    Feed feed = parser.readFeed();
	    System.out.println(feed);
	    
            
              try {
                  new FeedService().create(feed);
                  new FeedService().create(feed);
              } catch (ServiceException ex) {
                  Logger.getLogger(ReadTest.class.getName()).log(Level.SEVERE, null, ex);
              }

	  }
}
