package africa.semicolon.blog.services;

import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.datas.repositories.CommentRepository;
import africa.semicolon.blog.dtos.requests.CommentEditRequest;
import africa.semicolon.blog.dtos.requests.PostCommentRequest;
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

    @Test
    public void deleteCommentTest(){
        PostCommentRequest postCommentRequest = new PostCommentRequest();
        postCommentRequest.setPostTitle("Test Title");
        postCommentRequest.setCommentBody("My comment");
        User user = new User();
        postCommentRequest.setViewer(user);
        Comment comment = commentService.makeComment(postCommentRequest);
        commentService.deleteComment(comment.getId());
        assertThat(commentRepository.count(), is(0L));
    }

    @Test
    public void editCommentTest(){
        PostCommentRequest postCommentRequest = new PostCommentRequest();
        postCommentRequest.setPostTitle("Test Title");
        postCommentRequest.setCommentBody("My comment");
        User user = new User();
        postCommentRequest.setViewer(user);
        Comment comment = commentService.makeComment(postCommentRequest);
        CommentEditRequest commentEditRequest = new CommentEditRequest();
        commentEditRequest.setCommentBody("NewComment");
        commentEditRequest.setCommentId(comment.getId());
        commentService.editComment(commentEditRequest);
        assertThat(commentRepository.findCommentBy(comment).getCommentBody(), is("NewComment"));
    }

}
