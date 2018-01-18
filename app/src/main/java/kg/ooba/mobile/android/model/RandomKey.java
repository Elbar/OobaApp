package kg.ooba.mobile.android.model;

/**
 * Created by Begali on 9/5/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomKey {

    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("price_cn")
    @Expose
    private String priceCn;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceCn() {
        return priceCn;
    }

    public void setPriceCn(String priceCn) {
        this.priceCn = priceCn;
    }

}
