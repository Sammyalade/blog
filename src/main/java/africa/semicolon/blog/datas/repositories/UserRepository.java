package africa.semicolon.blog.datas.repositories;


import africa.semicolon.blog.datas.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
