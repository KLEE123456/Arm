package com.klee.Arm.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class Details implements Serializable {
    private int did;

    private int pid;

    private  int stid;

    private  int tid;

    private int rid;

    private  int eid;

    private  String title;

    private  double price;

    private  int amount;

    private  String photo;

    private int rflag;
}
