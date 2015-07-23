package com.jonwelzel.webdevtest.server.concurrent;

import com.jonwelzel.webdevtest.server.models.EmailInterface;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jwelzel on 23/07/15.
 */
public class EmailThread implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(EmailThread.class.getName());
    private final EmailInterface email;

    public EmailThread(EmailInterface email) {
        this.email = email;
    }

    @Override
    public void run() {
        try {
            Email simpleEmail = new SimpleEmail();
            simpleEmail.setSmtpPort(587);
            simpleEmail.setHostName("smtp.gmail.com");
            simpleEmail.setAuthentication("jnwelzel@gmail.com", "");
            simpleEmail.setStartTLSEnabled(true);
            simpleEmail.setFrom("jnwelzel@gmail.com", "Meus Pedidos - Cadastro de Perfil");
            simpleEmail.setSubject(email.getSubject());
            simpleEmail.setMsg(email.getMessage());
            simpleEmail.addTo(email.getTo());
            simpleEmail.send();
            log.info("E-mail enviado com sucesso para \"" + email.getTo() + "\"");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
