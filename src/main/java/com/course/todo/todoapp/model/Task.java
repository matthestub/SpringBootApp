package com.course.todo.todoapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/*
Implementacją JPA jest np. Hibernate, który wiąże kod w klasach javy z zawartością bazy danych którą obsługuje.
 */

@Entity // oznacza że w DB będzie table która odzwierciela tą klasę
@Table(name = "tasks") // bardziej szczegółowe oznaczenie klasy która ma być tabelą w bazie wraz z podaniem jej nazwy
public class Task {

    /*
    Ponieważ oznaczyłem tą klasę adnotacją Entity to pola które są zawarte w tej klasie zostaną zmapowane na kolumny w tabeli.
    Ale mogę wykorzystać kolejne adnotacje by np. po swojemu oznaczać kolumny w tabeli opisujące dane pola
    tej klasy.
    Ale jedno pola w każdej encji musi być zaznaczone jako ID.
    Adnotacja:
    @Column(name = "....")
    Jest możliwość aby adnotować nazwy kolumn na getterach, ale zasada jest taka że albo adnotujemy na polach albo na getterach, nie można
    tego mieszać.
     */

    public Task() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Task description must not be null or empty") //adnotacja do validowania
    private String description;
    private boolean done;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
