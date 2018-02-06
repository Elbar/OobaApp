package com.kg.vista.ooba.model.Item;

import com.kg.vista.ooba.model.dto.BalanceDTO;

/**
 * Created by aizhan on 9/4/17.
 */

public class BalanceItem {
    private String date;
    private String purpose;
    private String amount;

    BalanceItem(String date, String purpose, String amount) {
        this.date = date;
        this.purpose = purpose;
        this.amount = amount;
    }

    public static BalanceItem of(BalanceDTO item) {
        return new BalanceItem(item.getDate(), item.getPurpose(), item.getAmount());
    }

    public String getDate() {
        return date;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getAmount() {
        return amount;
    }
}
