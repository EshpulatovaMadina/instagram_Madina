package uz.pdp.instagram.reposiitory.comment;

import uz.pdp.instagram.domain.DTO.CommentDTO;
import uz.pdp.instagram.domain.model.Comment;
import uz.pdp.instagram.reposiitory.BaseRepositroy;

import java.util.ArrayList;
import java.util.UUID;

public interface CommentRepository extends BaseRepositroy<Comment> {
    ArrayList<CommentDTO> getCommentDto(UUID uuid);

}
