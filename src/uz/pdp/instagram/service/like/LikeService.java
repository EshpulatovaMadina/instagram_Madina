package uz.pdp.instagram.service.like;

import uz.pdp.instagram.domain.model.Like;
import uz.pdp.instagram.service.BaseService;

import java.util.UUID;

public interface LikeService extends BaseService<Like,Like> {
    boolean isLike(UUID uuid, UUID uuid1);

    void delete(UUID uuid, UUID uuid1);

    int myPostLike(UUID uuid);

}
