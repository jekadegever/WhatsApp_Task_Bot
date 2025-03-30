package com.ivgenyT.WhatsAppTaskBot;

//imports

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class utilities_functions_TODO {
/*
    //todo transfer to data base package

    private  List<MessageData> loadMessages() {
       //open file and create json reader object
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

 */
}
