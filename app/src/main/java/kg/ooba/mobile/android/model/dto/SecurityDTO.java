package kg.ooba.mobile.android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/2/17.
 */

public class SecurityDTO {

    @SerializedName("password_new")
    @Expose
    private int password_new;

    @SerializedName("password_retry")
    @Expose
    private int password_retry;

    @SerializedName("password_old")
    @Expose
    private int password_old;

    @SerializedName("sql")
    @Expose
    private int sql;

    public int getPassword_new() {
        return password_new;
    }

    public void setPassword_new(int password_new) {
        this.password_new = password_new;
    }

    public int getPassword_retry() {
        return password_retry;
    }

    public void setPassword_retry(int password_retry) {
        this.password_retry = password_retry;
    }

    public int getPassword_old() {
        return password_old;
    }

    public void setPassword_old(int password_old) {
        this.password_old = password_old;
    }

    public int getSql() {
        return sql;
    }

    private void setSql(int sql) {
        this.sql = sql;
    }
}
