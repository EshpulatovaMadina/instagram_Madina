package uz.pdp.instagram.service.follow;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.DTO.FollowDTO;
import uz.pdp.instagram.domain.model.Follow;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.reposiitory.follow.FollowRepository;
import uz.pdp.instagram.reposiitory.follow.FollowRepositoryImpl;
import uz.pdp.instagram.reposiitory.user.UserRepository;
import uz.pdp.instagram.reposiitory.user.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.UUID;

public class FollowServiceImpl implements FollowService{
    FollowRepository followRepository =  FollowRepositoryImpl.getInstance();

    UserRepository userRepository = UserRepositoryImpl.getInstance();



    @Override
    public ArrayList<User> getMyFollowers(UUID uuid) {
        ArrayList<UUID> follows = followRepository.getMyFollowers(uuid);
        return userRepository.getUsersByIds(follows);

    }

    @Override
    public boolean isFollow(UUID uuid, UUID uuid1) {
        return followRepository.isFOLLOWER(uuid,uuid1);
    }

    @Override
    public BaseResponce add(Follow follow) {
        followRepository.save(follow);
        return new BaseResponce("ok",200);
    }

    @Override
    public int remove(Follow follow) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }
}
