package com.muran.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by wxz on 16/10/17.
 */
@Entity
@Table(name = "TB_COLUMN_config")
@XmlRootElement
@DynamicInsert(true)
@DynamicUpdate(true)
public class ColumnConfig implements java.io.Serializable{

    private static final long serialVersionUID = 1L;

    private Long autoId;
    private String columnKey;
    private String columnName;
    private Boolean showReadNum;

    @Id
    @GeneratedValue
    @Column(name = "autoId", unique = true, nullable = false)
    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    @Column(length = 100)
    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    @Column(length = 100)
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Boolean getShowReadNum() {
        return showReadNum;
    }

    public void setShowReadNum(Boolean showReadNum) {
        this.showReadNum = showReadNum;
    }

    public ColumnConfig() {
    }

    public ColumnConfig(Long autoId, String columnKey, String columnName, Boolean showReadNum) {
        this.autoId = autoId;
        this.columnKey = columnKey;
        this.columnName = columnName;
        this.showReadNum = showReadNum;
    }
}
