package com.klee.Arm.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
@Data
public class Dep implements Serializable {
    private int did;

    private String title;

    private int sflag;
}
