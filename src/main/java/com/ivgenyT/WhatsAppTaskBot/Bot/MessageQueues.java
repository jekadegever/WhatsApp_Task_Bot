package com.ivgenyT.WhatsAppTaskBot.Bot;

import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MessageQueues {
private static  LinkedList<MessageForm> receivedMessageQueue = new LinkedList<>();
private static  LinkedList<MessageForm> sendMessageQueue = new LinkedList<>();



//no constructor - all methods are statics
//static methods

  public static void addToReceivedMessageQueue(MessageForm messageForm) {
    receivedMessageQueue.add(messageForm);
  }

  public static void addToSendMessageQueue(MessageForm messageForm) {
    sendMessageQueue.add(messageForm);
  }

  @org.jetbrains.annotations.Nullable
  public static MessageForm PopReceivedMessageQueue() {
      if (!receivedMessageQueue.isEmpty()) {
          MessageForm lastMessage = receivedMessageQueue.getLast();
          receivedMessageQueue.removeLast();
          return lastMessage;
      }
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
