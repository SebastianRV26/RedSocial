/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Sebas
 */
public class FriendList {
    public FriendList nextFriend, antFriend;
    public FriendListUser nextFriendListUser;
    public User nextUser; // Quién creó la lista
    private String nameList;
    private String description;

    public FriendList(String nameList, String description) {
        this.nameList = nameList;
        this.description = description;
    }

    public FriendList() {
    }

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
