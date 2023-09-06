package uz.pdp.instagram.service.follow;

import uz.pdp.instagram.domain.DTO.FollowDTO;
import uz.pdp.instagram.domain.model.Follow;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.service.BaseService;

import java.util.ArrayList;
import java.util.UUID;

public interface FollowService extends BaseService<Follow,Follow> {
    ArrayList<User> getMyFollowers(UUID uuid);

    boolean isFollow(UUID uuid, UUID uuid1);

}
