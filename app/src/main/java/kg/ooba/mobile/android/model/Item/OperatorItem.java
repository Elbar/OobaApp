package kg.ooba.mobile.android.model.Item;

/**
 * Created by aizhan on 9/9/17.
 */

public class OperatorItem {
    private int operIcon;
    private String operName;

    OperatorItem(int operIcon, String operName) {
        this.operIcon = operIcon;
        this.operName = operName;
    }

    public String getOperName() {
        return operName;
    }

    public int getOperIcon() {
        return operIcon;
    }
}
