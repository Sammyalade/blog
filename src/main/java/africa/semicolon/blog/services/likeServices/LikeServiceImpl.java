package africa.semicolon.blog.services.likeServices;

import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;
import africa.semicolon.blog.services.likeServices.LikeService;
import org.springframework.stereotype.Service;

@Service("likeServiceImpl")
public class LikeServiceImpl implements LikeService {
    @Override
    public void makeLike(PostLikeRequest postLikeRequest) {

    }
}
