package kg.ooba.mobile.android.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainRequest {

    @SerializedName("brand")
    @Expose
    private List<Brand> brand = null;
    @SerializedName("shop")
    @Expose
    private List<Shop> shop = null;
    @SerializedName("collection")
    @Expose
    private List<Collection> collection = null;
    @SerializedName("groupon")
    @Expose
    private List<Groupon> groupon = null;
    @SerializedName("groupon_count")
    @Expose
    private Integer grouponCount;
    @SerializedName("category")
    @Expose
    private List<Object> category = null;
    @SerializedName("help")
    @Expose
    private List<Object> help = null;

    public List<Brand> getBrand() {
        return brand;
    }

    public void setBrand(List<Brand> brand) {
        this.brand = brand;
    }

    public List<Shop> getShop() {
        return shop;
    }

    public void setShop(List<Shop> shop) {
        this.shop = shop;
    }

    public List<Collection> getCollection() {
        return collection;
    }

    public void setCollection(List<Collection> collection) {
        this.collection = collection;
    }

    public List<Groupon> getGroupon() {
        return groupon;
    }

    public void setGroupon(List<Groupon> groupon) {
        this.groupon = groupon;
    }

    public Integer getGrouponCount() {
        return grouponCount;
    }

    public void setGrouponCount(Integer grouponCount) {
        this.grouponCount = grouponCount;
    }

    public List<Object> getCategory() {
        return category;
    }

    public void setCategory(List<Object> category) {
        this.category = category;
    }

    public List<Object> getHelp() {
        return help;
    }

    public void setHelp(List<Object> help) {
        this.help = help;
    }

}
