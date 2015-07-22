package com.jonwelzel.webdevtest.server.services;

/**
 * Created by jwelzel on 22/07/15.
 */
public class EmailServiceImpl implements EmailServiceInterface {

    private Runnable sendEmailTask = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000L);
                System.out.println("Thread executou");
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
