package africa.semicolon.blog.utils;

import africa.semicolon.blog.datas.models.Post;

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
}
