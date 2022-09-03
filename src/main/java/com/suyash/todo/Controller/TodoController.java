package com.suyash.todo.Controller;

import com.suyash.todo.Entity.Todo;
import com.suyash.todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // add todo for user
    @PostMapping("/{userId}")
    public ResponseEntity<Boolean> addTodoForUser(@PathVariable Long userId, @RequestBody Todo todo) {
        return new ResponseEntity<Boolean>(todoService.addTodoForUser(userId, todo), HttpStatus.CREATED);
    }

    // toggle specific todo by id
    @PostMapping("/{todosId}")
    public ResponseEntity<Todo> toggleTodosCompleted(@PathVariable Long todosId) {
        return new ResponseEntity<Todo>(todoService.toggleTodosCompleted(todosId), HttpStatus.OK);
    }

    // edit specific todo by id
    @PutMapping("/edit/{todosId}")
    public ResponseEntity<Todo> editTodosById(@PathVariable Long todosId, @RequestBody Todo todo) {
        return new ResponseEntity<Todo>(todoService.editTodosById(todosId, todo), HttpStatus.OK);
    }

    // delete todo by id
    @DeleteMapping("/delete/{todoId}")
    public ResponseEntity<Todo> deleteTodoById(@PathVariable Long todoId) {
        return new ResponseEntity<Todo>(todoService.deleteTodoById(todoId), HttpStatus.OK);
    }

}
