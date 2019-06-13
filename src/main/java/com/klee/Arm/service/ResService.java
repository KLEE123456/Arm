package com.klee.Arm.service;

import com.klee.Arm.pojo.Res;
import com.klee.Arm.pojo.ResType;

import java.util.List;

public interface ResService {
    List<ResType> findResType();
    List<Res> findRes();
}
