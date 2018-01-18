package kg.ooba.mobile.android.model.Item;

/**
 * Created by aizhan on 9/5/17.
 */

public class MailForwardingItem {
    private String trekNumber;
    private String goodType;

    public MailForwardingItem(String trekNumber, String goodType) {
        this.trekNumber = trekNumber;
        this.goodType = goodType;
    }

    public String getTrekNumber() {
        return trekNumber;
    }

    public String getGoodType() {
        return goodType;
    }
}
