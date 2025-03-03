
package com.ivgenyT.WhatsAppTaskBot.Bot;

import com.ivgenyT.WhatsAppTaskBot.Const;
import com.ivgenyT.WhatsAppTaskBot.MessageSender.MessageSender;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


public class WhatsAppBot {

    private static final String ACCOUNT_SID = "AC88c50ec11c0a5f00178c3eecc4b3b179";
    private static final String AUTH_TOKEN = "ba79329a0ea5f4bd92ff32f5252f8da9";
    private String _authToken;
    private String _accountSid;
    //private static MessageSender _messageSender;

    public WhatsAppBot(){
        _authToken = Const.AUTH_TOKEN;
        _accountSid = Const.ACCOUNT_SID;
    }

    public Message getReceivedMessage


    public static void start() {
        // init twilio service
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);


        //init message sender
        _messageSender = new MessageSender();
    }



    /*public static void sendMessage(String number, String message) {
        _messageSender.sendMessage(number, message);
    }*/

    public static void stop(){
        Twilio.destroy();
    }
}
