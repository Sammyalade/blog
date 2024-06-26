package africa.semicolon.blog.utils;

import africa.semicolon.blog.datas.models.*;
import africa.semicolon.blog.dtos.requests.*;
import africa.semicolon.blog.dtos.responses.PostCreationResponse;
import africa.semicolon.blog.dtos.responses.UserRegistrationResponse;

import java.util.List;

import static africa.semicolon.blog.utils.PostUtility.checkIfListIsNull;

public class Mapper {

    public static Post map(PostCreationRequest postCreationRequest) {
        Post post = new Post();
        post.setTitle(postCreationRequest.getTitle());
        post.setContent(postCreationRequest.getContent());
        post.setLikes((List<Like>) checkIfListIsNull(post.getLikes()));
        post.setViews((List<View>) checkIfListIsNull(post.getViews()));
        post.setComments((List<Comment>) checkIfListIsNull(post.getComments()));
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
        like.setPostTitle(postLikeRequest.getPostTitle());
        return like;
    }

    public static User map(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setUsername(userRegistrationRequest.getUsername());
        user.setEmail(userRegistrationRequest.getEmail());
        return user;
    }

    public static UserRegistrationResponse map(User user) {
        UserRegistrationResponse userRegistrationResponse = new UserRegistrationResponse();
        userRegistrationResponse.setUsername(user.getUsername());
        userRegistrationResponse.setEmail(user.getEmail());
        userRegistrationResponse.setUserId(user.getId());
        return userRegistrationResponse;
    }

    public static UserUpdateResponse map(UserUpdateRequest userUpdateRequest, String username) {
        UserUpdateResponse userUpdateResponse = new UserUpdateResponse();
        userUpdateResponse.setUserName(userUpdateRequest.getUserName());
        userUpdateResponse.setUserId(userUpdateRequest.getUserId());
        return userUpdateResponse;
    }

    public static PostCreationResponse map(Post post, String userId) {
        PostCreationResponse postCreationResponse = new PostCreationResponse();
        postCreationResponse.setPostTitle(post.getTitle());
        postCreationResponse.setPostId(post.getId());
        postCreationResponse.setUserid(userId);
        return postCreationResponse;
    }
}
