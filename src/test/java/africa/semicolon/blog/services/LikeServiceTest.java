package africa.semicolon.blog.services;

import africa.semicolon.blog.Main;
import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.datas.repositories.LikeRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;
import africa.semicolon.blog.services.likeServices.LikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class LikeServiceTest {

    @Autowired
    private LikeService likeService;

    @Autowired
    private LikeRepository likeRepository;

    @BeforeEach
    public void setUp() {
        likeRepository.deleteAll();
    }

    @Test
    public void likeServiceTest() {
        PostLikeRequest postLikeRequest = new PostLikeRequest();
        User user = new User();
        postLikeRequest.setLikedBy(user);
        postLikeRequest.setPostTitle("Title");
        likeService.makeLike(postLikeRequest);
        assertThat(likeRepository.count(), is(1L));
    }
}
