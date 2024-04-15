package africa.semicolon.blog.dtos.requests;

import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String username;
    private String email;
}
