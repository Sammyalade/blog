package africa.semicolon.blog.dtos.request.postRequest;

import lombok.Data;

import java.time.LocalDate;
@Data
public class PostCreationRequest {

    private String title;
    private String content;
}
