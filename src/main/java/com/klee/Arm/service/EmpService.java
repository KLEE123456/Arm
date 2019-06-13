package com.klee.Arm.service;

import com.klee.Arm.pojo.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAdm();
    Emp xRAdm(int eid);
    int editAdm(Emp emp);
    int addAdm(Emp emp);
    List<Emp> findEmp();
    int addEmp(Emp emp);
    int delEmp(int eid);
}
