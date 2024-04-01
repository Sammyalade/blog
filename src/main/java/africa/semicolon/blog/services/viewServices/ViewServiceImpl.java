package africa.semicolon.blog.services.viewServices;

import africa.semicolon.blog.datas.models.View;
import africa.semicolon.blog.datas.repositories.ViewRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostViewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semicolon.blog.utils.Mapper.map;

@Service("ViewServiceImpl")
public class ViewServiceImpl implements ViewService{


    @Autowired
    private ViewRepository viewRepository;
    @Override
    public void viewPost(PostViewRequest postViewRequest) {
        View view = map(postViewRequest);
        viewRepository.save(view);
    }
}
