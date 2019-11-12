package com.example.comservice;



import com.team.service.TbContentCategoryService;
import com.team.util.PageUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComServiceApplicationTests {
    @Autowired
    private TbContentCategoryService tbContentCategoryService;

    @Test
    void contextLoads() {
        PageUtil page=new PageUtil();
        page.setPage(1);
        page.setPage(4);
        System.out.println("total:"+tbContentCategoryService.getTb(page).getTotal());

    }

}
