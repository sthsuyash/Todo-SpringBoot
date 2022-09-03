package com.suyash.todo.Repository;

import com.suyash.todo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // custom JPQL query to find user by username
    User findByUsername(String username);

}
