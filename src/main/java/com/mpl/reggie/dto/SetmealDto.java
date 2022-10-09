package com.mpl.reggie.dto;

import com.mpl.reggie.entity.Setmeal;
import com.mpl.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;

    private String image;
}
