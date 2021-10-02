package com.autopartskinmel.model;

public class Item {
    private String itemName;
    private int itemImage;
    private String itemPrice;
    private String itemCondition;

    public Item(String itemName, int itemImage, String itemPrice, String itemCondition) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.itemPrice = itemPrice;
        this.itemCondition = itemCondition;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemImage() {
        return itemImage;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemCondition() {
        return itemCondition;
    }
}
