package com.ivgenyT.WhatsAppTaskBot.MessageSender;
import java.lang.String;

public enum Contacts {

    IVGENY("+972503001406"),
    IRINA("+972584599597"),
    ELLA("+972508530506"),
    PASHA("+972529217390"),
    BOT("+14155238886"),
    Alex("+972528903372");

    private final String phone_Type = "whatsapp:";
    private final String number;



   private Contacts(String number) {
        this.number = phone_Type+number;
    }

    public String getNumber(){
       return this.number;
    }
}
