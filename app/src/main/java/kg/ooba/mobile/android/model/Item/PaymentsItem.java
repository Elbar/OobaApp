package kg.ooba.mobile.android.model.Item;

import kg.ooba.mobile.android.model.dto.PaymentsItemDTO;

/**
 * Created by aizhan on 9/4/17.
 */

public class PaymentsItem {
    private String date;
    private String purpose;
    private String invoiceNumber;
    private String orderNumber;
    private int amount;

    PaymentsItem(String date, String purpose, String invoiceNumber, String orderNumber, int amount) {
        this.date = date;
        this.purpose = purpose;
        this.invoiceNumber = invoiceNumber;
        this.orderNumber = orderNumber;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public int getAmount() {
        return amount;
    }

    public static PaymentsItem of(PaymentsItemDTO item) {
        return new PaymentsItem(item.getDate(), item.getPurpose(), item.getInvoiceNumber(), item.getOrderNumber(), item.getAmount());
    }
}
