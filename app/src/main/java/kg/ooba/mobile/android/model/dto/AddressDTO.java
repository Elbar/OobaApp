package kg.ooba.mobile.android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/2/17.
 */

public class AddressDTO {
    @SerializedName("address_id")
    @Expose
    private String address_id;

    @SerializedName("consignee")
    @Expose
    private String consignee;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("tel")
    @Expose
    private String tel;

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    private void setTel(String tel) {
        this.tel = tel;
    }
}
