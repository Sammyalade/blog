package africa.semicolon.blog.services.postServices;

import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.dtos.requests.*;

public interface PostService {

    Post makePost(PostCreationRequest postCreationRequest);
    void deletePost(String title);
    void updatePost(PostUpdateRequest postUpdateRequest);
    void makeComment(PostCommentRequest postLikeRequest);
    void makeLike(PostLikeRequest postLikeRequest);
    void viewPost(PostViewRequest postViewRequest);
    void removeLike(PostLikeRemoveRequest postLikeRemoveRequest);

    Post findPostById(String postId);
}
