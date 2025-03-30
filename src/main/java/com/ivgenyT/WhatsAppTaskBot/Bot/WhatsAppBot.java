
package com.ivgenyT.WhatsAppTaskBot.Bot;

import com.ivgenyT.WhatsAppTaskBot.Const;
import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import com.twilio.Twilio;


public class WhatsAppBot implements Runnable {

    private String _authToken;
    private String _accountSid;
    //private static MessageSender _messageSender;


    //constructor
    public WhatsAppBot(){
        _authToken = Const.AUTH_TOKEN;
        _accountSid = Const.ACCOUNT_SID;
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
            System.out.println("\n"+message.getBody());
        }



    }


    public void Init() {
        // init twilio service
        Twilio.init(_accountSid, _authToken);


        //init message sender
        //_messageSender = new MessageSender();
    }



    /*public static void sendMessage(String number, String message) {
        _messageSender.sendMessage(number, message);
    }*/

    public static void stop(){
        Twilio.destroy();
    }
}
