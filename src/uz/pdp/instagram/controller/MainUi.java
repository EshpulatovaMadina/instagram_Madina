package uz.pdp.instagram.controller;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.DTO.SignInDTO;
import uz.pdp.instagram.domain.DTO.SignUpDTO;
import uz.pdp.instagram.domain.model.User;

import static uz.pdp.instagram.util.Util.*;

public class MainUi {
    public static void runWindow() {
        int a = 0;
        while (true){
            System.out.println("""
                    1.Sign in
                    2.Sign up
                    0.Exit
                    """);
            a = SCANNER_NUM.nextInt();
            switch (a){
                case 1 -> signIn();
                case 2 -> signUp();
                case 0 -> {
                    return;
                }
                default -> System.out.println(" Wrong input");
            }
        }
    }

    private static void signUp() {
        System.out.print(" Enter name : ");
        String name = SCANNER_STR.nextLine();

        System.out.print(" Enter password : ");
        String password = SCANNER_STR.nextLine();

        System.out.print(" Enter phone number : ");
        String phoneNum = SCANNER_STR.nextLine();
        SignUpDTO signUpDTO = new SignUpDTO(name,phoneNum,password);
        BaseResponce baseResponce = USER_SERVICE.add(signUpDTO);
        System.out.println(baseResponce.getMessage());
        return;
    }

    private static void signIn() {
        System.out.print(" Enter phone number : ");
        String phoneNum = SCANNER_STR.nextLine();

        System.out.print(" Enter password : ");
        String password = SCANNER_STR.nextLine();

        SignInDTO signInDTO = new SignInDTO(phoneNum,password);
        BaseResponce<User> userBaseResponce = USER_SERVICE.signIN(signInDTO);
        if(userBaseResponce.getStatus() == 200){
            UserUi.userMenyu(userBaseResponce.getData());
        } else if (userBaseResponce.getStatus() == 400) {
            System.out.println(userBaseResponce.getMessage());
            return;
        }
    }
}





















