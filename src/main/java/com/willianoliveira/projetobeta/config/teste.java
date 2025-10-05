package com.willianoliveira.projetobeta.config;

import com.willianoliveira.projetobeta.entities.Category;
import com.willianoliveira.projetobeta.entities.Order;
import com.willianoliveira.projetobeta.entities.User;
import com.willianoliveira.projetobeta.repositories.CategoryRepository;
import com.willianoliveira.projetobeta.repositories.OrderRepository;
import com.willianoliveira.projetobeta.repositories.UserRepository;
import com.willianoliveira.projetobeta.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Profile("testPgsql")
@Configuration
public class teste implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CategoryRepository categoryRepository;

        @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1,u2));

            Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
            Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
            Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
            orderRepository.saveAll(Arrays.asList(o1,o2,o3));

            Category cat1 = new Category(null, "Electronics");
            Category cat2 = new Category(null, "Books");
            Category cat3 = new Category(null, "Computers");

            categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));

        }
}
