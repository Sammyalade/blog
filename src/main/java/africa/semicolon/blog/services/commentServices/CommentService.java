package africa.semicolon.blog.services.commentServices;

import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.dtos.requests.CommentEditRequest;
import africa.semicolon.blog.dtos.requests.PostCommentRequest;

public interface CommentService {
    Comment makeComment(PostCommentRequest postCommentRequest);

    void deleteComment(String id);

    void editComment(CommentEditRequest commentEditRequest);

    Comment findComment(String commentId);
}
