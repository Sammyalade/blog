package africa.semicolon.blog.dtos.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {

    private String userId;
    private String userName;
    private String email;
}
