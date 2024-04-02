package africa.semicolon.blog.services;

import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.datas.repositories.CommentRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostCommentEditRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostCommentRequest;
import africa.semicolon.blog.services.commentServices.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @BeforeEach
    public void setUp() {
        commentRepository.deleteAll();
    }


    @Test
    public void testAddComment() {
        PostCommentRequest postCommentRequest = new PostCommentRequest();
        postCommentRequest.setPostTitle("Test Title");
        postCommentRequest.setCommentBody("My comment");
        User user = new User();
        postCommentRequest.setViewer(user);
        commentService.makeComment(postCommentRequest);
        assertThat(commentRepository.count(), is(1L));
    }

}
