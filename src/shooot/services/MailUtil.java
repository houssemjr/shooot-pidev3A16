                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.services;

import java.net.Authenticator;
import java.util.Properties;
import javax.mail.Session;

/**
 *
 * @author HP PC
 */
public class MailUtil {
    
    public void sendMail(String rsp){
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        
        String myAccountEmail="xxxxx@gmail.com";
        String pwd="xxxxxxx";
        
        Session session= Session.getInstance(properties,new Authenticator(){
            @override
            protected passwordAuthentication getPasswordAuthentification(){
                return new PasswordAuthentication(myAccountEmail,password);
            }
        }
        );
        
        
    }
    
}
