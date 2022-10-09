package com.mpl.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mpl.reggie.dto.SetmealDto;
import com.mpl.reggie.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    /**
     * 新增套餐，同时需要保存套餐与菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐同时删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);

    /**
     * 根据套餐id更改状态
     * @param status
     * @param ids
     */
    public void updateSetmelStatusById(Integer status,List<Long> ids);

}
