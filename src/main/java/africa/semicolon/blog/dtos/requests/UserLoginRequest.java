package africa.semicolon.blog.dtos.requests;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String username;
    private String userId;
}
