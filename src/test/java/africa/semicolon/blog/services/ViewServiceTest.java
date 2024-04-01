package africa.semicolon.blog.services;

import africa.semicolon.blog.datas.repositories.ViewRepository;
import africa.semicolon.blog.services.viewServices.ViewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ViewServiceTest {

    @Autowired
    private ViewService viewService;
    @Autowired
    private ViewRepository viewRepository;

    @BeforeEach
    public void setUp() {
        viewRepository.deleteAll();
    }

    @Test
    public void viewServiceTest() {

    }
}
