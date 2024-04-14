package africa.semicolon.blog.dtos.request.postRequest;

import africa.semicolon.blog.datas.models.User;
import lombok.Data;

@Data
public class PostCommentRequest {
    private String commentBody;
    private User viewer;
    private String postTitle;
}
