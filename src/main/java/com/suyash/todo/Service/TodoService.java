package com.suyash.todo.Service;

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
    public boolean addTodoForUser(Long userId, Todo todo) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNameNotFoundException("User not found"));
        return user.getTodoList().add(todo);
    }

    // delete todo by id
    public Todo deleteTodoById(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));
        todoRepository.delete(todo);
        return todo;
    }

    public Todo editTodosById(Long todosId, Todo todo) {
        Todo todoToEdit = todoRepository.findById(todosId)
                .orElseThrow(() -> new TodoNotFoundException("Todo not found"));

        todoToEdit.setTitle(todo.getTitle());
        todoToEdit.setDescription(todo.getDescription());
        todoToEdit.setCompleted(todo.isCompleted());

        return todoRepository.save(todoToEdit);
    }
}
