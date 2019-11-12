package com.team.service;

import com.github.pagehelper.PageInfo;
import com.team.entity.TbContentCategory;
import com.team.util.PageUtil;


public interface TbContentCategoryService {
    PageInfo<TbContentCategory> getTb(PageUtil page);
}
