package kg.ooba.mobile.android.model;

/**
 * Created by Begali on 9/5/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("label_cn")
    @Expose
    private String labelCn;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("format_price")
    @Expose
    private String formatPrice;
    @SerializedName("id")
    @Expose
    private String id;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelCn() {
        return labelCn;
    }

    public void setLabelCn(String labelCn) {
        this.labelCn = labelCn;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFormatPrice() {
        return formatPrice;
    }

    public void setFormatPrice(String formatPrice) {
        this.formatPrice = formatPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}