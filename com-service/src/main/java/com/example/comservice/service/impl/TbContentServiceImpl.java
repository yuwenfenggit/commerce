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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;


@Service(interfaceClass = TbContentService.class)
@Component
public class TbContentServiceImpl implements TbContentService {
    @Autowired(required = false)
    private TbContentMapper tbContentMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public PageInfo<TbContent> getTbContent(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
        TbContentExample tbContentExample = new TbContentExample();
        List<TbContent> tbContents = tbContentMapper.selectByExample(tbContentExample);
        return new PageInfo<>(tbContents);
    }

    @Override
    public int addTbContent(TbContent tbContent) {
        return tbContentMapper.insertSelective(tbContent);
    }

    @Override
    public List<TbContent> getTb() {
        List<TbContent> list = null;
        ValueOperations<String,List<TbContent>> valueOperations = redisTemplate.opsForValue();
        if (!redisTemplate.hasKey("contentData")){
             list= tbContentMapper.selectByExample(new TbContentExample());
             valueOperations.set("contentData",list,2, TimeUnit.MINUTES);
            System.out.println("查询数据库，因为缓存中不存在....");
        }else {
            list=valueOperations.get("contentData"); //取数据
            System.out.println("从缓存中获取的数据，没有查询数据库");

        }
        return list;
    }
}
