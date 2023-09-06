package uz.pdp.instagram.service.user;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.DTO.SignInDTO;
import uz.pdp.instagram.domain.DTO.SignUpDTO;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.reposiitory.user.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private static final UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    private final UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

    @Override
    public BaseResponce add(SignUpDTO signUpDTO) {
        User user = new User.UserBuilder()
                .setPhoneNum(signUpDTO.phoneNUm())
                .setPassword(signUpDTO.password())
                .setName(signUpDTO.name()).build();

        int save = userRepository.save(user);
        if (save == -1) {
            return new BaseResponce("This user already exists", 400);
        } else {
            return new BaseResponce("Successfully signed up", 200);
        }
    }

    @Override
    public int remove(User user) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public BaseResponce<User> signIN(SignInDTO signInDTO) {
        User user = new User.UserBuilder()
                .setPhoneNum(signInDTO.phoneNum())
                .setPassword(signInDTO.password())
                .build();
        ArrayList<User> all = userRepository.getAll();
        if (all.isEmpty() || all == null) {
            return new BaseResponce<>("User not found", 400);
        }
        for (User user1 : all) {
            if (Objects.equals(user1.getPhoneNum(), user.getPhoneNum())) {
                return new BaseResponce<>("ok", user1, 200);
            }
        }
        return new BaseResponce<>("User not found", 400);
    }

    @Override
    public ArrayList<User> search(String name) {
        return userRepository.search(name);
    }
}











