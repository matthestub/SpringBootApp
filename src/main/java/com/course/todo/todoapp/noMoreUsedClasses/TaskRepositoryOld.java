//package com.course.todo.todocourse.noMoreUsedClasses;
//
///*
//Repository - jest to wzorzec projektowy, bardzo zbliżony do DAO, czyli zapewniający metody dostędu do danych w DB, poprzez ukrywanie
//po jego metodami surowych kwerend, dzięki czemu user wykonuje tylko dane metody i nie musi wiedzieć jak poszczególne kwerendy
//są zbudowane. Repository jest poziom wyżej niż DAO ponieważ może korzystać z jego metod.
//API do działania na zbiorze danych.
// */
//
//import com.course.todo.todocourse.model.Task;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.core.annotation.RestResource;
//
//import java.util.List;
//
///*
//wskazanie springowi że tutaj znajdują się wszystkie metody do korzystania ze zbioru danych w projekcie. Udostępnienie metod typu CRUD
//które będą używane w projekcie.
//
//RestRepository robi wszystko by móc pracować na HATEOAS, czyli wszelkich dodatkowych metadanych projektu.
//
//Rozszerzając JpaRepository podaję <Task, Integer>. Integer dotyczy typu klucza głównego natomiast jest to klasa obiektów na której Repository ma pracować. Podana klasa obiektów określa także pewną część URL, ponieważ Spring
//wnioskuje sobie ze jeśli obiekty to Task, to kolekcja na której Reposotiry pracuje to "tasks", stąd adres localhost:8080/tasks
//Podajać w @RepositoryRestResource różne wartości mogę wprowadzać wiele modyfikacji, np. zmianę nazwy pod którą zasoby są dostępne.
// */
////@RepositoryRestResource(path = "todos", collectionResourceRel = "todos") - zmiana hipermedia, czyli nazwy koleckji i nazwy całego zasobu pod którym dostaję sie do wszystkich dodanych tasków
//@RepositoryRestResource
//public interface TaskRepositoryOld extends JpaRepository<Task, Integer> {
//
//    @Override
//    @RestResource(exported = false) //wykluczenie żądania DEL z dostępnych do wykonania na podpiętym zasobie
//    default void deleteById(Integer integer) {
//    }
//
//    @Override
//    @RestResource(exported = false)
//    default void delete(Task entity) {
//    }
//
////    @RestResource(path = "done", rel = "done") - używając segmentu "done" w linku, muszę poprzedzić go typem operacji czyli ..../search/done
////    List<Task> findByDoneIsTrue();
//
//    @RestResource(path = "done", rel = "done")
//    List<Task> findByDone(@Param("state") boolean done); // bardziej elastyczna metoda, w ktorej musze podać parametru
//}
