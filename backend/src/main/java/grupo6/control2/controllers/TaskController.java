package grupo6.control2.controllers;

import grupo6.control2.entities.TaskEntity;
import grupo6.control2.responses.AddTaskResponse;
import grupo6.control2.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/tasks/save")
    public AddTaskResponse createTask(@RequestBody TaskEntity task) {
        return taskService.saveTask(task);

    }

    @GetMapping("/tasks/getAll")
    public List<TaskEntity> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public TaskEntity getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    /*
    @PutMapping("/tasks/update")
    public TaskEntity updateTask(@RequestBody TaskEntity task) {
        return taskService.updateTask(task);
    }
*/
    @DeleteMapping("/tasks/{id}")
    public boolean deleteTask(@PathVariable Long id) throws Exception {
        return taskService.deleteTask(id);
    }

    @GetMapping("/{status}")
    public List<TaskEntity> getTasksByStatus(@PathVariable String status) {
        return taskService.getTasksByStatus(status);
    }

    @GetMapping("/{keyword}")
    public List<TaskEntity> getTasksByKeyword(@PathVariable String keyword) {
        return taskService.getTasksByKeyword(keyword);
    }
}
