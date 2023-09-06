package uz.pdp.instagram.reposiitory.user;

import uz.pdp.instagram.domain.DTO.FollowDTO;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.reposiitory.BaseRepositroy;

import java.util.ArrayList;
import java.util.UUID;

public interface UserRepository extends BaseRepositroy<User> {
    ArrayList<User> getUsersByIds(ArrayList<UUID> follows);

    ArrayList<User> search(String name);

}
