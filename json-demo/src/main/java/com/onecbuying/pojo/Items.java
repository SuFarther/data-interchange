package com.onecbuying.pojo;

import java.io.Serializable;

/**
 * @author 苏东坡
 * @version 1.0
 * @ClassName Items
 * @company 公司
 * @Description TODO
 * @createTime 2022年08月11日 15:41:41
 */
public class Items implements Serializable {

    private String itemId;
    private String itemName;

    public Items() {
    }

    public Items(String itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
