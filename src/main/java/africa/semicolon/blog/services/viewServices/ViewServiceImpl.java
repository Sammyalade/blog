package africa.semicolon.blog.services.viewServices;

import africa.semicolon.blog.datas.models.View;
import africa.semicolon.blog.datas.repositories.ViewRepository;
import africa.semicolon.blog.dtos.request.postRequest.PostViewRequest;
import africa.semicolon.blog.exceptions.ViewAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semicolon.blog.utils.Mapper.map;
import static africa.semicolon.blog.utils.ViewUtility.checkIfViewAlreadyExist;

@Service("ViewServiceImpl")
public class ViewServiceImpl implements ViewService{


    @Autowired
    private ViewRepository viewRepository;
    @Override
    public View viewPost(PostViewRequest postViewRequest) {
        View view = map(postViewRequest);
        if(!checkIfViewAlreadyExist(postViewRequest, viewRepository.findAll())){
            viewRepository.save(view);
            return view;
        }
        throw new ViewAlreadyExistException("View already exist");
    }


}
