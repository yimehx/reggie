package com.mpl.reggie.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mpl.reggie.common.CustomException;
import com.mpl.reggie.entity.Category;
import com.mpl.reggie.entity.Dish;
import com.mpl.reggie.entity.Setmeal;
import com.mpl.reggie.mapper.CategoryMapper;
import com.mpl.reggie.service.CategoryService;
import com.mpl.reggie.service.DishService;
import com.mpl.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    /**
     * 根据id删除分类，删除之前需要进行判断
     * @param id
     */
    @Override
    public void remove(Long id) {

        LambdaQueryWrapper<Dish> dishQueryWrapper = new LambdaQueryWrapper<>();
        //根据分类id添加查询条件
        dishQueryWrapper.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dishQueryWrapper);
        //查询当前分类是否关联了菜品，如果已经关联，跑出一个业务异常
        if (count1 > 0){
            //已经关联菜品，抛出一个业务异常
            throw new CustomException("当前分类项关联了菜品，不能删除");
        }

        LambdaQueryWrapper<Setmeal> setmealQueryWrapper = new LambdaQueryWrapper<>();
        //根据分类id添加查询条件
        setmealQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmealQueryWrapper);
        //查询当前分类是否关联了套餐，如果已经关联，抛出一个业务异常
        if (count2 > 0){
            //已经关联套餐，抛出一个业务异常
            throw new CustomException("当前分类项关联了套餐，不能删除");
        }
        //正常删除分类
        super.removeById(id);
    }
}
