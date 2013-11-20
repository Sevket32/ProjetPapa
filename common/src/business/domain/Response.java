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
public class Response implements Serializable {
    
    private Document Document;
    private boolean Valid;
    private String Pdf;
    private Terorist Terorist;

    public Response(Document Document, boolean Valid, String Pdf, Terorist Terorist) {
        this.Document = Document;
        this.Valid = Valid;
        this.Pdf = Pdf;
        this.Terorist = Terorist;
    }

    public Response() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public Document getDocument() {
        return Document;
    }

    public void setDocument(Document Document) {
        this.Document = Document;
    }

    public boolean getValid() {
        return Valid;
    }

    public void setValid(boolean Valid) {
        this.Valid = Valid;
    }

    public String getPdf() {
        return Pdf;
    }

    public void setPdf(String Pdf) {
        this.Pdf = Pdf;
    }

    public Terorist getTerorist() {
        return Terorist;
    }

    public void setTerorist(Terorist Terorist) {
        this.Terorist = Terorist;
    }
    
    
}
