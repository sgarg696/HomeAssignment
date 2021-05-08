package com.albanero.homeassignment.Entity;

import javax.persistence.*;

@Entity
@Table(name = "columninfo")
public class ColumnInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "columnname")
    private String columnName;

    @Column(name = "columntype")
    private String columnType;

    @ManyToOne
    @JoinColumn(name = "tableinfo", nullable = false)
    private TableInfo tableInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public TableInfo getTableInfo() {
        return tableInfo;
    }

    public void setTableInfo(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
    }
}
