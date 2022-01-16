package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Ivan", "Ivanov", "Ivanov@mail.ru",new Car("BMV", 1)));
      userService.add(new User("Petr", "Petrov", "Petrov@mail.ru", new Car("VAZ",2101)));
      userService.add(new User("Semen", "Semenov", "Semenov@mail.ru",new Car("Mersedes", 123)));
      userService.add(new User("Egor", "Egorov", "Egorov@mail.ru", new Car("UAZ", 2233)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().getId());
         System.out.println();
      }
      System.out.println("Найдем владельца машины:");
      System.out.println("OWNER ID: " + userService.findOwner("Mersedes", 123).getCar().getUser());
      context.close();
   }
}
