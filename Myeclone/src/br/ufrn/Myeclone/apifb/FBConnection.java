package br.ufrn.Myeclone.apifb;


import java.util.ArrayList;
import java.util.List;

import com.restfb.*;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.*;
import com.restfb.types.Post.Comments;
import java.util.HashMap;
import java.util.Iterator;


public class FBConnection {
	FacebookClient fb;
	
	public FBConnection(String at){
		fb = new DefaultFacebookClient(at, "e0a0e740a7b895596c1c7beb4aa33dfd");	
	}   
	//APP ID = 131420027006200
	//APP SECRET = e0a0e740a7b895596c1c7beb4aa33dfd
	public FBConnection(String appId, String appSecret, String token) {
		fb = new DefaultFacebookClient();
        AccessToken accessToken = fb.obtainAppAccessToken(appId, appSecret);
        String at = accessToken.getAccessToken();
        //String at = fb.obtainExtendedAccessToken(appId, appSecret, "CAAB3hpwGrPgBAPiKnJQMqi8aQB1ZBsuHd453deFeHZAIjjA3PzqZCtdPk1C8F8QJ6MTkkcKLlBZC3Rm2BZBFR3KCm8h7h6qbQRDRznPSigBPGN3loS4KGTUrxenAE5ey0B9nUeMbPxZCASiw84gceUBcKVXJGYLL4nUd6ufL4hsLO7vRbaVGJqjaf1IexcPjHHRTepSHmnYAZDZD").getAccessToken();
        //String at = accessToken.getAccessToken();
        
        System.out.println(at);
        fb = new DefaultFacebookClient(at, appSecret);	
    }
        
        public void enviarMensagem(String msg){
            FacebookType publishMessageResponse =
            fb.publish("me/feed", FacebookType.class,
            Parameter.with("message", msg));
            System.out.println("Published message ID: " + publishMessageResponse.getId());
        }
        
	public Usuario getUserByName(String nome) throws TokenException{
            try{
		User user = fb.fetchObject(nome, User.class);
                Page page = fb.fetchObject("cocacola", Page.class);
                System.out.println(page.getDescription());
                Connection<Post> myFeed = fb.fetchConnection(nome+"/feed", Post.class);        
                Usuario usuario = new Usuario(user.getId(), user.getName(), user.getAbout(), user.getBirthday(), user.getEmail(), user.getGender(), user.getLocale());
                return usuario;
            }catch(Exception e){
                throw new TokenException();
            }
	}
            
        
                //obter a lista de usuarios com permissao
        public List<Usuario> getFriendsLista(String nome) throws TokenException{
                List<Usuario> amigos = new ArrayList<Usuario>();
                try{
                    Connection<User> myFriends = fb.fetchConnection(nome + "/friends", User.class);
                    System.out.println("Count of my friends: " + myFriends.getData().size());

                    Iterator<User> friends = myFriends.getData().iterator();
                    
                    while(friends.hasNext())
                    {
                        User next = friends.next();
                        amigos.add(new Usuario(next.getId(), next.getName()));
                    }
                }
                catch(Exception e){
                    throw new TokenException();
                }
		return amigos;
        }
        
    	//APP ID = 131420027006200
    	//APP SECRET = e0a0e740a7b895596c1c7beb4aa33dfd
        
        //TOKEN EXTENDIDO: CAAB3hpwGrPgBAGxmMHSZC5Myi4aozmhui7kT0f0v7e9w3PSpTFgLJlDIreM3VxJjubH4hsUh8WrRD8J9js1FnqmjBRE58tRoZABbzLhkKce6pbPWKrP7ZAAO2XUnYPDkQjq1aE7XLO7Go4uayilkHDQlZBoWZBDlZCnhC9jZCHCTdrlcycLeh4J3bJYl0fP9ZCUZD
        //https://developers.facebook.com/tools/debug/accesstoken/ (Pega token normal)
        public static void main(String[] args){
        	
        	FBConnection fb = new FBConnection("131420027006200 ", "e0a0e740a7b895596c1c7beb4aa33dfd", "CAAB3hpwGrPgBAGizTJ2kprSZANkdIfnRZAZBzUz0CHXnDHqaegkAO5TEGpkS8OBOZAwLGlMoSBB0TTrABm6k143PNk3FOO7Dh3AJ0CSKlZBio9rf29HrHqfv55JBGtHEZADoQmv1qCN2qbZAulzezOQhAnOpaCisQ7l3VMou6CJ8XkEZA0Ftik0bBCpEE0RKahCF4pE7p7oBMAZDZD");
        	fb.enviarMensagem("Testando restfb");
       
        }
        
        
}