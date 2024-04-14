package africa.semicolon.blog.services.commentServices;

import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.dtos.request.postRequest.CommentEditRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostCommentRequest;

public interface CommentService {
    Comment makeComment(PostCommentRequest postCommentRequest);

    void deleteComment(String id);

    void editComment(CommentEditRequest commentEditRequest);
}
