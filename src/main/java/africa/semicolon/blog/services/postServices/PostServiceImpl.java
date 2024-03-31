package africa.semicolon.blog.services.postServices;

import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.datas.repositories.PostRepository;
import africa.semicolon.blog.dtos.request.postRequest.*;
import africa.semicolon.blog.exceptions.EmptyStringException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.blog.utils.Mapper.map;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void makePost(PostCreationRequest postCreationRequest) {
        Post post = map(postCreationRequest);
        validateForEmptyString(post);
        postRepository.save(post);
    }

    private static void validateForEmptyString(Post post) {
        if(post.getTitle().isEmpty() || post.getContent().isEmpty()) throw new EmptyStringException("Title or Content");
    }

    @Override
    public void deletePost(PostDeleteRequest postDeleteRequest) {

    }

    @Override
    public void updatePost(PostUpdateRequest postUpdateRequest) {

    }

    @Override
    public void makeComment(PostCommentRequest postLikeRequest) {

    }

    @Override
    public void makeLike(PostLikeRequest postLikeRequest) {

    }

    @Override
    public void viewPost(PostViewRequest postViewRequest) {

    }


}
