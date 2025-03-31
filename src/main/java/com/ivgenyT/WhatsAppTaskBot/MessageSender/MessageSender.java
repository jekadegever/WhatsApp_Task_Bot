
package com.ivgenyT.WhatsAppTaskBot.MessageSender;
import com.ivgenyT.WhatsAppTaskBot.Bot.MessageQueues;
import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class MessageSender implements Runnable {
    // Find your Account Sid and Token at twilio.com/console


    private PhoneNumber _Bot_num;
    private PhoneNumber _receiver;
    private String _message;




    //constructor
    public MessageSender() {
        _message = "";
        _Bot_num = new PhoneNumber(Contacts.BOT.getNumber());
        _receiver = new PhoneNumber(Contacts.IVGENY.getNumber());

    }

    public void run() {
        while (true) {
            /*try {
                Thread.sleep(100); // השהייה של 500 מילישניות (חצי שניה)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            MessageForm messageToSend = MessageQueues.PopSendMessageQueue();
            System.out.println(messageToSend == null ? "null" : "not null");
            if (messageToSend != null) {
                System.out.println("messeage sender "+messageToSend.getBody()+"popped from queue");
                sendMessage(messageToSend.getBody());
                //sendMessage("hello");

            }
        }

    }

    //@input number to send, message to send
    public void sendMessage( String message) {
        //creating twillio message body
        Message send_message = Message.creator(_receiver, _Bot_num, message).create();

        //printSID(send_message);
    }

    //@input String phone number
    //creating phone number obj
   /* private void createPhoneNumber(String number) {
        _receiver = new PhoneNumber(number);
    }*/

   /* private void printSID(Message message) {
        System.out.println(message.getSid());
    }*/

    





 
}