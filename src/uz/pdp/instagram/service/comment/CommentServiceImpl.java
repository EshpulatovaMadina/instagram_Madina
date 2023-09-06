package uz.pdp.instagram.service.comment;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.DTO.CommentDTO;
import uz.pdp.instagram.domain.model.Comment;
import uz.pdp.instagram.reposiitory.comment.CommentRepository;
import uz.pdp.instagram.reposiitory.comment.CommentRepositoryImpl;

import java.util.ArrayList;
import java.util.UUID;

public class CommentServiceImpl implements CommentService{

    CommentRepository commentRepository = CommentRepositoryImpl.getInstance();
    @Override
    public BaseResponce add(Comment comment) {
        commentRepository.save(comment);
        return new BaseResponce("ok",200);
    }

    @Override
    public int remove(Comment comment) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public ArrayList<CommentDTO> getComment(UUID uuid) {
        return commentRepository.getCommentDto(uuid);
    }
}
