package com.xbjy.dao;

import com.xbjy.domain.Menu;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 11:16
 */
public interface MenuDao {

    public abstract List<Menu> findAllMenuItem();



}
