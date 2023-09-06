package uz.pdp.instagram.reposiitory.like;

import uz.pdp.instagram.domain.model.Like;
import uz.pdp.instagram.reposiitory.BaseRepositroy;

import java.util.UUID;

public interface LikeRepository extends BaseRepositroy<Like> {
    boolean isLike(UUID uuid, UUID uuid1);

    void delete(UUID uuid, UUID uuid1);

    int myLikes(UUID uuid);

}
