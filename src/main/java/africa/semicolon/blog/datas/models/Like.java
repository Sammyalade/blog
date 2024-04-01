package africa.semicolon.blog.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Likes")
public class Like {
    @Id
    private String id;
    private User likedBy;
    private String postTitle;
}
