package africa.semicolon.blog.services.viewServices;

import africa.semicolon.blog.datas.models.View;
import africa.semicolon.blog.dtos.request.postRequest.PostViewRequest;

public interface ViewService {
    View viewPost(PostViewRequest postViewRequest);
}
