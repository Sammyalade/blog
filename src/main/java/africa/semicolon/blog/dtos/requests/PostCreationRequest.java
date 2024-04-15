package africa.semicolon.blog.dtos.requests;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PostCreationRequest {

    private String title;
    private String content;
    private String userId;
}
