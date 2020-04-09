package com.dgw.orangeserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ocrtexts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcrTexts implements Serializable {

    private static final long serialVersionUID = -7536613142331362542L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long textId;
    private String imagePath;
    private String applyPeople;
    private String textName;
    @Temporal(TemporalType.DATE)
    private Date tagInputDate;

    private Date accessDate;

    public OcrTexts(String tagName) {
        this.textName = tagName;
    }
}
