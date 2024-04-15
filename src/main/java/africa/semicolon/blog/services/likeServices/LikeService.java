package africa.semicolon.blog.services.likeServices;

import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.dtos.requests.PostLikeRemoveRequest;
import africa.semicolon.blog.dtos.requests.PostLikeRequest;

public interface LikeService {


    Like makeLike(PostLikeRequest postLikeRequest);

    void removeLike(PostLikeRemoveRequest postLikeRemoveRequest);
}
