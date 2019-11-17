package com.team.service;

import com.github.pagehelper.PageInfo;
import com.team.entity.TbContent;
import com.team.util.PageUtil;

public interface TbContentService {
    PageInfo<TbContent> getTbContent(PageUtil pageUtil);
}
