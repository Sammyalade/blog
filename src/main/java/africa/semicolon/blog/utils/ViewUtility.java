package africa.semicolon.blog.utils;

import africa.semicolon.blog.datas.models.View;
import africa.semicolon.blog.dtos.request.postRequest.PostViewRequest;

import java.util.List;

public class ViewUtility {

    public static boolean checkIfViewAlreadyExist(PostViewRequest postViewRequest, List<View> viewList) {
        for(View view: viewList){
            if(view.getViewer().equals(postViewRequest.getViewer())
                    && view.getPostTitle().equals(postViewRequest.getPostTitle())){
                return true;
            }
        }
        return false;
    }
}
