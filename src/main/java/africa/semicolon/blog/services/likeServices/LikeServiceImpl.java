package africa.semicolon.blog.services.likeServices;

import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.datas.repositories.LikeRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;
import africa.semicolon.blog.exceptions.LikeAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.blog.utils.Mapper.map;

@Service("likeServiceImpl")
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;
    @Override
    public Like makeLike(PostLikeRequest postLikeRequest) {
        Like like = map(postLikeRequest);
        if(!checkIfUserLikeExist(postLikeRequest)) {
            likeRepository.save(like);
            return like;
        }
        throw new LikeAlreadyExistException("Like already Exist");
    }

    private boolean checkIfUserLikeExist(PostLikeRequest postLikeRequest) {
        for(Like like: likeRepository.findAll()){
            if(like.getLikedBy().equals(postLikeRequest.getLikedBy()) &&
                    like.getPostTitle().equals(postLikeRequest.getPostTitle()))
                return true;
        }
        return false;
    }
}
