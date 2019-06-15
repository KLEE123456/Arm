package com.klee.Arm.service.impl;

import com.klee.Arm.dao.LoginDao;
import com.klee.Arm.pojo.Emp;
import com.klee.Arm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public Emp login(Emp emp) {
        return loginDao.login(emp);
    }
}
