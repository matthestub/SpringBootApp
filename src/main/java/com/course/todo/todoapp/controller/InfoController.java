package com.course.todo.todoapp.controller;

import com.course.todo.todoapp.TaskConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    private DataSourceProperties dataSourceProperties;
    private TaskConfigurationProperties myProp;

    InfoController(final DataSourceProperties dataSourceProperties, final TaskConfigurationProperties myProp) {
        this.dataSourceProperties = dataSourceProperties;
        this.myProp = myProp;
    }

    @GetMapping("/info/url")
    String url() {
        return dataSourceProperties.getUrl();
    }

    @GetMapping("/info/prop")
    boolean myProp() {
        return myProp.getTemplate().isAllowMultipleTasks();
    }

}
