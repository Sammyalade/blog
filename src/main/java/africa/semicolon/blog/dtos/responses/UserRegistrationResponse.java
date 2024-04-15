package africa.semicolon.blog.dtos.responses;

import lombok.Data;

@Data
public class UserRegistrationResponse {

    private String userId;
    private String email;
    private String username;
}
