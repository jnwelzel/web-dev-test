package com.jonwelzel.webdevtest.server.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jwelzel on 22/07/15.
 */
public class EmailServiceImpl implements EmailServiceInterface {

    private static final Logger log = LoggerFactory.getLogger("EmailServiceImpl");

    private Runnable sendEmailTask = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000L);
                log.info("E-mail enviado com sucesso");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void sendEmail(String from, String to, String title, String message) {
        new Thread(sendEmailTask).start();
    }

}
