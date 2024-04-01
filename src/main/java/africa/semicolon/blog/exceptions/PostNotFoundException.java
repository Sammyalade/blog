package africa.semicolon.blog.exceptions;

public class PostNotFoundException extends BlogException{
    public PostNotFoundException(String message) {
        super(message);
    }
}
