package com.tyshchenko.java.training.oop.lesson12.chat.common;

import java.io.Serializable;

/**
 * @author Alexander Tyshchenko.
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    public final Type type;
    public final String sender;
    public final String content;
    public final String recipient;

    public Message(Type type, String sender, String content, String recipient) {
        this.type = type;
        this.sender = sender;
        this.content = content;
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }

    public enum Type {
        MESSAGE,
        LOGIN,
        PING,
        NEW_USER,
        SIGN_UP,
        SIGN_OUT,
        UPLOAD_REQUEST,
        UPLOAD_RESPONSE
    }
}
