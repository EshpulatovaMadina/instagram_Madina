package uz.pdp.instagram.reposiitory.comment;

import uz.pdp.instagram.domain.DTO.CommentDTO;
import uz.pdp.instagram.domain.model.Comment;
import uz.pdp.instagram.domain.model.User;
import uz.pdp.instagram.reposiitory.user.UserRepository;
import uz.pdp.instagram.reposiitory.user.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class CommentRepositoryImpl implements CommentRepository {
    UserRepository userRepository = UserRepositoryImpl.getInstance();
    private final ArrayList<Comment> COMMENT = new ArrayList<>();

    private static final CommentRepositoryImpl instance = new CommentRepositoryImpl();

    public static CommentRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public ArrayList<Comment> getAll() {
        return null;
    }

    @Override
    public int save(Comment comment) {
        COMMENT.add(comment);
        return 1;
    }

    @Override
    public Comment getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(Comment comment) {

    }

    @Override
    public ArrayList<Comment> getArrayById(UUID uuid) {
        return null;
    }

    @Override
    public ArrayList<CommentDTO> getCommentDto(UUID uuid) {
        ArrayList<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment comment : COMMENT) {
            if (Objects.equals(comment.getPostId(), uuid)) {
                for (User user : userRepository.getAll()) {
                    if (Objects.equals(comment.getUserId(), user.getUuid())) {
                        CommentDTO commentDTO = new CommentDTO(user.getName(), comment.getText());
                        commentDTOS.add(commentDTO);
                    }
                }
            }
        }
        return commentDTOS;
    }
}
