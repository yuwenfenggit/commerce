package com.example.comservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.entity.TbContentCategory;
import com.team.entity.TbContentCategoryExample;
import com.team.mapper.TbContentCategoryMapper;
import com.team.service.TbContentCategoryService;
import com.team.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = TbContentCategoryService.class)
@Component
public class TbContentCategoryServiceImpl implements TbContentCategoryService {
    @Autowired(required = false)
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public PageInfo<TbContentCategory> getTb(PageUtil page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        TbContentCategoryExample example = new TbContentCategoryExample();
        List<TbContentCategory> list = tbContentCategoryMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    @Override
    public List<TbContentCategory> getTB() {
        TbContentCategoryExample example = new TbContentCategoryExample();
        return tbContentCategoryMapper.selectByExample(example);
    }
}
