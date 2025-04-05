package com.ivgenyT.WhatsAppTaskBot.Bot;

import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueues {
    //public static final Logger LOGGER = LoggerFactory.getLogger(MessageQueues.class);

private static  LinkedList<MessageForm> receivedMessageQueue = new LinkedList<>();
private static  LinkedList<MessageForm> sendMessageQueue = new LinkedList<>();
private static BlockingQueue<MessageForm> messageQueueRec = new LinkedBlockingQueue<>();
private static BlockingQueue<MessageForm> messageQueueSend = new LinkedBlockingQueue<>();



//no constructor - all methods are statics
//static methods

  public static void addToReceivedMessageQueue(MessageForm messageForm) {

      receivedMessageQueue.add(messageForm);
      //messageQueueRec.add(messageForm);
  }

  public static void addToSendMessageQueue(MessageForm messageForm) {
    sendMessageQueue.add(messageForm);
  }

  @org.jetbrains.annotations.Nullable
  public static MessageForm PopReceivedMessageQueue() {
      if (!receivedMessageQueue.isEmpty()) {
          MessageForm lastMessage = receivedMessageQueue.getLast();
          receivedMessageQueue.removeLast();
          //LOGGER.info("Message popped from received queue");
          return lastMessage;
      }
      //LOGGER.info("recived queue is empty");
      return null;

  }

  public static @Nullable MessageForm PopSendMessageQueue() {
      if (!sendMessageQueue.isEmpty()) {
          MessageForm lastMessage = sendMessageQueue.getLast();
          sendMessageQueue.removeLast();
          return lastMessage;

      }
      return null;
  }

}
