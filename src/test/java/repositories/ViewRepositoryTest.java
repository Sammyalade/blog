package repositories;


import africa.semicolon.blog.Main;
import africa.semicolon.blog.datas.models.View;
import africa.semicolon.blog.datas.repositories.ViewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes = Main.class)
public class ViewRepositoryTest  {

    @Autowired
    private ViewRepository viewRepository;

    @BeforeEach
    public void setUp() {
        viewRepository.deleteAll();
    }

    @Test
    public void testViewRepository() {
        View view = new View();
        viewRepository.save(view);
        assertThat(viewRepository.count(), is(1L));
    }
}
