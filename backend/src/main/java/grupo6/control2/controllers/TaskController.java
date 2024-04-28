package grupo6.control2.controllers;

import grupo6.control2.entities.TaskEntity;
import grupo6.control2.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/")
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/getAll")
    public List<TaskEntity> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/")
    public TaskEntity updateTask(@RequestBody TaskEntity task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTask(@PathVariable Long id) throws Exception {
        return taskService.deleteTask(id);
    }
}
