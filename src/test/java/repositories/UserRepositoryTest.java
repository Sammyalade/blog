package repositories;

import africa.semicolon.blog.Main;
import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.datas.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@SpringBootTest(classes = Main.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void testUserRepository(){
        User testUser = new User();
        userRepository.save(testUser);
        assertThat(userRepository.count(), is(1L));

    }
}
