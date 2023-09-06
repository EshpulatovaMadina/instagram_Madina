package uz.pdp.instagram.domain.model;

import java.util.UUID;

public class Post extends BaseModel{

    private String title;
    private String text;
    private UUID ownerId;

    public Post(postBuilder postBuilder) {
        this.title = postBuilder.title;
        this.text = postBuilder.text;
        this.ownerId = postBuilder.ownerId;
    }

    public static class postBuilder{
        String title;
        String text;
        private UUID ownerId;

        public   postBuilder setOwnerId(UUID ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public  postBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public  postBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public Post build(){
            return new Post(this);
        }
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
