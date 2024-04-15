package africa.semicolon.blog.services.viewServices;

import africa.semicolon.blog.datas.models.View;
import africa.semicolon.blog.dtos.requests.PostViewRequest;

public interface ViewService {
    View viewPost(PostViewRequest postViewRequest);
}
