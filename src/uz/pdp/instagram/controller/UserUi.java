package uz.pdp.instagram.controller;

import uz.pdp.instagram.domain.DTO.CommentDTO;
import uz.pdp.instagram.domain.DTO.SignUpDTO;
import uz.pdp.instagram.domain.model.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

import static uz.pdp.instagram.util.Util.*;

public class UserUi {

    public static void userMenyu(User user) {
        User user1 = new User.UserBuilder().setName("k").setPassword("k").setPhoneNum("k").build();
        SignUpDTO signUpDTO = new SignUpDTO("k","k","k");
        USER_SERVICE.add(signUpDTO);
        User user2 = new User.UserBuilder().setName("m").setPassword("m").setPhoneNum("m").build();
        SignUpDTO signUpDTO1 = new SignUpDTO("m","m","m");
        USER_SERVICE.add(signUpDTO1);
//        Post post = new Post.postBuilder().setOwnerId()
        showMyFollowers(user);
        while (true) {
            System.out.println("""
                    1.Message
                    2.Post
                    3.Follow
                    4.Like post
                    5.Comment
                    6.See my posts
                    0.exit""");
            String a = SCANNER_STR.nextLine();
            switch (a) {
                case "1" -> {
                    messageWrite(user);
                }
                case "2" -> {
                    posting(user);
                }
                case "3" -> {
                    following(user);
                }
                case "4" -> {
                    clickLike(user);
                }
                case "5" -> {
                    comment(user);
                }
                case "6" -> seeMyPost(user);
                case "0" -> {
                    return;
                }
            }

        }
    }

    private static void showMyFollowers(User user) {
        ArrayList<User> users = FOLLOW_SERVICE.getMyFollowers(user.getUuid());
        int count = 0;
        if( users.isEmpty()){
            System.out.println("""
                    0️⃣
                followers""");
        }else {
            for (User myFollower : users) {
                count++;
            }
            System.out.println("<<<"+count+">>>\t\n");
            System.out.println("1.Followers\t0.Back");
            int d = SCANNER_NUM.nextInt();
            if(d == 1){
                for (User user1 : users) {
                    System.out.println(user1.getName()+" || "+ user1.getPhoneNum());
                    System.out.println("----------------------------");
                }
            }else {
                return;
            }
        }
    }

    private static void seeMyPost(User user) {
        ArrayList<Post> postsByUserId = POST_SERVICE.getPostsByUserId(user.getUuid());
        int i = 1;
        for (Post post : postsByUserId) {
            System.out.println(i++ + " || " + post.getTitle() + " . " + post.getText());
        }
        System.out.println(" Choose post : ");
        int d = SCANNER_NUM.nextInt();
        Post post = postsByUserId.get(d - 1);
        System.out.println("<<<" + post.getTitle() + ">>>");
        System.out.println("1.Delete\t2.Comments\t3.likes\t0.Back");
        String p = SCANNER_STR.nextLine();
        switch (p) {
            case "1" -> {
                POST_SERVICE.remove(post);
            }
            case "2" -> {
                myComments(post.getUuid());
            }
            case "3" -> {
                System.out.println("❤️" + LIKE_SERVICE.myPostLike(post.getUuid()) + " LIKES");
            }
            case "0" -> {
                return;
            }
            default -> {

                System.out.println("Wrong input ");
                return;
            }
        }


    }

    private static void myComments(UUID uuid) {
        ArrayList<CommentDTO> commentDTOS = COMMENT_SERVICE.getComment(uuid);
        if(commentDTOS.isEmpty()){
            System.out.println(" No comment ");
        }else {
            for (CommentDTO commentDTO : commentDTOS) {
                System.out.println("___ " + commentDTO.name() + " ___");
                System.out.println(commentDTO.comment());
                System.out.println("-------------------------------");
            }
        }
    }

    private static User searchUser(User user) {
        System.out.print(" Enter user name for search : ");
        String name = SCANNER_STR.nextLine();
        ArrayList<User> users = USER_SERVICE.search(name);
        if (users.isEmpty()) {
            System.out.println("User not found : \n");
        } else {
            int i = 1;
            for (User user1 : users) {
                System.out.println(i++ + " || " + user1.getName() + " . " + user1.getPhoneNum());
                System.out.println("-----------------------------------------");
            }
            System.out.println(" Choose user: ");
            int a = SCANNER_NUM.nextInt();
            return users.get(a - 1);
        }
        return null;

    }

    public static void messageWrite(User user) {
        ArrayList<User> users = myFollowersShow(user);
        if (users.isEmpty()) {
            System.out.println(" You don't have a chat yet");
            System.out.println("Wait for someone to follow you ");
        } else {
            System.out.println(" Choose: ");
            int s = SCANNER_NUM.nextInt();
            User user1 = users.get(s - 1);
            ArrayList<Message> messages = MESSAGE_SERVICE.getMessages(user.getUuid(), user1.getUuid());
            if (messages.isEmpty()) {
                System.out.println("🙄");
            } else {
                for (Message message : messages) {
                    if (Objects.equals(message.getSenderId(), user1.getUuid())) {
                        System.out.println(message.getText());
                    } else if (Objects.equals(message.getSenderId(), user.getUuid())) {
                        System.out.println("                        " + message.getText());
                    }
                }

            }

            System.out.print("Message...");
            String message = SCANNER_STR.nextLine();

            Message message1 = new Message.MessageBuilder()
                    .setText(message)
                    .setReceiverId(user1.getUuid())
                    .setSenderId(user.getUuid())
                    .build();
            MESSAGE_SERVICE.add(message1);
            if(FOLLOW_SERVICE.isFollow(user.getUuid(),user1.getUuid())){

            }else {
                Follow follow = new Follow(user1.getUuid(), user.getUuid());
                FOLLOW_SERVICE.add(follow);
                System.out.println(" You are followed this user ");
            }

        }
    }

    public static ArrayList<User> myFollowersShow(User user) {
        ArrayList<User> users = FOLLOW_SERVICE.getMyFollowers(user.getUuid());
        int i = 1;
        for (User follower : users) {
            System.out.println(i++ + " || " + follower.getName() + " . " + follower.getPhoneNum());
        }
        return users;
    }

    public static void posting(User user) {
        System.out.print(" Enter post title : ");
        String title = SCANNER_STR.nextLine();

        System.out.print(" Enter post : ");
        String text = SCANNER_STR.nextLine();

        Post post = new Post.postBuilder()
                .setTitle(title)
                .setText(text)
                .setOwnerId(user.getUuid())
                .build();
        POST_SERVICE.add(post);
        System.out.println("✅✅✅");


    }

    public static void following(User user) {
        User user1 = searchUser(user);
        if (user1 == null) {
            return;
        } else {
            if (FOLLOW_SERVICE.isFollow(user.getUuid(), user1.getUuid())) {
                System.out.println(" follow ");
            } else {
                System.out.println("1.Following\t0.Back");
                System.out.print("-> ");
                int a = SCANNER_NUM.nextInt();
                if (a == 1) {
                    System.out.println("Follow👍");
                    Follow follow = new Follow(user1.getUuid(), user.getUuid());
                    FOLLOW_SERVICE.add(follow);
                } else if (a == 0) {
                    return;
                } else {
                    System.out.println(" Wrong input");
                }
            }
        }
    }

    public static void clickLike(User user) {
        User user1 = searchUser(user);
        ArrayList<Post> posts = POST_SERVICE.getPostsByUserId(user1.getUuid());
        if (posts.isEmpty()) {
            System.out.println("This user has not posted yet");
        } else {
            int i = 1;
            for (Post post : posts) {
                System.out.println(i++ + " || " + post.getTitle() + " . " + post.getText());
            }
            System.out.println(" Choose post : ");
            int k = SCANNER_NUM.nextInt();
            System.out.println(posts.get(k - 1).getTitle());
            if (LIKE_SERVICE.isLike(user.getUuid(), posts.get(k - 1).getUuid())) {
                System.out.println("❤️");
                System.out.println("1.Dislike\t0.Back");
                int l = SCANNER_NUM.nextInt();
                if (l == 1) {
                    System.out.println("🤍");
                    LIKE_SERVICE.delete(user.getUuid(), posts.get(k - 1).getUuid());
                } else {
                    return;
                }
            } else {
                System.out.println("🤍\t\n");
                LIKE_SERVICE.add(new Like(posts.get(k - 1).getUuid(), user.getUuid()));
                System.out.println("LIKED...❤️");
            }
        }
    }


    public static void comment(User user) {
        User user1 = searchUser(user);
        ArrayList<Post> posts = POST_SERVICE.getPostsByUserId(user1.getUuid());
        if (posts.isEmpty()) {
            System.out.println("This user has not posted yet");
        } else {
            int i = 1;
            for (Post post : posts) {
                System.out.println(i++ + " || " + post.getTitle() + " . " + post.getText());
            }
            System.out.println(" Choose post : ");
            int k = SCANNER_NUM.nextInt();
            System.out.println(posts.get(k - 1).getTitle());
            ArrayList<CommentDTO> commentDTOS = COMMENT_SERVICE.getComment(posts.get(k - 1).getUuid());
            if (commentDTOS.isEmpty()) {
                System.out.println();
            } else {
                int w = 1;
                for (CommentDTO commentDTO : commentDTOS) {
                    System.out.println(w++ + " || " + commentDTO.name());
                    System.out.println(commentDTO.comment());
                    System.out.println("-------------------------------");
                }
            }
            System.out.println(" Comment...");
            String text = SCANNER_STR.nextLine();
            Comment comment = new Comment(posts.get(k - 1).getUuid(), user.getUuid(), text);
            COMMENT_SERVICE.add(comment);
            System.out.println("✅✅✅");
        }

    }

}
