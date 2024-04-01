package africa.semicolon.blog.services.commentServices;

import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.dtos.request.postRequest.PostCommentRequest;

import java.util.List;

public interface CommentService {
    void makeComment(PostCommentRequest postCommentRequest);
}
