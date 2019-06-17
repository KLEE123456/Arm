package com.klee.Arm.dao;

import com.klee.Arm.pojo.Details;

import java.util.List;

public interface DetailsDao {
    List<Details> findDetail();
    int addDetail(Details details);
    int delDetails(int[] buf);
}
