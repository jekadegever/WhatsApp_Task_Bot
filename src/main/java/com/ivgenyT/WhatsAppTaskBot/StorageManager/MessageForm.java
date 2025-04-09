package com.ivgenyT.WhatsAppTaskBot.StorageManager;

public class MessageForm {
    private String _body;
    private String _from;
    private String _receivedDateTime;

    public MessageForm(String body, String from, String receivedDateTime) {

        _from = from;
        _body = body;
        _receivedDateTime = receivedDateTime;

    }
    public String getBody() {
        return _body;
    }
    public String getFrom() {
        return _from;
    }
    public String getReceivedDateTime() {
        return _receivedDateTime;
    }

    public String toString() {
        return "Message body: "+_body+" received from: "+_from+" on date: "+_receivedDateTime;
    }
}
