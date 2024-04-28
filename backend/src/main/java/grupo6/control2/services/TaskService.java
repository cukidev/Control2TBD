package grupo6.control2.services;
import grupo6.control2.entities.TaskEntity;
import grupo6.control2.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<TaskEntity> getTasks() {
        return taskRepository.getAll();
    }

    public TaskEntity getTaskById(Long id) {
        return taskRepository.getTaskById(id);
    }

    public TaskEntity saveTask(TaskEntity task) {

        return taskRepository.saveTaskCustom(task.getTitle(),task.getDescription(),task.getDue_date(),task.getStatus(),task.getUserId());
    }

    public TaskEntity updateTask(TaskEntity task) {

        return taskRepository.saveTaskCustom(task.getTitle(),task.getDescription(),task.getDue_date(),task.getStatus(),task.getUserId());
    }

    public boolean deleteTask(Long id) throws Exception {
        try {
            taskRepository.deleteByIdCustom(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
