/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author Sebas
 */
public class UserMessage implements Serializable{
    public UserMessage next;
    public FriendList nextFriendList;
    public User nextUser;
    
}
