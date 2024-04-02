package africa.semicolon.blog.utils;

import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;

import java.util.List;

public class LikeUtility {

    public static boolean checkIfUserLikeExist(PostLikeRequest postLikeRequest, List<Like> likeList) {
        for(Like like: likeList){
            if(like.getLikedBy().equals(postLikeRequest.getLikedBy()) &&
                    like.getPostTitle().equals(postLikeRequest.getPostTitle()))
                return true;
        }
        return false;
    }
}
