package grupo6.control2.controllers;

import grupo6.control2.entities.NotificationEntity;
import grupo6.control2.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notifications")
@CrossOrigin("*")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/")
    public NotificationEntity createNotification(@RequestBody NotificationEntity notification) {
        return notificationService.saveNotification(notification);
    }

    @GetMapping("/getAll")
    public List<NotificationEntity> getNotifications() {
        return notificationService.getNotifications();
    }

    @GetMapping("/{id}")
    public NotificationEntity getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

    @PutMapping("/")
    public NotificationEntity updateNotification(@RequestBody NotificationEntity notification) {
        return notificationService.updateNotification(notification);
    }

    @DeleteMapping("/{id}")
    public boolean deleteNotification(@PathVariable Long id) throws Exception {
        return notificationService.deleteNotification(id);
    }
}
