package africa.semicolon.blog.services;

import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.datas.repositories.LikeRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostLikeRequest;
import africa.semicolon.blog.exceptions.LikeAlreadyExistException;
import africa.semicolon.blog.services.likeServices.LikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void testThatOneUserCannotLikeAPostTwice() {
        User user = new User();
        Post post = new Post();
        post.setTitle("Title");
        PostLikeRequest postLikeRequest1 = new PostLikeRequest();
        postLikeRequest1.setLikedBy(user);
        postLikeRequest1.setPostTitle(post.getTitle());
        likeService.makeLike(postLikeRequest1);
        PostLikeRequest postLikeRequest2 = new PostLikeRequest();
        postLikeRequest2.setLikedBy(user);
        postLikeRequest2.setPostTitle(post.getTitle());
        assertThrows(LikeAlreadyExistException.class, ()->likeService.makeLike(postLikeRequest2));
        assertThat(likeRepository.count(), is(1L));
    }

}
