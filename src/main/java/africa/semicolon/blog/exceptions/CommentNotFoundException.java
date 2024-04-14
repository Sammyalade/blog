package africa.semicolon.blog.exceptions;

public class CommentNotFoundException extends BlogException{
    public CommentNotFoundException(String message) {
        super(message);
    }
}
