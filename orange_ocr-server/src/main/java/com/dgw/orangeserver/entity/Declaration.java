package com.dgw.orangeserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: orange_ocr-parent
 * @description: 公告实体
 * @author: Mr.Dai
 * @create: 2020-04-07 18:42
 **/
@Entity
@Table(name = "declaration")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Declaration implements Serializable {

    private static final long serialVersionUID = 4967006908141911451L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;
    private String articleName;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String articleContent;
    private String articleAuthors;

    @Temporal(TemporalType.DATE)
    private Date articleInputDate;

    private Integer isTop;

    @Transient
    private Integer isEnable;
}
