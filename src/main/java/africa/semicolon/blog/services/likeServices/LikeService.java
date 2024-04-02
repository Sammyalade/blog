package africa.semicolon.blog.services.likeServices;

import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRemoveRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;

public interface LikeService {


    Like makeLike(PostLikeRequest postLikeRequest);

    void removeLike(PostLikeRemoveRequest postLikeRemoveRequest);
}
