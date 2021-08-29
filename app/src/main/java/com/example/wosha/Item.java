package com.example.wosha;

import org.json.JSONObject;

public class Item {

    String ItemName;
    Double ItemPrice;
    int ItemImage;
    int CartQuantity = 0;

    public Item( String itemName, Double itemPrice, int itemImage){
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemImage = itemImage;
    }

    public String getJsonObject(){
        JSONObject cartItems = new JSONObject();
        try
        {
            cartItems.put("ItemName", ItemName);
            cartItems.put("ItemPrice", ItemPrice);
            cartItems.put("ItemImage", ItemImage);
            cartItems.put("CartQuantity", CartQuantity);
        }
        catch (Exception e){}
        return cartItems.toString();
    }
}
