package com.team.mapper;

import com.team.entity.TbOrderShipping;
import com.team.entity.TbOrderShippingExample;
import java.util.List;

public interface TbOrderShippingMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(TbOrderShipping record);

    int insertSelective(TbOrderShipping record);

    List<TbOrderShipping> selectByExample(TbOrderShippingExample example);

    TbOrderShipping selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(TbOrderShipping record);

    int updateByPrimaryKey(TbOrderShipping record);
}