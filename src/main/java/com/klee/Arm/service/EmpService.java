package com.klee.Arm.service;

import com.klee.Arm.pojo.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAdm(Integer pageNum);
    Emp xRAdm(int eid);
    int editAdm(Emp emp);
    int addAdm(Emp emp);
    List<Emp> findEmp(Integer pageNum);
    int addEmp(Emp emp);
    int delEmp(int eid);
    int findEid();
}
