package com.suyash.todo.Repository;

import com.suyash.todo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    // custom JPQL query to find user by username
    // SELECT * FROM user WHERE username=?
    @Query("SELECT u FROM User u WHERE u.username=?1") // JPQL
    User findByUsername(String username);

}
