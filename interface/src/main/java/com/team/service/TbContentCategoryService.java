package com.team.service;

import com.github.pagehelper.PageInfo;
import com.team.entity.TbContentCategory;
import com.team.util.PageUtil;

import java.util.List;


public interface TbContentCategoryService {
    PageInfo<TbContentCategory> getTb(PageUtil page);

    List<TbContentCategory> getTB();
}
