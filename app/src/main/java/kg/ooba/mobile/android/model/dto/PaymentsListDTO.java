package kg.ooba.mobile.android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aizhan on 9/4/17.
 */

public class PaymentsListDTO {
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("list")
    @Expose
    private List<PaymentsItemDTO> list = null;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<PaymentsItemDTO> getList() {
        return list;
    }

    public void setList(List<PaymentsItemDTO> list) {
        this.list = list;
    }
}
