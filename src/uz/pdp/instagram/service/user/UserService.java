package uz.pdp.instagram.service.user;
import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.DTO.SignInDTO;
import uz.pdp.instagram.domain.DTO.SignUpDTO;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.service.BaseService;

import java.util.ArrayList;

public interface UserService extends BaseService<SignUpDTO, User> {
    BaseResponce<User> signIN (SignInDTO signInDTO);

    ArrayList<User> search(String name);

}
