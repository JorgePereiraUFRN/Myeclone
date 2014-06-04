package br.ufrn.Myeclone.controler;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EnviarEmail {
	public static void main(String[] args) {
            // main para teste de funcionamento
		enviarEmail("login", "senha", "destinatário", "Assunto", "Corpo mensagem");
	}

    /**
     *
     * @param login
     * @param senha
     * @param destino
     * @param assunto
     * @param mensagem
     * @return
     */
    public static String enviarEmail(final String login, final String senha, String destino, String assunto, String mensagem)
        {
          
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.socketFactory.port", "465");
            p.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.port", "465");
 
            Session s = getSession(p, login, senha);
 
            try {
                    sendMessage(s, login, destino, assunto, mensagem);
 
                    System.out.println("Enviado");
                        
                    return "Mensagem enviada com sucesso para" + destino ;
 
		} 
            
            catch (MessagingException e)
                 {
                     throw new RuntimeException(e);                  
                 }
            
        }

    private static void sendMessage(Session s, final String login, String destino, String assunto, String mensagem) throws MessagingException {
        Message m = new MimeMessage(s);
        m.setFrom(new InternetAddress(login));
        m.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destino));
        m.setSubject(assunto);
        m.setText(mensagem);
        Transport.send(m);
    }

    private static Session getSession(Properties p, final String login, final String senha) {
        Session s = Session.getDefaultInstance(p,new javax.mail.Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(login,senha);
            }
        });
        return s;
    }
}
