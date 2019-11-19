package com.team.service;

import com.github.pagehelper.PageInfo;
import com.team.entity.TbContent;
import com.team.util.PageUtil;

import java.util.List;

public interface TbContentService {
    PageInfo<TbContent> getTbContent(PageUtil pageUtil);

    int addTbContent(TbContent tbContent);

    List<TbContent> getTb();
}
