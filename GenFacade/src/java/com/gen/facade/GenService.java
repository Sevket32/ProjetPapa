/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.facade;

import business.domain.Document;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;

/**
 *
 * @author Johann
 */
@WebService(serviceName = "GenService", name="Gen")
@Stateless
public class GenService {
    
    @Resource(mappedName="jms/queueCF")
    private QueueConnectionFactory factory;
    @Resource(mappedName="jms/paymentQueue")
    private Queue queue;
    private Connection cnx;
    
    @PostConstruct
    protected void init(){
        try {
            //connexion au provider JMS établie
            cnx = factory.createConnection();//connexion au JMS provider établie
        } catch (JMSException ex) {
            Logger.getLogger(GenService.class.getName()).log(Level.SEVERE, null, ex);
            throw new EJBException();
        }
    }
    
    @PreDestroy
    protected void clear(){
        try {
            cnx.close(); //il faut fermer la connexion
        } catch (JMSException ex) {
            Logger.getLogger(GenService.class.getName()).log(Level.SEVERE, null, ex);
            throw new EJBException();
        }
    }

    @WebMethod(operationName = "verifDocument")
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public boolean verifDocument(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "key") String key, @WebParam(name = "content") String content) {
        sendDocument(id, name, key, content);
        return true;
    }

    private void sendDocument(int id, String name, String key, String content) {
        try {
            Session session = cnx.createSession(true, 0);
            MessageProducer producer = session.createProducer(queue);
            
            Document document = new Document(id, name, key, content);
            ObjectMessage obj = session.createObjectMessage(document);
            producer.send(obj); //préparation de l’envoi du message
        } catch (JMSException ex) {
            Logger.getLogger(GenService.class.getName()).log(Level.SEVERE, null, ex);
            throw new EJBException();
        }
    }
    
    
}
