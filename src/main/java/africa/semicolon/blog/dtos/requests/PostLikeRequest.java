package africa.semicolon.blog.dtos.requests;

import africa.semicolon.blog.datas.models.User;
import lombok.Data;

@Data
public class PostLikeRequest {

    private User likedBy;
    private String postTitle;
}
