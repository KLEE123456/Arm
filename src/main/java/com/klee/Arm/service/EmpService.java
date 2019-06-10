package com.klee.Arm.service;

import com.klee.Arm.pojo.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findEmp();
    Emp XREmp(int eid);
}
