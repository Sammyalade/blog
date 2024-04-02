package africa.semicolon.blog.services.likeServices;

import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.datas.repositories.LikeRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;
import africa.semicolon.blog.exceptions.LikeAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.blog.utils.LikeUtility.checkIfUserLikeExist;
import static africa.semicolon.blog.utils.Mapper.map;

@Service("likeServiceImpl")
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;
    @Override
    public Like makeLike(PostLikeRequest postLikeRequest) {
        Like like = map(postLikeRequest);
        if(!checkIfUserLikeExist(postLikeRequest, likeRepository.findAll())) {
            likeRepository.save(like);
            return like;
        }
        throw new LikeAlreadyExistException("Like already Exist");
    }


}
