package kg.ooba.mobile.android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/2/17.
 */

public class UpdateAddressDTO {
    @SerializedName("sql")
    @Expose
    private int sql;

    public int getSql(){return sql;}

    private void setSql(int sql){this.sql=sql;}
}
