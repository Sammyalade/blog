package africa.semicolon.blog.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("Comments")
public class Comment {
    @Id
    private String id;
    private String commentBody;
    private LocalDate timeOfComment = LocalDate.now();
    private User viewer;
    private String postTitle;
}
