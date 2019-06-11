package com.klee.Arm.dao;

import com.klee.Arm.pojo.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp>  findEmp();
    Emp xREmp(int eid);
    int editEmp(Emp emp);
    int addAdm(Emp emp);
}
