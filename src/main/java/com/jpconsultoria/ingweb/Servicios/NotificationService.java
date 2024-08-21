package com.jpconsultoria.ingweb.Servicios;

import com.jpconsultoria.ingweb.Entidades.Notification;
import java.util.List;

public interface NotificationService {
    List<Notification> getAllNotifications();
    Notification getNotificationById(Long id);
    Notification createNotification(Notification notification);
    Notification updateNotification(Long id, Notification notification);
    void deleteNotification(Long id);
}