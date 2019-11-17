package com.example.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.team.entity.TbContentCategory;
import com.team.service.TbContentCategoryService;
import com.team.util.PageUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TbContentCategoryController {
    @Reference(interfaceClass = TbContentCategoryService.class)
    private TbContentCategoryService tbContentCategoryService;

    @RequestMapping("/getTb")
    public Map<String,Object> getTb(PageUtil page){
        PageInfo<TbContentCategory> tb = tbContentCategoryService.getTb(page);
        Map<String,Object> map = new HashMap<>();
        map.put("total",tb.getTotal());
        map.put("rows",tb.getList());
        return map;
    }

    @RequestMapping("/getTB")
    public List getTB(){
        List<TbContentCategory> tb = tbContentCategoryService.getTB();
        return tb;
    }
}
