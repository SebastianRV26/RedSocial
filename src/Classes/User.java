package Classes;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pache
 */
public class User implements Serializable {
    public String userName;
    public String password;
    public String city;
    public String country;
    public int identification; 
    public String name;
    public String surname;
    public String surname2;
    public String photography;
    public User sig,ant;
    public FriendListUser nextFriendList;
    public ReportClass  nextReportUser;

    public User(String userName, String password, String city, String country, int identification, String name, String surname, String surname2, String photography) {
        this.userName = userName;
        this.password = password;
        this.city = city;
        this.country = country;
        this.identification = identification;
        this.name = name;
        this.surname = surname;
        this.surname2 = surname2;
        this.photography = photography;
        
    }

    
    
}
