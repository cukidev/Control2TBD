package grupo6.control2.repositories;

import grupo6.control2.entities.NotificationEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity,Long> {
    @Query(value = "SELECT * FROM notifications ", nativeQuery = true)
    List<NotificationEntity> getAll();

    @Query(value = "SELECT * FROM notifications WHERE notifications.id=:id ", nativeQuery = true)
    NotificationEntity getNotificationById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO notifications (title, message, id_user, id_task, notification_date) VALUES (:title, :message,:id_user,:id_task,:notification_date)", nativeQuery = true)
    NotificationEntity saveNotificationCustom(@Param("title") String title, @Param("message") String message, @Param("id_user") Long id_user, @Param("id_task") Long id_task, @Param("notification_date") Date notification_date);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM notifications WHERE id = :id", nativeQuery = true)
    void deleteByIdCustom(@Param("id") Long id);
}
