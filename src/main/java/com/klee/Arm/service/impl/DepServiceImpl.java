package com.klee.Arm.service.impl;

import com.klee.Arm.dao.DepDao;
import com.klee.Arm.pojo.Dep;
import com.klee.Arm.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
@Service
public class DepServiceImpl implements DepService {
    @Autowired
    private DepDao depDao;
    @Override
    public List<Dep> findDep() {
        return depDao.findDep();
    }
}
