package africa.semicolon.blog.exceptions;

public class UserNotFoundException extends BlogException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
