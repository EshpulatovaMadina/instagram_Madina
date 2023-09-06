package uz.pdp.instagram.reposiitory.follow;

import uz.pdp.instagram.domain.model.Follow;
import uz.pdp.instagram.reposiitory.BaseRepositroy;

import java.util.ArrayList;
import java.util.UUID;

public interface FollowRepository extends BaseRepositroy<Follow> {
    ArrayList<UUID> getMyFollowers(UUID uuid);

    boolean isFOLLOWER(UUID uuid, UUID uuid1);

}
