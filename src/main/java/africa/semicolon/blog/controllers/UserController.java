package africa.semicolon.blog.controllers;

import africa.semicolon.blog.dtos.requests.UserLoginRequest;
import africa.semicolon.blog.dtos.requests.UserRegistrationRequest;
import africa.semicolon.blog.dtos.requests.UserUpdateRequest;
import africa.semicolon.blog.dtos.requests.UserUpdateResponse;
import africa.semicolon.blog.dtos.responses.UserApiResponse;
import africa.semicolon.blog.dtos.responses.UserRegistrationResponse;
import africa.semicolon.blog.exceptions.BlogException;
import africa.semicolon.blog.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/blog")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        try{
            UserRegistrationResponse userRegistrationResponse = userService.registerUser(userRegistrationRequest);
            return new ResponseEntity<>(new UserApiResponse(true, userRegistrationResponse), CREATED);
        } catch (BlogException e){
            return new ResponseEntity<>(new UserApiResponse(false , e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest userUpdateRequest) {
        try {
            UserUpdateResponse userUpdateResponse = userService.updateUser(userUpdateRequest);
            return new ResponseEntity<>(new UserApiResponse(true, userUpdateResponse), CREATED);
        } catch (BlogException e){
            return new ResponseEntity<>(new UserApiResponse(false , e.getMessage()), BAD_REQUEST);
        }
    }

    @PatchMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
        try{
            userService.deleteUser(userId);
            return new ResponseEntity<>(new UserApiResponse(true, "User Deleted Successfully"), HttpStatus.OK);
        } catch (BlogException e){
            return new ResponseEntity<>(new UserApiResponse(false , e.getMessage()), BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
        try {
            userService.loginUser(userLoginRequest);
            return new ResponseEntity<>(new UserApiResponse(true, "Login successful"), CREATED);
        } catch (BlogException e){
            return new ResponseEntity<>(new UserApiResponse(false , e.getMessage()), BAD_REQUEST);
        }
    }

    @PatchMapping("/logout/{userId}")
    public ResponseEntity<?> logout(@PathVariable("userId") String userId) {
        try{
            userService.logoutUser(userId);
            return new ResponseEntity<>(new UserApiResponse(true, "Logout successful"), CREATED);
        } catch (BlogException e){
            return new ResponseEntity<>(new UserApiResponse(false , e.getMessage()), BAD_REQUEST);
        }
    }
}

