package com.xbjy.service.impl;

import com.xbjy.dao.MenuDao;
import com.xbjy.dao.impl.MenuDaoImpl;
import com.xbjy.domain.Menu;
import com.xbjy.service.MenuService;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 12:23
 */
public class MenuServiceImpl implements MenuService {

    private MenuDao menuDao = new MenuDaoImpl();

    @Override
    public List<Menu> listMenu() {
        return menuDao.findAllMenuItem();
    }
}
