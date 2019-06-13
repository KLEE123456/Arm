package com.klee.Arm.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
public class ResType implements Serializable {
    private int tid;

    private  String title;

}
