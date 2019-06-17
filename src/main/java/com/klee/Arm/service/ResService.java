package com.klee.Arm.service;

import com.klee.Arm.pojo.Res;
import com.klee.Arm.pojo.ResType;

import java.util.List;
import java.util.Map;

public interface ResService {
    List<ResType> findResType();
    List<Res> findRes(Integer pageNum,Map map);
}
