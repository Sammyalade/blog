package africa.semicolon.blog.datas.repositories;

import africa.semicolon.blog.datas.models.View;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ViewRepository extends MongoRepository<View, String> {
}
