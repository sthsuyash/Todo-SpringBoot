package com.suyash.todo.Service;

import com.suyash.todo.DTO.TodoDTO;
import com.suyash.todo.Entity.Todo;
import com.suyash.todo.Entity.User;
import com.suyash.todo.Exception.TodoNotFoundException;
import com.suyash.todo.Exception.UserNameNotFoundException;
import com.suyash.todo.Repository.TodoRepository;
import com.suyash.todo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    // toggle task completed
    public Todo toggleTodosCompleted(Long todosId) {
        Todo todo = todoRepository.findById(todosId)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }

    // add todo for user
    public User addTodoForUser(Long userId, TodoDTO todoDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNameNotFoundException("User not found"));

        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.isCompleted());

        user.getTodoList().add(todo);
        todoRepository.save(todo);
        return userRepository.save(user);
    }

    // delete todo by id
    public Todo deleteTodoById(Long userId, Long todoId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNameNotFoundException("User not found"));
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        user.getTodoList().remove(todo);

        todoRepository.delete(todo);
        return todo;
    }

    // edit todo by id
    public Todo editTodosById(Long todoId, TodoDTO todoDTO) {
        Todo todoToEdit = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());

        return todoRepository.save(todoToEdit);
    }

    // get todo by id
    public Todo getTodoById(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));
        return todo;
    }
}
