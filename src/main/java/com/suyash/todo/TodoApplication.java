package com.suyash.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//public class TodoApplication implements CommandLineRunner {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private TodoRepository todoRepository;

@SpringBootApplication
public class TodoApplication {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User();
//
//        user.setId(1L);
//        user.setUsername("suyash");
//        user.setPassword("suyash");
//
//        Todo todo = new Todo();
//        todo.setId(1L);
//        todo.setTitle("New Todo");
//        todo.setDescription("This is a description");
//
//        user.getTodoList().add(todo);
//
//        todoRepository.save(todo);
//        userRepository.save(user);
//    }

}
