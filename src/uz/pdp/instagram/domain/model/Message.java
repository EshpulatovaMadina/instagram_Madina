package uz.pdp.instagram.domain.model;

import java.util.UUID;

public class Message extends BaseModel{
    private String text;
    private UUID senderId;
    private UUID receiverId;

    public Message(MessageBuilder messageBuilder) {
        this.receiverId = messageBuilder.receiverId;
        this.senderId = messageBuilder.senderId;
        this.text = messageBuilder.text;
    }

    public static class MessageBuilder{
        private String text;
        private UUID senderId;
        private UUID receiverId;

        public MessageBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public MessageBuilder setSenderId(UUID senderId) {
            this.senderId = senderId;
            return this;
        }

        public MessageBuilder setReceiverId(UUID receiverId) {
            this.receiverId = receiverId;
            return this;
        }
        public Message build(){
            return new Message(this);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public UUID getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }
}
