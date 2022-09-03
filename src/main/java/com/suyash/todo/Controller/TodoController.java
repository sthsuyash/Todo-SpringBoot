package com.suyash.todo.Controller;

import com.suyash.todo.DTO.TodoDTO;
import com.suyash.todo.Entity.Todo;
import com.suyash.todo.Entity.User;
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
    @PostMapping("/user/{userId}")
    public ResponseEntity<User> addTodoForUser(@PathVariable Long userId, @RequestBody TodoDTO todoDTO) {
        return new ResponseEntity<User>(todoService.addTodoForUser(userId, todoDTO), HttpStatus.CREATED);
    }

    // get todo by id
    @GetMapping("/{todoId}")
    public Todo getTodoById(@PathVariable Long todoId) {
        return todoService.getTodoById(todoId);
    }

    // toggle specific todo by id
    @PostMapping("/{todosId}")
    public ResponseEntity<Todo> toggleTodosCompleted(@PathVariable Long todosId) {
        return new ResponseEntity<Todo>(todoService.toggleTodosCompleted(todosId), HttpStatus.OK);
    }

    // edit specific todo by id
    @PutMapping("{userId}/edit/{todosId}")
    public ResponseEntity<Todo> editTodosById(@PathVariable Long userId, @PathVariable Long todoId, @RequestBody TodoDTO todoDTO) {
        return new ResponseEntity<Todo>(todoService.editTodosById(userId, todoId, todoDTO), HttpStatus.OK);
    }

    // delete todo by id
    @DeleteMapping("{userId}/delete/{todoId}")
    public ResponseEntity<Todo> deleteTodoById(@PathVariable Long userId, @PathVariable Long todoId) {
        return new ResponseEntity<Todo>(todoService.deleteTodoById(userId, todoId), HttpStatus.OK);
    }

}
