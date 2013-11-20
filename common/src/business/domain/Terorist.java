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
class Terorist implements Serializable {
    
    private String Mail;
    private String Nom;

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    
    
}
