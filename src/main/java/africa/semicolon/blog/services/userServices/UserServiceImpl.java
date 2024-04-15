package africa.semicolon.blog.services.userServices;

import africa.semicolon.blog.datas.models.Like;
import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.datas.repositories.UserRepository;
import africa.semicolon.blog.dtos.requests.*;
import africa.semicolon.blog.dtos.responses.PostCreationResponse;
import africa.semicolon.blog.dtos.responses.UserRegistrationResponse;
import africa.semicolon.blog.exceptions.UserLockedException;
import africa.semicolon.blog.exceptions.UserNotFoundException;
import africa.semicolon.blog.services.likeServices.LikeService;
import africa.semicolon.blog.services.postServices.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static africa.semicolon.blog.utils.Mapper.map;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private LikeService likeService;


    @Override
    public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user = map(userRegistrationRequest);
        userRepository.save(user);
        return map(user);
    }

    @Override
    public User searchUserById(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("User not found");
    }


    @Override
    public void loginUser(UserLoginRequest userLoginRequest) {
        User user = searchUserById(userLoginRequest.getUserId());
        if(user.getUsername().equals(userLoginRequest.getUsername())) user.setLocked(false);
    }

    @Override
    public void logoutUser(String id) {
        User user = searchUserById(id);
        user.setLocked(true);
    }

    @Override
    public UserUpdateResponse updateUser(UserUpdateRequest userUpdateRequest) {
        User user = searchUserById(userUpdateRequest.getUserId());
        if(!user.isLocked()) {
            user.setUsername(userUpdateRequest.getUserName());
            userRepository.save(user);
            return map(userUpdateRequest, user.getUsername());
        }
        throw new UserLockedException("User not logged in. Please login and try again");
    }




    @Override
    public void deleteUser(String id) {
        User user = searchUserById(id);
        if(!user.isLocked()) {
            userRepository.delete(user);
        } else throw new UserLockedException("User not logged in. Please login and try again");
    }


    @Override
    public PostCreationResponse createPost(PostCreationRequest postCreationRequest) {
        User user = searchUserById(postCreationRequest.getUserId());
        if(!user.isLocked()) {
            Post post = postService.makePost(postCreationRequest);
            return map(post, user.getId());
        }
        throw new UserLockedException("User not logged in. Please login and try again");
    }

    @Override
    public void likePost(PostLikeRequest postLikeRequest){
        User user = searchUserById(postLikeRequest.getUserId());
        if (!user.isLocked()) {
            Post post = postService.findPostById(postLikeRequest.getPostId());
            Like like = likeService.makeLike(postLikeRequest);
            post.getLikes().add(like);
        }
        else throw new UserLockedException("User not locked. Please login and try again");
    }


}
