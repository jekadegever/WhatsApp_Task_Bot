
package com.ivgenyT.WhatsAppTaskBot.Bot;

import com.ivgenyT.WhatsAppTaskBot.Const;
import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import com.ivgenyT.WhatsAppTaskBot.MessageReceiver.MessageReceiverServlet;
import com.twilio.Twilio;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WhatsAppBot implements Runnable {
Logger logger = LoggerFactory.getLogger(WhatsAppBot.class);

    private String _authToken;
    private String _accountSid;
    //private static MessageSender _messageSender;


    //constructor
    public WhatsAppBot(){
        _authToken = Const.AUTH_TOKEN;
        _accountSid = Const.ACCOUNT_SID;
        logger.debug("Created WhatsAppBot");
    }

    public void run(){

        while (true){
            printMessage();
            try {
                Thread.sleep(100); // השהייה של 500 מילישניות (חצי שניה)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printMessage(){
        MessageForm message = MessageQueues.PopReceivedMessageQueue();
        if(message != null){
            logger.debug("popped from received queue");
            System.out.println(message);
            MessageQueues.addToSendMessageQueue(message);
            logger.debug("pushed to send queue");


        }



    }


    public void Init() {
        // init twilio service
        Twilio.init(_accountSid, _authToken);

        Server server = new Server(8080); // מאזין על פורט 8080

        ServletContextHandler servletManager = new ServletContextHandler(ServletContextHandler.SESSIONS);

        servletManager.setContextPath("/");

        server.setHandler(servletManager);

        MessageReceiverServlet messageReceiverServlet = new MessageReceiverServlet();

        ServletHolder servletHolder = new ServletHolder(messageReceiverServlet);

        servletManager.addServlet(servletHolder, "/message-receiver");

        s



        messageR




        //init message sender
        //_messageSender = new MessageSender();
    }



    /*public static void sendMessage(String number, String message) {
        _messageSender.sendMessage(number, message);
    }*/

    public void stop(){
        Twilio.destroy();
    }
}
