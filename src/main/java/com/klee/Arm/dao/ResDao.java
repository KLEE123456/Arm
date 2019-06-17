package com.klee.Arm.dao;

import com.klee.Arm.pojo.Res;
import com.klee.Arm.pojo.ResType;

import java.util.List;
import java.util.Map;

public interface ResDao {
    List<ResType> findResType();
    List<Res> findRes(Map map);
}
