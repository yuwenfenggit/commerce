package com.example.comservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.entity.TbContent;
import com.team.entity.TbContentExample;
import com.team.mapper.TbContentMapper;
import com.team.service.TbContentService;
import com.team.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Service(interfaceClass = TbContentService.class)
@Component
public class TbContentServiceImpl implements TbContentService {
    @Autowired(required = false)
    private TbContentMapper tbContentMapper;

    @Override
    public PageInfo<TbContent> getTbContent(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        TbContentExample tbContentExample = new TbContentExample();
        List<TbContent> tbContents = tbContentMapper.selectByExample(tbContentExample);
        return new PageInfo<>(tbContents);
    }
}
