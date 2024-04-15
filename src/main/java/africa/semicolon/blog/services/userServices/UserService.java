package africa.semicolon.blog.services.userServices;

import africa.semicolon.blog.datas.models.User;
import africa.semicolon.blog.dtos.requests.*;
import africa.semicolon.blog.dtos.responses.PostCreationResponse;
import africa.semicolon.blog.dtos.responses.UserRegistrationResponse;

public interface UserService {
    UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);

    User searchUserById(String userId);

    void loginUser(UserLoginRequest userLoginRequest);

    void logoutUser(String id);

    UserUpdateResponse updateUser(UserUpdateRequest userUpdateRequest);

    void deleteUser(String id);

    PostCreationResponse createPost(PostCreationRequest postCreationRequest);

    void likePost(PostLikeRequest postLikeRequest);
}
