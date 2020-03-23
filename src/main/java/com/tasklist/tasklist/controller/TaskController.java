package com.tasklist.tasklist.controller;

import com.tasklist.tasklist.model.Task;
import com.tasklist.tasklist.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/admin/task")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskController {

    private final TaskService taskService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/createOrUpdate", consumes = "application/json", produces = "application/json")
    public Task createOrUpdate(@RequestBody Task task){
        return taskService.save(task);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/getTask", consumes = "application/json", produces = "application/json")
    public Task getTask(@RequestBody  Long id) {
        return taskService.get(id);
    }

//    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping(path = "/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Task>> list(Pageable pageable) {
        return new ResponseEntity<>(taskService.list(pageable), HttpStatus.OK);
    }
}
