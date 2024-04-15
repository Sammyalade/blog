package africa.semicolon.blog.services;

import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.datas.repositories.ViewRepository;
import africa.semicolon.blog.dtos.requests.PostViewRequest;
import africa.semicolon.blog.exceptions.ViewAlreadyExistException;
import africa.semicolon.blog.services.viewServices.ViewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ViewServiceTest {

    @Autowired
    private ViewService viewService;
    @Autowired
    private ViewRepository viewRepository;

    @BeforeEach
    public void setUp() {
        viewRepository.deleteAll();
    }

    @Test
    public void viewServiceTest() {
        User user = new User();
        PostViewRequest postViewRequest = new PostViewRequest();
        postViewRequest.setPostTitle("Title");
        postViewRequest.setViewer(user);
        viewService.viewPost(postViewRequest);
        assertThat(viewRepository.count(), is(1L));
    }

    @Test
    public void testThatUserCannotViewAPostTwice(){
        User user = new User();
        PostViewRequest postViewRequest = new PostViewRequest();
        Post post = new Post();
        post.setTitle("Title");
        postViewRequest.setPostTitle(post.getTitle());
        postViewRequest.setViewer(user);
        viewService.viewPost(postViewRequest);
        PostViewRequest postViewRequest2 = new PostViewRequest();
        postViewRequest2.setPostTitle(post.getTitle());
        postViewRequest2.setViewer(user);
        assertThrows(ViewAlreadyExistException.class, ()-> viewService.viewPost(postViewRequest2));
        assertThat(viewRepository.count(), is(1L));
    }
}
