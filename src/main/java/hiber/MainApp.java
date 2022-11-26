package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            System.out.println();
        }

        Car fiat = new Car("Fiat", 12345);
        User nicholas = new User("Nicholas", "White", "nwhite@mail.ru", fiat);
        userService.add(nicholas);

        Car benz = new Car("Mercedes Benz", 34567);
        User helen = new User("Helen", "Petrovsky", "helen@mail.ru", benz);
        userService.add(helen);


        User nick = userService.getUserByCar("Fiat", 12345);
        System.out.println(nick);

        User lena = userService.getUserByCar("Mercedes Benz", 34567);
        System.out.println(lena);

        context.close();
    }
}
