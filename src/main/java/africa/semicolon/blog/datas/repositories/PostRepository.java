package africa.semicolon.blog.datas.repositories;

import africa.semicolon.blog.datas.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
