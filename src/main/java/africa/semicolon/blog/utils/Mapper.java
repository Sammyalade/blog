package africa.semicolon.blog.utils;

import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.datas.models.View;
import africa.semicolon.blog.dtos.request.postRequest.PostCommentRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostCreationRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostViewRequest;

import java.util.List;

import static africa.semicolon.blog.utils.PostUtility.findPost;

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
        comment.setPostTitle(postCommentRequest.getPostTitle());
        return comment;
    }

    public static View map(PostViewRequest postViewRequest){
        View view = new View();
        view.setViewer(postViewRequest.getViewer());
        view.setPostTitle(postViewRequest.getPostTitle());
        return view;
    }

    public static Like map(PostLikeRequest postLikeRequest){
        Like like = new Like();
        like.setLikedBy(postLikeRequest.getLikedBy());
        like.setPostTitle(postLikeRequest.getPostTitle());
        return like;
    }
}
