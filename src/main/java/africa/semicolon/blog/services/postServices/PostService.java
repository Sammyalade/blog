package africa.semicolon.blog.services.postServices;

import africa.semicolon.blog.dtos.request.postRequest.*;

public interface PostService {

    void makePost(PostCreationRequest postCreationRequest);
    void deletePost(String title);
    void updatePost(PostUpdateRequest postUpdateRequest);
    void makeComment(PostCommentRequest postLikeRequest);
    void makeLike(PostLikeRequest postLikeRequest);
    void viewPost(PostViewRequest postViewRequest);
}
