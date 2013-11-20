/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.domain;

import java.io.Serializable;

/**
 *
 * @author Johann
 */
public class Document implements Serializable {

    private int Id;
    private String Name;
    private String Key;
    private String Content;

    public Document(int Id, String Name, String Key, String Content) {
        this.Id = Id;
        this.Name = Name;
        this.Key = Key;
        this.Content = Content;
    }
    
    

    public String getKey() {
        return Key;
    }

    public void setKey(String Key) {
        this.Key = Key;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
}
