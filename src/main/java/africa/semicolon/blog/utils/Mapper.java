package africa.semicolon.blog.utils;

import africa.semicolon.blog.datas.models.Post;
import africa.semicolon.blog.dtos.request.postRequest.PostCreationRequest;

public class Mapper {

    public static Post map(PostCreationRequest postCreationRequest) {
        Post post = new Post();
        post.setTitle(postCreationRequest.getTitle());
        post.setContent(postCreationRequest.getContent());
        return post;
    }
}
