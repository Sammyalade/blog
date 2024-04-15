package africa.semicolon.blog.dtos.requests;

import lombok.Data;

@Data
public class CommentEditRequest {

    private String commentId;
    private String commentBody;
}
