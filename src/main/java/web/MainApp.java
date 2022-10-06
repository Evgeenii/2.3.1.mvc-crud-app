/*
package web;

import web.config.HibernateConfig;
import web.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        userService.saveUser(user1);

        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        userService.saveUser(user2);

        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        userService.saveUser(user3);

        User user4 = new User("User4", "Lastname4", "user4@mail.ru");
        userService.saveUser(user4);

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
*/
