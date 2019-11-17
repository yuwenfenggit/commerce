package com.example.managerweb.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.team.entity.TbContent;
import com.team.service.TbContentService;
import com.team.util.PageUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TbContentController {
    @Reference(interfaceClass = TbContentService.class)
    private TbContentService tbContentService;

    @RequestMapping("/showContent")
    public Map<String,Object> showContent(PageUtil pageUtil){
        PageInfo<TbContent> tbContent = tbContentService.getTbContent(pageUtil);
        Map<String,Object> map =  new HashMap<>();
        map.put("rows",tbContent.getList());
        map.put("total",tbContent.getTotal());
        return map;
    }
}
