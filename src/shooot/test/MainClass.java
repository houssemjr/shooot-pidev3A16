/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.test;

import java.util.Iterator;
import java.util.List;
import shooot.entities.Admin;
import shooot.entities.User;
import shooot.services.AdminCRUD;
import shooot.services.UserCRUD;

/**
 *
 * @author HP PC
 */
public class MainClass {
    public static void main(String[] args){
       //MyConnection c =new MyConnection();
        UserCRUD u=new UserCRUD();
       //u.ajouterUser();

       User u1 = new User("abderazek", "chebi",98547654,"fahmi@gmail.com","f123","ff456");
       //u.ajouterUser2(u1);
       //u.supprimerUser("yh123");
       //u.updateUser("f123", "fahmi","riahi",89756,"fahmi10@gmail.com","123");
       
       List<User> listUsers = u.affichageUsers();
       
        for (User user : listUsers) {
            System.out.println(user);
        } 
        AdminCRUD a=new AdminCRUD();  
        Admin a1=new Admin("seif","ben karim","seif@gmail.com","seif123");
        //a.ajouterAdmin(a1);
       
        List <Admin> listAdmins=a.affichageAdmin();
        for (Admin a2 : listAdmins){
            System.out.println(a2);
        }
        
        
        
        //*******************cryptage************************
        //Encrypte E;
        //E = new Encrypte();
        //String crypt;
        //crypt=E.EcryptePwd("yassine0726");
        //System.out.println(crypt);
        
        //*******************connection***********************
        //MyConnection m1 = MyConnection.getInstance();
        //MyConnection m2 = MyConnection.getInstance();
        //System.out.println(m1.hashCode() + "  ----  "+m2.hashCode());
    }
}
