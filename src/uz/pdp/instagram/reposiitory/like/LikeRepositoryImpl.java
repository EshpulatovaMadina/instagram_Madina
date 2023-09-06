package uz.pdp.instagram.reposiitory.like;

import uz.pdp.instagram.domain.model.Like;



import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class LikeRepositoryImpl implements LikeRepository{
    private final ArrayList<Like> LIKES = new ArrayList<>();

    private static final LikeRepositoryImpl instance = new LikeRepositoryImpl();
    public static LikeRepositoryImpl getInstance() {
        return instance;
    }
    @Override
    public ArrayList<Like> getAll() {
        return null;
    }

    @Override
    public int save(Like like) {
        LIKES.add(like);
        return 1;
    }

    @Override
    public Like getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(Like like) {

    }

    @Override
    public ArrayList<Like> getArrayById(UUID uuid) {
        return null;
    }

    @Override
    public boolean isLike(UUID uuid, UUID uuid1) {
        for (Like like : LIKES) {
            if(Objects.equals(like.getUserId(),uuid) && Objects.equals(like.getPostId(),uuid1)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(UUID uuid, UUID uuid1) {
        for (Like like : LIKES) {
            if(Objects.equals(like.getUserId(),uuid) && Objects.equals(like.getPostId(),uuid1)){
                LIKES.remove(like);
            }
        }
    }

    @Override
    public int myLikes(UUID uuid) {
        int c = 0;
        for (Like like : LIKES) {
            if(Objects.equals(like.getPostId(),uuid)){
                c++;
            }
        }
        return c;
    }
}
