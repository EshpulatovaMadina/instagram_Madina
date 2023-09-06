package uz.pdp.instagram.domain.model;

import java.util.UUID;

public class Follow extends BaseModel{
    private UUID ownerId;
    private UUID followerId;

    public Follow(UUID ownerId, UUID followerId) {
        this.ownerId = ownerId;
        this.followerId = followerId;
    }

    public Follow() {
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public UUID getFollowerId() {
        return followerId;
    }

    public void setFollowerId(UUID followerId) {
        this.followerId = followerId;
    }
}
