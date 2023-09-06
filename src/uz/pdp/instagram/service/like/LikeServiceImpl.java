package uz.pdp.instagram.service.like;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.model.Like;
import uz.pdp.instagram.reposiitory.like.LikeRepository;
import uz.pdp.instagram.reposiitory.like.LikeRepositoryImpl;

import java.util.UUID;

public class LikeServiceImpl implements LikeService{
    LikeRepository likeRepository = new LikeRepositoryImpl();
    private static  final LikeServiceImpl instance = new LikeServiceImpl();

    private LikeServiceImpl() {

    }
    public static LikeServiceImpl getInstance() {
        return instance;
    }
    @Override
    public boolean isLike(UUID uuid, UUID uuid1) {
        return likeRepository.isLike(uuid,uuid1);
    }

    @Override
    public void delete(UUID uuid, UUID uuid1) {
        likeRepository.delete(uuid,uuid1);
    }

    @Override
    public int myPostLike(UUID uuid) {
        return  likeRepository.myLikes(uuid);
    }

    @Override
    public BaseResponce add(Like like) {
        likeRepository.save(like);
        return new BaseResponce("ok",200);
    }

    @Override
    public int remove(Like like) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }
}
