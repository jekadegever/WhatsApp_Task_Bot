package com.ivgenyT.WhatsAppTaskBot.MessageReceiver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ivgenyT.WhatsAppTaskBot.Const;
import com.ivgenyT.WhatsAppTaskBot.MessageSender.Contacts;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageReader;
import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import com.ivgenyT.WhatsAppTaskBot.Bot.*;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MessageReceiver implements Runnable{

    private final String JSON_FILE = "Tasks.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private  MessageReader reader;
    private ResourceSet<Message> twillioMessageList = null;
     //private List<MessageForm> receivedMessageQueue = new ArrayList<MessageForm>();
    private String lastRecivedMessageTime = "";
    //Logger logger = LoggerFactory.getLogger(MessageReceiver.class);



//constructor
    //@NoInput
    public MessageReceiver() {
        //Create twillio message reader obj
        reader = Message.reader();
        //logger.debug("message reader obj created");
        //get the last message to update recived time
        getNewMessages();
        //logger.debug("new messeage fetched for last recive time: " + lastRecivedMessageTime);
        //delete the last message from queue - received time updated
        MessageQueues.PopReceivedMessageQueue();
        //logger.info("MessageReceiver initialized");




    }

    public void run(){
        while(true) {
            getNewMessages();
        }
    }


    //polling twillio message list, if new message received, the message will be inserted to queue
    public void getNewMessages() {
        //init message varible
        Message message = null;
        //get all messages from twilio server list of "Messages"
        twillioMessageList = reader.read();
       //running till find the last received whatsapp message
        Iterator<Message> iterator = twillioMessageList.iterator();

        message = iterator.next();
        //check if its a new message by date/time compare
        if(message != null) {
            if (!(message.getDateUpdated().toString().equals(lastRecivedMessageTime))) {
                if (message.getFrom().toString().equals(Contacts.IVGENY.getNumber())) {
                    //update last message recieved time
                    lastRecivedMessageTime = message.getDateUpdated().toString();
                    //prepare the message in form for message queue
                    MessageForm formedMessage = new MessageForm(message.getBody(), message.getFrom().toString(), message.getDateSent().toString());
                    //add the messasge to queue
                    MessageQueues.addToReceivedMessageQueue(formedMessage);
                }
            }
        }




    }

}