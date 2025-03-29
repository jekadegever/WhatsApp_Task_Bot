package com.ivgenyT.WhatsAppTaskBot.MessageReceiver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageReader;
import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import com.ivgenyT.WhatsAppTaskBot.Bot.*;




public class MessageReceiver {

    private final String JSON_FILE = "Tasks.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //creating messageReader obj
    private  MessageReader reader;
    private ResourceSet<Message> twillioMessageList = null;
     //private List<MessageForm> receivedMessageQueue = new ArrayList<MessageForm>();
    private String reciveTime = "";


//constructor
    public MessageReceiver() {
        //Create twillio message reader obj
        reader = Message.reader();
        //get the last message to update recived time
        getNewMessages();
        //delete the last message from queue - received time updated
        MessageQueues.PopReceivedMessageQueue();

    }




    //polling twillio message list, if new message received, the message will be inserted to queue
    public void getNewMessages() {
        //get all messages from twilio server list of "Messages"
        twillioMessageList = reader.read();
       //running till find the last received whatsapp message
        for(Message twilioMessage : twillioMessageList) {
           if(twilioMessage.getFrom().toString().startsWith("whatsapp")) {
               //check if it's a new message
               if(!(twilioMessage.getDateUpdated().toString().equals(reciveTime))) {
                   reciveTime = twilioMessage.getDateUpdated().toString();
                   //create new message obj with new received message
                   MessageForm newMessage = new MessageForm(twilioMessage.getBody().toString());
                   //add received message to queue
                   MessageQueues.addToReceivedMessageQueue(newMessage);
                  // writeMessages(messageDataList);
                  // System.out.println(message.getBody().toString());
                   break;
               }
               break;
           }
       }

    }

}