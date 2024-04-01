package africa.semicolon.blog.services.commentServices;

import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.datas.repositories.CommentRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.blog.utils.Mapper.map;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public void makeComment(PostCommentRequest postCommentRequest, List<Post> posts) {
        Comment comment = map(postCommentRequest, posts);
        commentRepository.save(comment);
    }
}
