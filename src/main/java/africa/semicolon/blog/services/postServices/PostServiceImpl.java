package africa.semicolon.blog.services.postServices;

import africa.semicolon.blog.datas.models.Comment;
import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.datas.models.View;
import africa.semicolon.blog.datas.repositories.PostRepository;
import africa.semicolon.blog.dtos.request.postRequest.*;
import africa.semicolon.blog.exceptions.EmptyStringException;
import africa.semicolon.blog.exceptions.PostNotFoundException;
import africa.semicolon.blog.exceptions.UniqueTitleException;
import africa.semicolon.blog.services.commentServices.CommentService;
import africa.semicolon.blog.services.likeServices.LikeService;
import africa.semicolon.blog.services.viewServices.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static africa.semicolon.blog.utils.Mapper.map;
import static africa.semicolon.blog.utils.PostUtility.checkIfIsNull;
import static africa.semicolon.blog.utils.PostUtility.findPost;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ViewService viewService;
    @Autowired
    private LikeService likeService;

    @Override
    public void makePost(PostCreationRequest postCreationRequest) {
        Post post = map(postCreationRequest);
        validateForEmptyString(post);
        checkForUniqueTitle(postCreationRequest);
        postRepository.save(post);
    }



    @Override
    public void deletePost(String title) {
        Post post = findPost(title, postRepository.findAll());
        checkIfPostIsNotNull(post);
        postRepository.delete(post);
    }

    @Override
    public void updatePost(PostUpdateRequest postUpdateRequest) {
        Post post = map(postUpdateRequest);
        validateForEmptyString(post);
        Post postToBeUpdated = findPost(post.getTitle(), postRepository.findAll());
        checkIfPostIsNotNull(postToBeUpdated);
        postRepository.delete(postToBeUpdated);
        postRepository.save(post);
    }

    @Override
    public void viewPost(PostViewRequest postViewRequest) {
        View view = viewService.viewPost(postViewRequest);
        Post post = findPost(view.getPostTitle(), postRepository.findAll());
        checkIfPostIsNotNull(post);
        checkIfIsNull(post);
        post.getViews().add(view);
    }



    @Override
    public void makeComment(PostCommentRequest postCommentRequest) {
        Comment  comment = commentService.makeComment(postCommentRequest);
        Post post =  findPost(comment.getPostTitle(), postRepository.findAll());
        checkIfPostIsNotNull(post);
        post.getComments().add(comment);
    }

    @Override
    public void makeLike(PostLikeRequest postLikeRequest) {
        likeService.makeLike(postLikeRequest);
    }








    private static void checkIfPostIsNotNull(Post post) {
        if(post == null) throw new PostNotFoundException("Post not found");
    }

    private static void validateForEmptyString(Post post) {
        if(post.getTitle().isEmpty() || post.getContent().isEmpty()) throw new EmptyStringException("Title or Content");
    }

    private void checkForUniqueTitle(PostCreationRequest postCreationRequest) {
        if (findPost(postCreationRequest.getTitle(), postRepository.findAll()) != null) throw new UniqueTitleException("Title has been used. Tiyle has to be unique");
    }
}
