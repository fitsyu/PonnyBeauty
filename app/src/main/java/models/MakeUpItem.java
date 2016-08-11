package models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by fitsyu on 8/6/16.
 */
public class MakeUpItem {

    private String itemName;
    private String itemPrice;
    private String itemPicUrl;



    static public MakeUpItem fromJson(JSONObject json){
        MakeUpItem item = new MakeUpItem();

        try{
            item.itemName   = json.getString("itemName");
            item.itemPrice  = json.getString("itemPrice");
            item.itemPicUrl = json.getString("itemPicUrl");
        } catch (JSONException excpt){
            excpt.printStackTrace();
            return null;
        }

        return item;
    }

    static public ArrayList<MakeUpItem> fromJson(JSONArray jsons){
        ArrayList<MakeUpItem> items = new ArrayList<MakeUpItem>(jsons.length());
        JSONObject itemJson;

        for (int i = 0; i < jsons.length(); i++) {

            try {
                itemJson = jsons.getJSONObject(i);
            } catch ( Exception e) {
                e.printStackTrace();
                continue;
            }

            MakeUpItem item = MakeUpItem.fromJson(itemJson);
            if ( item != null ){
                items.add(item);
            }

        }
        return items;
    }

    public MakeUpItem(){}

    public MakeUpItem(String name, String price, String picUrl){
        itemName = name;
        itemPrice = price;
        itemPicUrl = picUrl;
    }

    public String getItemName(){
        return itemName;
    }

    public void  setItemName(String name){
        itemName = name;
    }

    public String getItemPrice(){
        return itemPrice;
    }

    public void setItemPrice(String price){
        itemPrice = price;
    }

    public String getItemPicUrl(){
        return itemPicUrl;
    }

    public void setItemPicUrl(String picUrl){
        itemPicUrl = picUrl;
    }

}
