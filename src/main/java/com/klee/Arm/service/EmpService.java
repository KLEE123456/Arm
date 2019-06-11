package com.klee.Arm.service;

import com.klee.Arm.pojo.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findEmp();
    Emp xREmp(int eid);
    int editEmp(Emp emp);
    int addAdm(Emp emp);
}
