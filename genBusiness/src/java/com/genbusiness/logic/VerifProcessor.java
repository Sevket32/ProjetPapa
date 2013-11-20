/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genbusiness.logic;

import business.domain.Document;
import business.domain.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Johann
 */
@MessageDriven(mappedName = "jms/VerifQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class VerifProcessor implements MessageListener {
    
    public VerifProcessor() {
    }
    
    @Override
    public void onMessage(Message message) {
        if(message instanceof ObjectMessage) {
            ObjectMessage objMsg = (ObjectMessage) message;
            try {
                Document document =(Document) objMsg.getObject();
                Response response = analyseDocument(document);
                if(response.getValid()) {
                    //Recupère mail
                    response.setTerorist(null);

                    //Génère PDF
                    if(response.getTerorist() != null) {
                        response.setPdf(null);
                    }

                    //Envoie réponse
                    //...
                }
            } catch (JMSException ex) {
                Logger.getLogger(VerifProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Response analyseDocument(Document document) {
        Response response = new Response();
        response.setDocument(document);
        
        //Traitement....

        return response;
    }
}