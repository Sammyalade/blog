package africa.semicolon.blog.utils;

import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.dtos.request.postRequest.PostCommentRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostCreationRequest;

public class Mapper {

    public static Post map(PostCreationRequest postCreationRequest) {
        Post post = new Post();
        post.setTitle(postCreationRequest.getTitle());
        post.setContent(postCreationRequest.getContent());
        return post;
    }

    public static Comment map(PostCommentRequest postCommentRequest) {
        Comment comment = new Comment();
        comment.setViewer(postCommentRequest.getViewer());
        comment.setCommentBody(postCommentRequest.getCommentBody());
        return comment;
    }
}
