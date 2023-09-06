package uz.pdp.instagram.service.post;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.model.Post;
import uz.pdp.instagram.reposiitory.post.PostRepository;
import uz.pdp.instagram.reposiitory.post.PostRepositroyImpl;

import java.util.ArrayList;
import java.util.UUID;

public class PostServiceImpl implements PostService{
    PostRepository postRepository = PostRepositroyImpl.getInstance();


    @Override
    public ArrayList<Post> getPostsByUserId(UUID uuid) {
        return postRepository.getPosts(uuid);
    }


    @Override
    public BaseResponce add(Post post) {
        postRepository.save(post);
        return new BaseResponce("ok",200);
    }

    @Override
    public int remove(Post post) {
        postRepository.remove(post);
        return 1;
    }

    @Override
    public void remove(UUID uuid) {

    }
}
