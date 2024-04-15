package africa.semicolon.blog.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Users")
public class User {

    @Id
    private String id;
    private String username;
    private String email;
    private boolean isLocked;
    @DBRef
    private List<Post> posts;
}
