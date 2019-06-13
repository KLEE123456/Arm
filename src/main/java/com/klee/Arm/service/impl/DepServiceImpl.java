package com.klee.Arm.service.impl;

import com.klee.Arm.dao.DepDao;
import com.klee.Arm.pojo.Dep;
import com.klee.Arm.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepServiceImpl implements DepService {
    @Autowired
    private DepDao depDao;
    @Override
    public List<Dep> findDep() {
        return depDao.findDep();
    }
}
