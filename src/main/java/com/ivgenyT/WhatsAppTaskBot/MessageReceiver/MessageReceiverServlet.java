package com.ivgenyT.WhatsAppTaskBot.MessageReceiver;

import com.ivgenyT.WhatsAppTaskBot.Bot.MessageQueues;
import com.ivgenyT.WhatsAppTaskBot.StorageManager.MessageForm;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class MessageReceiverServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // קבלת תוכן ההודעה
        String body = req.getParameter("Body");
        // אם יש צורך, ניתן להוסיף גם פרמטרים נוספים כמו "From"
        String from = req.getParameter("From");

        //get message sent time
        //format : 2025-04-06T15:22:15Z
        String sentTime = req.getParameter("date_sent");

        //create message body
        MessageForm receivedMessage = new MessageForm(body, from, sentTime);

        // הגדרת התגובה
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().flush();

        resp.getWriter().close();

        try{
            MessageQueues.addToReceivedMessageQueue(receivedMessage);
        }catch(Exception e){
            //todo what happened when interupt
            System.out.println(e);

        }

    }

}
