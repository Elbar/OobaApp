package kg.ooba.mobile.android.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aizhan on 9/4/17.
 */

public class PaymentsItemDTO {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("order_number")
    @Expose
    private String orderNumber;
    @SerializedName("invoice_number")
    @Expose
    private String invoiceNumber;
    @SerializedName("amount")
    @Expose
    private Integer amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
