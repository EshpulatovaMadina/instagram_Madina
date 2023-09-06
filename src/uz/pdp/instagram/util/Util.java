package uz.pdp.instagram.util;

import uz.pdp.instagram.service.comment.CommentService;
import uz.pdp.instagram.service.comment.CommentServiceImpl;
import uz.pdp.instagram.service.follow.FollowService;
import uz.pdp.instagram.service.follow.FollowServiceImpl;
import uz.pdp.instagram.service.like.LikeService;
import uz.pdp.instagram.service.like.LikeServiceImpl;
import uz.pdp.instagram.service.message.MessageService;
import uz.pdp.instagram.service.message.MessageServiceImpl;
import uz.pdp.instagram.service.post.PostService;
import uz.pdp.instagram.service.post.PostServiceImpl;
import uz.pdp.instagram.service.user.UserService;
import uz.pdp.instagram.service.user.UserServiceImpl;

import java.util.Scanner;

public interface Util {

    Scanner SCANNER_NUM = new Scanner(System.in);
    Scanner SCANNER_STR = new Scanner(System.in);

    UserService USER_SERVICE = UserServiceImpl.getInstance();
    FollowService FOLLOW_SERVICE = new FollowServiceImpl();
    MessageService MESSAGE_SERVICE = new MessageServiceImpl();

    PostService POST_SERVICE = new PostServiceImpl();
    LikeService LIKE_SERVICE =   LikeServiceImpl.getInstance();
    CommentService COMMENT_SERVICE = new CommentServiceImpl();

}
