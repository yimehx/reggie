package com.mpl.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mpl.reggie.dto.DishDto;
import com.mpl.reggie.entity.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);

    //根据id删除
    public void removeWithStatus(List<Long> ids);

    //修改状态
    public void updateDishStatusById(Integer status, List<Long> ids);
}
