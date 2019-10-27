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
public class Message implements Serializable{
    private int IDMessage;
    private String textMessage;
    private String URLImage; //donde está ubicada la imagen
    public Message nextMessage; //está null
    public UserMessage nextFriendList;
    public User UserMens; //quíen creó el mensjae
    public String UserAdmin; //indica que el administrador creó 

    public Message(int IDMessage, String textMessage, String URLImage) {
        this.IDMessage = IDMessage;
        this.textMessage = textMessage;
        this.URLImage = URLImage;
    }

    public int getIDMessage() {
        return IDMessage;
    }

    public void setIDMessage(int IDMessage) {
        this.IDMessage = IDMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getURLImage() {
        return URLImage;
    }

    public void setURLImage(String URLdeImagen) {
        this.URLImage = URLdeImagen;
    }

}
