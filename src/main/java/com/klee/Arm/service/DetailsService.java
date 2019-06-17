package com.klee.Arm.service;

import com.klee.Arm.pojo.Details;

import java.util.List;

public interface DetailsService {
    int addDetail(Details details);
    List<Details> findDetail();
    int delDetails(int[] buf);

}
