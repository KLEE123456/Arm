package com.klee.Arm.service.impl;

import com.github.pagehelper.PageHelper;
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
    public List<Emp> findAdm(Integer pageNum) {
        if (pageNum==null){
            pageNum=1;
        }
        PageHelper.startPage(pageNum,2);
        List<Emp> empList=empDao.findAdm();
        return empList;
    }

    @Override
    public Emp xRAdm(int eid) {
        return empDao.xRAdm(eid);
    }

    @Override
    public int editAdm(Emp emp) {
        return empDao.editAdm(emp);
    }

    @Override
    public int addAdm(Emp emp) {
        return empDao.addAdm(emp);
    }

    @Override
    public List<Emp> findEmp(Integer pageNum) {
        if (pageNum==null){
            pageNum=1;
        }
        PageHelper.startPage(pageNum,5);
        List<Emp> empList=empDao.findEmp();
        return empList;
    }

    @Override
    public int addEmp(Emp emp) {

        return empDao.addEmp(emp);
    }

    @Override
    public int delEmp(int eid) {
        return empDao.delEmp(eid);
    }


}
