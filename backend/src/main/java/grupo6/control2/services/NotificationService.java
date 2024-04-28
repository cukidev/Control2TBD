package grupo6.control2.services;
import grupo6.control2.entities.NotificationEntity;
import grupo6.control2.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public List<NotificationEntity> getNotifications() {
        return notificationRepository.getAll();
    }

    public NotificationEntity getNotificationById(Long id) {
        return notificationRepository.getNotificationById(id);
    }

    public NotificationEntity saveNotification(NotificationEntity notification) {
        return notificationRepository.saveNotificationCustom(notification.getTitle(),notification.getMessage(),notification.getIdUser(),notification.getIdTask(),notification.getNotificationDate());
    }

    public NotificationEntity updateNotification(NotificationEntity notification) {
        return notificationRepository.saveNotificationCustom(notification.getTitle(),notification.getMessage(),notification.getIdUser(),notification.getIdTask(),notification.getNotificationDate());
    }

    public boolean deleteNotification(Long id) throws Exception {
        try {
            notificationRepository.deleteByIdCustom(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
