package com.klee.Arm.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
@Data
public class Res implements Serializable {
    private  int rid;

    private  int tid;

    private int stid;

    private String title;

    private double price;

    private Date indate;

    private String  photo;

    private int rflag;

    private  int amount;
}
