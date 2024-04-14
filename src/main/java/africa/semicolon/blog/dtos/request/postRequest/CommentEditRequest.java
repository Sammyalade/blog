package africa.semicolon.blog.dtos.request.postRequest;

import lombok.Data;

@Data
public class CommentEditRequest {

    private String commentId;
    private String commentBody;
}
