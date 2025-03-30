
package com.ivgenyT.WhatsAppTaskBot.MessageSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class MessageSender implements Runnable {
    // Find your Account Sid and Token at twilio.com/console

    private  final String Bot_Number = "whatsapp:+14155238886";
    private  final PhoneNumber Bot_num = new PhoneNumber(Bot_Number);
    private String _message;
    private PhoneNumber _receiver;



    //constructor
    public MessageSender() {
        _message = "";
        _receiver = null;
    }

    public void run() {

    }

    //@input number to send, message to send
    public void sendMessage(String number, String message) {
        createPhoneNumber(number);
        //creating twillio message body
        Message send_message = Message.creator(_receiver, Bot_num, message).create();
        //printSID(send_message);
    }

    //@input String phone number
    //creating phone number obj
    private void createPhoneNumber(String number) {
        _receiver = new PhoneNumber(number);
    }

    private void printSID(Message message) {
        System.out.println(message.getSid());
    }

    





 
}