package africa.semicolon.blog.services.commentServices;

import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.datas.repositories.CommentRepository;
import africa.semicolon.blog.dtos.request.postRequest.CommentEditRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostCommentRequest;
import africa.semicolon.blog.exceptions.CommentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static africa.semicolon.blog.utils.Mapper.map;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment makeComment(PostCommentRequest postCommentRequest) {
        Comment comment = map(postCommentRequest);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void editComment(CommentEditRequest commentEditRequest){
        Optional<Comment> comment = commentRepository.findById(commentEditRequest.getCommentId());
        if(comment.isPresent()){
            comment.get().setCommentBody(commentEditRequest.getCommentBody());
            commentRepository.save(comment.get());
        }
        else {
            throw new CommentNotFoundException("Comment not found");
        }
    }
}
