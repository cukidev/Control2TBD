package grupo6.control2.repositories;

import grupo6.control2.entities.TaskEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {

    @Query(value = "SELECT * FROM tasks ", nativeQuery = true)
    List<TaskEntity> getAll();

    @Query(value = "SELECT * FROM tasks WHERE tasks.id=:id ", nativeQuery = true)
    TaskEntity getTaskById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO tasks (title, description, due_date, status, user_id) VALUES (:title, :description, :due_date, :status, :user_id)", nativeQuery = true)
    TaskEntity saveTaskCustom(@Param("title") String title, @Param("description") String description, @Param("due_date") Date due_date, @Param("status") String status, @Param("user_id") Long user_id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tasks WHERE id = :id", nativeQuery = true)
    void deleteByIdCustom(@Param("id") Long id);

    @Query(value = "SELECT * FROM tasks WHERE status = :status", nativeQuery = true)
    List<TaskEntity> getTasksByStatus(@Param("status") String status);

    //TA MEDIA DEFECTUOSA
    @Query(value = "SELECT * FROM tasks WHERE title " +
            "LIKE %:keyword% OR " +
            "description LIKE %:keyword%", nativeQuery = true)
    List<TaskEntity> searchTasksByKeyword(@Param("keyword") String keyword);


}
