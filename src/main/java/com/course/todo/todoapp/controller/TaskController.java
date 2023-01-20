package com.course.todo.todoapp.controller;

import com.course.todo.todoapp.model.Task;
import com.course.todo.todoapp.model.TaskRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;

    TaskController(final TaskRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks() {
        logger.warn("Exposing all the task!");
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable pageable) {
        logger.info("Reading all tasks.");
        return ResponseEntity.ok(repository.findAll(pageable).getContent());
    }

    //@requestBody - deserializacja na obiekt javovy tego 'body', które przyjdzie w requeście, mapowanie JSONA lub XMLA na obiekt javovy
    //@PathVariable - pozwala wziąść z adresu jakąś zmienną
    @RequestMapping(method = RequestMethod.PUT, path = "/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task taskToUpdate) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskToUpdate.setId(id);
        repository.save(taskToUpdate);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks/{id}")
    ResponseEntity<Task> readTask(@PathVariable int id) {
//        Optional<Task> returnedTask = repository.findById(id);
//        if (!returnedTask.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(returnedTask);
        return repository.findById(id).map(task -> ResponseEntity.ok(task)).orElse(ResponseEntity.notFound().build());
    }


    //zwracam nową reprezentację, czyli to co zostało zapisane
    @RequestMapping(method = RequestMethod.POST, path = "/tasks")
    ResponseEntity<Task> createTask(@RequestBody @Valid Task taskToPost) {
        Task result = repository.save(taskToPost);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);

    }

}
