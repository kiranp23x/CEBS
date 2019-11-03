package Model;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class Email {
    private String sendingEmail;
    public Email(String sendingEmail)
    {
        this.sendingEmail = sendingEmail;
    }
    public void setSendingEmail(String sendingEm){
        sendingEmail = sendingEm;
    }
    public void sendVerificationEmail() {
        String username = "cinemaebooking2b";
        String password = "HelloWorld1!";
        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        System.out.println("Setup server");
        Session session = Session.getInstance(p, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }//PassAuth
        });//mailAuth
        System.out.println("Creating email session");

        try
        {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("cinemaebooking2b@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("kiranp7096@gmail.com")
            );
            msg.setSubject("INSERT_THEATRE_NAME: Verification Code for your new account!");
            msg.setText("Enter this verification code: A1B");

            System.out.println("sending Email");

            Transport.send(msg);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

    }//sendVerificationEmail
    public void sendForgetpassEmail() {
        String username = "cinemaebooking2b";
        String password = "HelloWorld1!";
        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        System.out.println("Setup server");
        Session session = Session.getInstance(p, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }//PassAuth
        });//mailAuth
        System.out.println("Creating email session");

        try
        {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("cinemaebooking2b@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("kiranp7096@gmail.com")
            );
            msg.setSubject("NSERT_THEATRE_NAME: Forget password");
            msg.setText("forgot password url");

            System.out.println("sending Email");

            Transport.send(msg);
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }

    }//sendForgetpassEmail
}//class
