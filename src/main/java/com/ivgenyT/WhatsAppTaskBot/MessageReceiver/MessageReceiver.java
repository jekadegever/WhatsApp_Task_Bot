package com.ivgenyT.WhatsAppTaskBot.MessageReceiver;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageReader;
import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import com.ivgenyT.WhatsAppTaskBot.Bot.*;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
        reader = Message.reader();
        getNewMessages();
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

        /*for (Message message : messages) {
            if (message.getFrom().toString().startsWith("whatsapp:")) {
                MessageData data = new MessageData(message.getFrom().toString(), message.getBody());
                messageDataList.add(data);
                System.out.println("date updated :"+message.getDateUpdated().toString());
                System.out.println("data sent :"+message.getDateSent().toString());
                System.out.println("status :"+message.getStatus().toString());
                break;
            }
        }
        writeMessages(messageDataList);*/
    }

    private  List<MessageData> loadMessages() {
       //open file and create reader object
        try (FileReader reader = new FileReader(JSON_FILE)) {
            //get and hold the type of messagedata list
            Type listType = new TypeToken<List<MessageData>>() {}.getType();
           //get data from json file and return as list in messageBody format
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private static void writeMessages(List<MessageData> messages) {
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            gson.toJson(messages, writer);
        } catch (IOException e) {
            System.out.println("Error writing file: " + JSON_FILE);
        }
    }

   static class MessageData {
        String _task;


        public MessageData(String task) {
            this._task = task;

        }
    }
}