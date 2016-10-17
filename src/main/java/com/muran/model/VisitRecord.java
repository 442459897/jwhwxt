package com.muran.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by wxz on 16/10/17.
 */
@Entity
@Table(name = "TB_VISIT_RECORD")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class VisitRecord implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long autoId;
    private String columnKey;
    private Long articleId;
    private String title;
    private String openId;
    private String name;
    private Date visitTime=new Date();

    @Id
    @GeneratedValue
    @Column(name = "autoId", unique = true, nullable = false)
    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    @Column(name="columnKey",length = 50)
    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public Long getArticleId() {
        return articleId;
    }


    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    @Column(length = 100)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(length = 100)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Column(length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public VisitRecord(Long autoId, String columnKey, Long articleId, String title, String openId, String name, Date visitTime) {
        this.autoId = autoId;
        this.columnKey = columnKey;
        this.articleId = articleId;
        this.title = title;
        this.openId = openId;
        this.name = name;
        this.visitTime = visitTime;
    }

    public VisitRecord() {
    }
}
