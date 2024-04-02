package africa.semicolon.blog.dtos.request.postRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PostCommentEditRequest extends PostCommentRequest {

    public String comment;
    public String postTitle;
}
