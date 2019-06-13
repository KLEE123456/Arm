package com.klee.Arm.service.impl;

import com.klee.Arm.dao.ResDao;
import com.klee.Arm.pojo.Res;
import com.klee.Arm.pojo.ResType;
import com.klee.Arm.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResServiceImpl implements ResService {
    @Autowired
    private ResDao resDao;
    @Override
    public List<ResType> findResType() {
        return resDao.findResType();
    }

    @Override
    public List<Res> findRes() {
        return resDao.findRes();
    }
}
