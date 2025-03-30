package com.ivgenyT.WhatsAppTaskBot.StorageManager;

public class MessageForm {
    private String _body;
    private String _from;

    public MessageForm(String body, String from) {

        _from = from;
        _body = body;

    }
    public String getBody() {
        return _body;
    }
    public String getFrom() {
        return _from;
    }
}
