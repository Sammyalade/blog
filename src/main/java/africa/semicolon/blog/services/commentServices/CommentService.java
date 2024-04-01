package africa.semicolon.blog.services.commentServices;

import africa.semicolon.blog.dtos.request.postRequest.PostCommentRequest;

public interface CommentService {
    void makeComment(PostCommentRequest postCommentRequest);
}
