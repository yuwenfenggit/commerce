package com.example.protocalweb.Controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.team.entity.TbContent;
import com.team.service.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProController {
    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;

    @RequestMapping("/showTb")
    public String showTb(Model model){
        List<TbContent> tb = tbContentService.getTb();
        model.addAttribute("contents",tb);
        return "Index.jsp";
    }
}
