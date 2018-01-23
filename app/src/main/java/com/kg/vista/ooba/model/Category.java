package com.kg.vista.ooba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {

@SerializedName("cat_id")
@Expose
private String catId;
@SerializedName("cat_name")
@Expose
private String catName;
@SerializedName("parent_id")
@Expose
private String parentId;
@SerializedName("is_show")
@Expose
private String isShow;
@SerializedName("child")
@Expose
private List<List<Child>> child = null;

public String getCatId() {
return catId;
}

public void setCatId(String catId) {
this.catId = catId;
}

public String getCatName() {
return catName;
}

public void setCatName(String catName) {
this.catName = catName;
}

public String getParentId() {
return parentId;
}

public void setParentId(String parentId) {
this.parentId = parentId;
}

public String getIsShow() {
return isShow;
}

public void setIsShow(String isShow) {
this.isShow = isShow;
}

public List<List<Child>> getChild() {
return child;
}

public void setChild(List<List<Child>> child) {
this.child = child;
}

}
