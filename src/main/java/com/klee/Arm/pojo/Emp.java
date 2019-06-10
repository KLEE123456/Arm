package com.klee.Arm.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class Emp implements Serializable {
    private int eid;

    private  int did;

    private  int lid;

    private  int heid;

    private  String name;

    private  String password;

    private  String phone;

    private  double salary;

    private  String  note;

    private  int  aflag;

    private  String  sex;

    private String photo;
}
