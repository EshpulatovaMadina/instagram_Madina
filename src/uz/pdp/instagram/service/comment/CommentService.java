package uz.pdp.instagram.service.comment;

import uz.pdp.instagram.domain.DTO.CommentDTO;
import uz.pdp.instagram.domain.model.Comment;
import uz.pdp.instagram.service.BaseService;

import java.util.ArrayList;
import java.util.UUID;

public interface CommentService extends BaseService<Comment,Comment> {
    ArrayList<CommentDTO> getComment(UUID uuid);

}
