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
        
        public static void main(String[] args){
        	FBConnection fb = new FBConnection("CAAB3hpwGrPgBALBbTqMi7i6WXiZAZBGLiUf1QE2qlz9aQVcyRJAShtqq3OvqYWEBByqJ8vbxIHFyOplsHlgNvjquEJ6Q5IQRd3MSwWuIYwccko6G4OMg1NTDkJ5XGuQZB0X34z2PNtL6DPoaAb5DzvhpUds8FEvg0QZAxKvZCfgEKJKuEvZBJLOHDjTpZBr6tXM8avXGEEONwZDZD");
        	
        	fb.enviarMensagem("Testando restfb");
       
        }
        
        
}