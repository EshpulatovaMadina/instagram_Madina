package uz.pdp.instagram.reposiitory.follow;

import uz.pdp.instagram.domain.model.Follow;


import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class FollowRepositoryImpl implements FollowRepository{
    private final ArrayList<Follow> FOLLOWS = new ArrayList<>();

    private static final FollowRepositoryImpl instance = new FollowRepositoryImpl();
    public static FollowRepositoryImpl getInstance() {
        return instance;
    }
    @Override
    public ArrayList<Follow> getAll() {
        return null;
    }

    @Override
    public int save(Follow follow) {
        FOLLOWS.add(follow);
        return 1;
    }

    @Override
    public Follow getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(Follow follow) {

    }

    @Override
    public ArrayList<Follow> getArrayById(UUID uuid) {
        return null;
    }

    @Override
    public ArrayList<UUID> getMyFollowers(UUID uuid) {
        ArrayList<UUID> follows = new ArrayList<>();
        for (Follow follow : FOLLOWS) {
            if(Objects.equals(follow.getOwnerId(),uuid)){
                follows.add(follow.getFollowerId());
            }
        }
        return follows;
    }

    @Override
    public boolean isFOLLOWER(UUID uuid, UUID uuid1) {
        for (Follow follow : FOLLOWS) {
            if(Objects.equals(follow.getOwnerId(),uuid1) && Objects.equals(follow.getFollowerId(),uuid)){
                return true;
            }
        }
        return false;
    }
}
