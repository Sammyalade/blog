package africa.semicolon.blog.dtos.request.postRequest;

import lombok.Data;

@Data
public class PostCommentEditRequest {

    public String comment;
    public String postTitle;
}
