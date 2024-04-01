package africa.semicolon.blog.services.likeServices;

import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.datas.repositories.LikeRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;
import africa.semicolon.blog.services.likeServices.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.blog.utils.Mapper.map;

@Service("likeServiceImpl")
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;
    @Override
    public void makeLike(PostLikeRequest postLikeRequest) {
        Like like = map(postLikeRequest);
        likeRepository.save(like);
    }
}
