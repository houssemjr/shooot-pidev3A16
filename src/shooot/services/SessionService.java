/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shooot.services;

import shooot.entities.Admin;
import shooot.entities.User;

/**
 *
 * @author HP PC
 */
class SessionService {
    
    
    static User user=null ;
    
    static Admin admin=null;
    
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
