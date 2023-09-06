package uz.pdp.instagram.reposiitory.user;
import uz.pdp.instagram.domain.DTO.FollowDTO;
import uz.pdp.instagram.domain.model.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository{
    private final ArrayList<User> USERS = new ArrayList<>();

    private static final UserRepositoryImpl instance = new UserRepositoryImpl();
    public static UserRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public ArrayList<User> getAll() {
        return USERS;
    }

    @Override
    public int save(User user) {
        for (User user1 : USERS) {
            if(Objects.equals(user1.getPhoneNum(),user.getPhoneNum())){
                return -1;
            }
        }
        USERS.add(user);
        return 1;
    }

    @Override
    public User getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public ArrayList<User> getArrayById(UUID uuid) {
        return null;
    }

    @Override
    public ArrayList<User> getUsersByIds(ArrayList<UUID> follows) {
        ArrayList<User> users = new ArrayList<>();
        for (User user : USERS) {
            for (UUID follow : follows) {
                if(Objects.equals(user.getUuid(),follow)){
                    users.add(user);
                }
            }
        }
        return users;
    }

    @Override
    public ArrayList<User> search(String name) {
        ArrayList<User> users = new ArrayList<>();
        for (User user : USERS) {
            if(user.getName().contains(name)){
                users.add(user);
            }
        }
        return users;
    }
}
