package uz.pdp.instagram.service.post;

import uz.pdp.instagram.domain.model.Post;
import uz.pdp.instagram.service.BaseService;

import java.util.ArrayList;
import java.util.UUID;

public interface PostService extends BaseService<Post, Post> {
    ArrayList<Post> getPostsByUserId(UUID uuid);

}
