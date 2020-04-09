package com.dgw.orangeviwer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: orange_ocr-parent
 * @description:
 * @author: Mr.Dai
 * @create: 2020-04-08 14:32
 **/
@Entity
@Table(name = "ocraccess")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcrAccess implements Serializable {


    private static final long serialVersionUID = -1431203058267940184L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date accessDate;
    private Integer accessCount;
}
