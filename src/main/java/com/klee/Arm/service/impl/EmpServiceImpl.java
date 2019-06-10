package com.klee.Arm.service.impl;

import com.klee.Arm.dao.EmpDao;
import com.klee.Arm.pojo.Emp;
import com.klee.Arm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> findEmp() {
        return empDao.findEmp();
    }

    @Override
    public Emp XREmp(int eid) {
        return empDao.XREmp(eid);
    }


}
