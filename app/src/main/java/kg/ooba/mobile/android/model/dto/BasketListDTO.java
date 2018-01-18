package kg.ooba.mobile.android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aizhan on 9/5/17.
 */

public class BasketListDTO {
    @SerializedName("cart")
    @Expose
    private List<CartDTO> cart = null;
    @SerializedName("address")
    @Expose
    private List<AddressDTO> address = null;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("shipping")
    @Expose
    private List<ShippingDTO> shipping = null;

    public List<CartDTO> getCart() {
        return cart;
    }

    public void setCart(List<CartDTO> cart) {
        this.cart = cart;
    }

    public List<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ShippingDTO> getShipping() {
        return shipping;
    }

    public void setShipping(List<ShippingDTO> shipping) {
        this.shipping = shipping;
    }
}
