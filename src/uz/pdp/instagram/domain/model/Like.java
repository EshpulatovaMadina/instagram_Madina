package uz.pdp.instagram.domain.model;

import java.util.ArrayList;
import java.util.UUID;

public class Like extends BaseModel {
    private UUID postId;
    private UUID userId;

    public Like(UUID postId, UUID userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public Like() {
    }

    public UUID getPostId() {
        return postId;
    }

    public void setPostId(UUID postId) {
        this.postId = postId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
