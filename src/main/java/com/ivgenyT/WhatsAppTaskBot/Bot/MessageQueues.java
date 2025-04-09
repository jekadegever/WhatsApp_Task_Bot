package com.ivgenyT.WhatsAppTaskBot.Bot;

import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueues {
    public static final Logger log = LoggerFactory.getLogger(MessageQueues.class);

//private static  LinkedList<MessageForm> receivedMessageQueue = new LinkedList<>();
    //private static  LinkedList<MessageForm> sendMessageQueue = new LinkedList<>();
private static BlockingQueue<MessageForm> recievedMessageQueue = new LinkedBlockingQueue<>();
private static BlockingQueue<MessageForm> sendMessageQueue = new LinkedBlockingQueue<>();



//no constructor - all methods are statics
//static methods

  public static void addToReceivedMessageQueue(MessageForm receivedMessage) throws Exception {

      recievedMessageQueue.put(receivedMessage);

  }

      public static void addToSendMessageQueue(MessageForm messageToSend) throws Exception {

      sendMessageQueue.put(messageToSend);

  }


  public static MessageForm PopReceivedMessageQueue() throws Exception {

      return recievedMessageQueue.take();
  }

  public static MessageForm PopSendMessageQueue() throws Exception {

      return sendMessageQueue.take();

  }

}
