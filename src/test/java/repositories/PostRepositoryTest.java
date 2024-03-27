package repositories;

import africa.semicolon.blog.Main;
import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.datas.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = Main.class)
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @BeforeEach
    public void setUp() {
        postRepository.deleteAll();
    }

    @Test
    public void testPostRepository() {
        Post post = new Post();
        postRepository.save(post);
        assertThat(postRepository.count(), is(1L));
    }
}
