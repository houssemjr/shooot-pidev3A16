/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.entities;

/**
 *
 * @author HP PC
 */
public class Encrypte {
    
    private int key=12;
    
    public Encrypte(){
        
    }
    public String EcryptePwd(String pwd){
        char[] chars=pwd.toCharArray();
        String cryptedPwd ="";
        
        for(char c:chars){
            c+=key ;
            cryptedPwd += c;
        }
        
        return cryptedPwd;  
    }
    
    
    
}
