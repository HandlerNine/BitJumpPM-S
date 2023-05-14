package com.example.bitjumppms.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TableItem {
    private int tableItemId;//表项id
    private String beginTime;//开始时间
    private String endTime;//结束时间
    private String ownerId;//负责人id
    private String ownerName;//负责人名字
    private boolean isFinish;//是否完成
    private String finishTime;//结束时间
    private String description;//描述

    public static TableItem test1(){
        TableItem tableItem = new TableItem();
        tableItem.tableItemId = 1;
        tableItem.beginTime = "2022.12";
        tableItem.finishTime = "2023.4";
        return tableItem;
    }

    public static TableItem test2(){
        TableItem tableItem = new TableItem();
        tableItem.tableItemId = 12;
        tableItem.beginTime = "2021.1";
        tableItem.finishTime = "2023.8";
        return tableItem;
    }

}
