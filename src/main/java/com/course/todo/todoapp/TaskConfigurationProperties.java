package com.course.todo.todoapp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration //to czyni klasę beanem
@ConfigurationProperties(prefix = "task") //to nie czyni z tej klasy beana springowego
public class TaskConfigurationProperties {

    private Template template;


    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }


    @ConfigurationProperties(prefix = "temp")
    public static class Template {

        private boolean allowMultipleTasks;
        public boolean isAllowMultipleTasks() {
            return allowMultipleTasks;
        }

        public void setAllowMultipleTasks(boolean allowMultipleTasks) {
            this.allowMultipleTasks = allowMultipleTasks;
        }
    }

}
