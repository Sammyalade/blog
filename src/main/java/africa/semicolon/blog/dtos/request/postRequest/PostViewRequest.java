package africa.semicolon.blog.dtos.request.postRequest;

import africa.semicolon.blog.datas.models.User;
import lombok.Data;

@Data
public class PostViewRequest {
    private String postTitle;
    private User viewer;
}
