package africa.semicolon.blog.datas.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("Views")
public class View {

    @Id
    private String id;
    private User viewer;
    private String postTitle;
    private LocalDateTime viewTime;

}
