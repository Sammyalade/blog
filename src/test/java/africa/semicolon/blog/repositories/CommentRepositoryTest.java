package africa.semicolon.blog.repositories;

import africa.semicolon.blog.Main;
import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.datas.repositories.CommentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = Main.class)
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;

    @BeforeEach
    public void setUp() {
        commentRepository.deleteAll();
    }
    @Test
    public void testCommentRepository() {
        Comment comment = new Comment();
        commentRepository.save(comment);
        assertThat(commentRepository.count(), is(1L));
    }
}
