package africa.semicolon.blog.services;

import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.datas.repositories.ViewRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostViewRequest;
import africa.semicolon.blog.services.viewServices.ViewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
}
