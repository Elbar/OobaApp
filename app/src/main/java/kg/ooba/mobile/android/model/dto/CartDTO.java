package kg.ooba.mobile.android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aizhan on 9/5/17.
 */

public class CartDTO {
    @SerializedName("seller")
    @Expose
    private String seller;
    @SerializedName("nick_url")
    @Expose
    private String nickUrl;
    @SerializedName("goods")
    @Expose
    private List<GoodItemDTO> goods = null;

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getNickUrl() {
        return nickUrl;
    }

    public void setNickUrl(String nickUrl) {
        this.nickUrl = nickUrl;
    }

    public List<GoodItemDTO> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodItemDTO> goods) {
        this.goods = goods;
    }

}
