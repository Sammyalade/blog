package africa.semicolon.blog.dtos.requests;

import africa.semicolon.blog.datas.models.User;
import lombok.Data;

@Data
public class PostLikeRequest {

    private String userId;
    private String postId;
    private String postTitle;
}
