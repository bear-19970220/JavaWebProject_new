package com.xbjy.service.impl;

import com.xbjy.dao.DeptDao;
import com.xbjy.dao.impl.DeptDaoImpl;
import com.xbjy.domain.Dept;
import com.xbjy.service.DeptService;

import java.util.List;

/**
 * @author 杨智球
 * @company 东方标准
 * @date 2019/12/2 19:12
 */
public class DeptServiceImpl implements DeptService {

    private DeptDao deptDao = new DeptDaoImpl();

    @Override
    public List<Dept> listDept() {
        return deptDao.findAllDept();
    }
}
