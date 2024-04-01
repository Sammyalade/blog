package africa.semicolon.blog.services;

import africa.semicolon.blog.datas.repositories.PostRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostCreationRequest;
import africa.semicolon.blog.exceptions.EmptyStringException;
import africa.semicolon.blog.exceptions.PostNotFoundException;
import africa.semicolon.blog.exceptions.UniqueTitleException;
import africa.semicolon.blog.services.postServices.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    public void setUp() {
        postRepository.deleteAll();
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

}
