//package com.course.todo.todocourse.noMoreUsedClasses;
//
//import com.course.todo.todocourse.model.Task;
//import com.course.todo.todocourse.model.TaskRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.rest.webmvc.RepositoryRestController;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
////powiązanie Repository z Controllerem, dostanie się do controllera w Spring MVC
//@RepositoryRestController
//class TaskControllerOld {
//
//    private static final Logger logger = LoggerFactory.getLogger(TaskControllerOld.class); //na klasie TaskController tworzony jest logger
//    private final TaskRepository repository;
//
//    TaskControllerOld(TaskRepository repository) {
//        this.repository = repository;
//    }
//
//    /*
//    abstrakcja która reprezentuje odpowiedz, sprawi że odpowiedz będzie przesyłana w notacji JSON czyli bez metadanych, zamiast w HATEOAS
//
//        ResponseEntity<List<Task>> readAllTasks() {
//        logger.warn("Exposing all the tasks!");
//        return ResponseEntity.ok(repository.findAll());
//    }
//
//    //to także działa:
//        List<Task> readAllTasks() {
//        logger.warn("Exposing all the tasks!");
//        return repository.findAll();
//    }
//    */
//
////    @RequestMapping(method = RequestMethod.GET, path = "/tasks")
//    @GetMapping(value = "/tasks", params = {"!sort", "!page", "!size"}) //skorzystanie z tego mappingu gdy podczas requestów nie dodaje wyszczególnionych parametrów, w innym przypadku wykona się GET przy użyciu RRR, chyba
//    //że przeciążę tą metodą jak poniżej
//    ResponseEntity<?> readAllTasks() {
//        logger.warn("Exposing all the task!");
//        return ResponseEntity.ok(repository.findAll());
//    }
//
//    /*
//    @GetMapping("/tasks")
//    ResponseEntity<?> readAllTasks(Pageable pageable) {
//        logger.info("Paging, sorting, sizing by TaskController");
//        return ResponseEntity.ok(repository.findAll(pageable));
//    }
//
//    powyższa metoda zwróci wiele metadanych dotyczących stronnicowania, jeśli chce aby zwróciła tylko konkretne elementy to mogę ją zcustomizować
//
//     */
//
//    @GetMapping("/tasks")
//    ResponseEntity<List<Task>> readAllTasks(Pageable pageable) {
//        logger.info("Reading all tasks.");
//        return ResponseEntity.ok(repository.findAll(pageable).getContent());
//    }
//}
