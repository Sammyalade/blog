package africa.semicolon.blog.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class UserApiResponse {

    boolean isSuccessful;
    Object userResponse;
}
