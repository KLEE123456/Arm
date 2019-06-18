package com.klee.Arm.service.impl;

import com.klee.Arm.dao.DetailsDao;
import com.klee.Arm.pojo.Details;
import com.klee.Arm.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
@Service
public class DetailsServceImpl implements DetailsService {
    @Autowired
    private DetailsDao detailsDao;
    @Override
    public int addDetail(Details details) {
        return detailsDao.addDetail(details);
    }

    @Override
    public List<Details> findDetail() {
        return detailsDao.findDetail();
    }

    @Override
    public int delDetails(int[] buf) {
        return detailsDao.delDetails(buf);
    }

    @Override
    public Details findDetById(int did) {
        return detailsDao.findDetById(did);
    }

    @Override
    public int editDetail(Details details) {
        return detailsDao.editDetail(details);
    }
}
