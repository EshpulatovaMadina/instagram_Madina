package uz.pdp.instagram.reposiitory.post;

import uz.pdp.instagram.domain.model.Post;
import uz.pdp.instagram.reposiitory.BaseRepositroy;

import java.util.ArrayList;
import java.util.UUID;

public interface PostRepository extends BaseRepositroy<Post> {
    ArrayList<Post> getPosts(UUID uuid);

}
