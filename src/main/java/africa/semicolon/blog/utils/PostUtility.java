package africa.semicolon.blog.utils;

import africa.semicolon.blog.datas.models.Comment;
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

    public static List<?> checkIfListIsNull(List<?> lists) {
        if(lists == null) lists = new ArrayList<>();

        return lists;
    }
}
