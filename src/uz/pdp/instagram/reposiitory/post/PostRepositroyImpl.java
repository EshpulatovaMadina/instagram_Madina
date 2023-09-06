package uz.pdp.instagram.reposiitory.post;

import uz.pdp.instagram.domain.model.Message;
import uz.pdp.instagram.domain.model.Post;
import uz.pdp.instagram.reposiitory.message.MessageRepositroyImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class PostRepositroyImpl implements PostRepository{
    private final ArrayList<Post> POSTS = new ArrayList<>();

    private static final PostRepositroyImpl instance = new PostRepositroyImpl();
    public static PostRepositroyImpl getInstance() {
        return instance;
    }

    @Override
    public ArrayList<Post> getAll() {
        return null;
    }

    @Override
    public int save(Post post) {
        POSTS.add(post);
        return 1;
    }

    @Override
    public Post getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(Post post) {
        POSTS.remove(post);
    }

    @Override
    public ArrayList<Post> getArrayById(UUID uuid) {
        return null;
    }

    @Override
    public ArrayList<Post> getPosts(UUID uuid) {
        ArrayList<Post> posts = new ArrayList<>();
        for (Post post : POSTS) {
            if(Objects.equals(post.getOwnerId(),uuid)){
                posts.add(post);
            }
        }
        return posts;
    }
}
