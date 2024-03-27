package repositories;

import africa.semicolon.blog.Main;
import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.datas.repositories.LikeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes = Main.class)
public class LikeRepositoryTest {

    @Autowired
    private LikeRepository likeRepository;

    @BeforeEach
    public void setUp() {
        likeRepository.deleteAll();
    }

    @Test
    public void testLikeRepository() {
        Like like = new Like();
        likeRepository.save(like);
        assertThat(likeRepository.count(), is(1L));
    }
}
