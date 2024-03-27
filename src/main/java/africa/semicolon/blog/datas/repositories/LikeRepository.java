package africa.semicolon.blog.datas.repositories;

import africa.semicolon.blog.datas.models.Like;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikeRepository extends MongoRepository<Like, String> {
}
