package africa.semicolon.blog.dtos.requests;

import africa.semicolon.blog.datas.models.User;
import lombok.Data;

@Data
public class PostLikeRemoveRequest extends PostLikeRequest {

    private User likedBy;
    private String postId;

}
