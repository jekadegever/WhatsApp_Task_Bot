package com.ivgenyT.WhatsAppTaskBot.Bot;

import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;

import java.util.ArrayList;
import java.util.List;

public class MessageQueues {
private static List<MessageForm> receivedMessageQueue = new ArrayList<MessageForm>();
private static List<MessageForm> sendMessageQueue = new ArrayList<>();



  public static void addToReceivedMessageQueue(MessageForm messageForm) {
    receivedMessageQueue.add(messageForm);
  }

  public static void addToSendMessageQueue(MessageForm messageForm) {
    sendMessageQueue.add(messageForm);
  }

  public static MessageForm PopReceivedMessageQueue() {
      if (!receivedMessageQueue.isEmpty()) {
          return receivedMessageQueue.getLast();
      }
      return null;
  }

  public static MessageForm PopSendMessageQueue() {
      if (!sendMessageQueue.isEmpty()) {
          return sendMessageQueue.getLast();
      }
      return null;
  }

}
