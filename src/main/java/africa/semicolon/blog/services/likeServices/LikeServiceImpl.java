package africa.semicolon.blog.services.likeServices;

import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.datas.repositories.LikeRepository;
import africa.semicolon.blog.dtos.requests.PostLikeRemoveRequest;
import africa.semicolon.blog.dtos.requests.PostLikeRequest;
import africa.semicolon.blog.exceptions.LikeAlreadyExistException;
import africa.semicolon.blog.exceptions.LikeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void removeLike(PostLikeRemoveRequest postLikeRemoveRequest) {
        likeRepository.delete(findLike(postLikeRemoveRequest));
    }

    private Like findLike(PostLikeRemoveRequest postLikeRemoveRequest) {
        for(Like like: likeRepository.findAll()) {
            if (like.getPostTitle().equals(postLikeRemoveRequest.getPostId())) return like;
        }
        throw new LikeNotFoundException("Like not found");
    }


}
