package africa.semicolon.blog.services.likeServices;

import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;

public interface LikeService {


    void makeLike(PostLikeRequest postLikeRequest);
}
