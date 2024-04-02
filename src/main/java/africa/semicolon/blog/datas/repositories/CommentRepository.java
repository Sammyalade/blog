package africa.semicolon.blog.datas.repositories;

import africa.semicolon.blog.datas.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {

    Comment findCommentBy(Comment comment);
}
