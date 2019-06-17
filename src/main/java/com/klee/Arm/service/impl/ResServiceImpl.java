package com.klee.Arm.service.impl;

import com.github.pagehelper.PageHelper;
import com.klee.Arm.dao.ResDao;
import com.klee.Arm.pojo.Res;
import com.klee.Arm.pojo.ResType;
import com.klee.Arm.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
@Service
public class ResServiceImpl implements ResService {
    @Autowired
    private ResDao resDao;
    @Override
    public List<ResType> findResType() {
        return resDao.findResType();
    }

    @Override
    public List<Res> findRes(Integer pageNum,Map map) {
        PageHelper.startPage(pageNum,3);
        List<Res> resList = resDao.findRes(map);
        return resList;
    }
}
