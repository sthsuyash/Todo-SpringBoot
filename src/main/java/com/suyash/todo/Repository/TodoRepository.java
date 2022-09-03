package com.suyash.todo.Repository;

import com.suyash.todo.Entity.Todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
