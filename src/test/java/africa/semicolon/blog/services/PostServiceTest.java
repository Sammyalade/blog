package africa.semicolon.blog.services;

import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.datas.repositories.CommentRepository;
import africa.semicolon.blog.datas.repositories.PostRepository;
import africa.semicolon.blog.datas.repositories.ViewRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostCommentRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostCreationRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostUpdateRequest;
import africa.semicolon.blog.dtos.request.postRequest.PostViewRequest;
import africa.semicolon.blog.exceptions.EmptyStringException;
import africa.semicolon.blog.exceptions.PostNotFoundException;
import africa.semicolon.blog.exceptions.UniqueTitleException;
import africa.semicolon.blog.services.postServices.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static africa.semicolon.blog.utils.PostUtility.findPost;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ViewRepository viewRepository;

    @BeforeEach
    public void setUp() {
        postRepository.deleteAll();
        commentRepository.deleteAll();
        viewRepository.deleteAll();
    }
    @Test
    public void makePost_checkPostRepository_numberOfPostIsOneTest(){
        PostCreationRequest postCreationRequest = new PostCreationRequest();
        postCreationRequest.setTitle("Title");
        postCreationRequest.setContent("Content");
        postService.makePost(postCreationRequest);
        assertThat(postRepository.count(), is(1L));
    }

    @Test
    public void makePostWithEmptyStringTitle_throwsEmptyStringExceptionTest(){
        PostCreationRequest postCreationRequest = new PostCreationRequest();
        postCreationRequest.setTitle("");
        postCreationRequest.setContent("Content");
        assertThrows(EmptyStringException.class, ()-> postService.makePost(postCreationRequest));
    }

    @Test
    public void makePostWithEmptyStringContent_throwsEmptyStringExceptionTest(){
        PostCreationRequest postCreationRequest = new PostCreationRequest();
        postCreationRequest.setTitle("Title");
        postCreationRequest.setContent("");
        assertThrows(EmptyStringException.class, ()-> postService.makePost(postCreationRequest));
    }

    @Test
    public void makePost_deletePost_postIsDeletedTest(){
        PostCreationRequest postCreationRequest = new PostCreationRequest();
        postCreationRequest.setTitle("Title");
        postCreationRequest.setContent("Content");
        postService.makePost(postCreationRequest);
        postService.deletePost("Title");
        assertThat(postRepository.count(), is(0L));
    }

    @Test
    public void testThatPostTitleIsUnique(){
        PostCreationRequest postCreationRequest = new PostCreationRequest();
        postCreationRequest.setTitle("Title");
        postCreationRequest.setContent("Content");
        postService.makePost(postCreationRequest);
        assertThrows(UniqueTitleException.class, ()-> postService.makePost(postCreationRequest));
    }

    @Test
    public void deletePostWhenRepositoryIsEmptyTest(){
        assertThrows(PostNotFoundException.class,()-> postService.deletePost("Title"));
    }

    @Test
    public void makePost_updatePost_postIsUpdatedTest(){
        PostCreationRequest postCreationRequest = new PostCreationRequest();
        postCreationRequest.setTitle("Title");
        postCreationRequest.setContent("Content");
        postService.makePost(postCreationRequest);
        PostUpdateRequest postUpdateRequest = new PostUpdateRequest();
        postUpdateRequest.setTitle("Title");
        postUpdateRequest.setContent("New Content");
        postService.updatePost(postUpdateRequest);
        Post post = findPost("Title", postRepository.findAll());
        assertThat(post.getContent(), is("New Content"));
    }

    @Test
    public void tryToUpdateAPostThatIsNotAvailable_throwsPostNotFoundExceptionTest(){
        PostUpdateRequest postUpdateRequest = new PostUpdateRequest();
        postUpdateRequest.setTitle("Title");
        postUpdateRequest.setContent("New Content");
        assertThrows(PostNotFoundException.class, ()->postService.updatePost(postUpdateRequest));
    }

    @Test
    public void makePost_addComment_commentIsAddedTest(){
        PostCreationRequest postCreationRequest = new PostCreationRequest();
        postCreationRequest.setTitle("Title");
        postCreationRequest.setContent("Content");
        postService.makePost(postCreationRequest);
        User user = new User();
        PostCommentRequest postCommentRequest = new PostCommentRequest();
        postCommentRequest.setCommentBody("My comment");
        postCommentRequest.setViewer(user);
        postService.makeComment(postCommentRequest);
        assertThat(commentRepository.count(), is(1L));
    }

    @Test
    public void makePost_viewPost_numberOfPostViewIsOneTest(){
        PostCreationRequest postCreationRequest = new PostCreationRequest();
        postCreationRequest.setTitle("Title");
        postCreationRequest.setContent("Content");
        postService.makePost(postCreationRequest);
        PostViewRequest postViewRequest = new PostViewRequest();
        postViewRequest.setPostTitle("Title");
        User user = new User();
        postViewRequest.setViewer(user);
        postService.viewPost(postViewRequest);
        assertThat(viewRepository.count(), is(1L));
    }

    @Test
    public void

}
