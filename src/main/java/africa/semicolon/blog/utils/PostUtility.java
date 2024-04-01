package africa.semicolon.blog.utils;

import africa.semicolon.blog.datas.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostUtility {

    public static Post findPost(String title, List<Post> posts) {
        for(Post post : posts) {
            if(post.getTitle().equals(title)) {
                return post;
            }
        }
        return null;
    }

    public static void checkIfIsNull(Post post) {
        if(post.getViews() == null){
            post.setViews(new ArrayList<>());
        }
    }
}
