package com.kg.vista.ooba.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aizhan on 9/9/17.
 */

public class NotificationListDTO {

    @SerializedName("unread_notifications_count")
    @Expose
    private Integer unreadNotificationsCount;
    @SerializedName("notifications")
    @Expose
    private List<NotificationItemDTO> notifications = null;

    public Integer getUnreadNotificationsCount() {
        return unreadNotificationsCount;
    }

    public void setUnreadNotificationsCount(Integer unreadNotificationsCount) {
        this.unreadNotificationsCount = unreadNotificationsCount;
    }

    public List<NotificationItemDTO> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationItemDTO> notifications) {
        this.notifications = notifications;
    }
}
