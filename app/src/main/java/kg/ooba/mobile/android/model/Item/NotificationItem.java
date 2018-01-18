package kg.ooba.mobile.android.model.Item;

import kg.ooba.mobile.android.model.dto.AddressDTO;
import kg.ooba.mobile.android.model.dto.NotificationItemDTO;

/**
 * Created by aizhan on 9/9/17.
 */

public class NotificationItem {
    private String id;
    private String userId;
    private String text;
    private String addTime;
    private String isShow;
    private String status;

    public NotificationItem(String id, String userId, String text, String addTime, String isShow,
                            String status) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.addTime = addTime;
        this.isShow = isShow;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public String getAddTime() {
        return addTime;
    }

    public String getIsShow() {
        return isShow;
    }

    public String getStatus() {
        return status;
    }

    public static NotificationItem of(NotificationItemDTO item) {
        return new NotificationItem(item.getId(), item.getUserId(), item.getText(), item.getAddTime(),
                item.getIsShow(), item.getStatus());
    }
}
