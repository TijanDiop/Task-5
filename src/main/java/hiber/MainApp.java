package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
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

      Car car1 = new Car("BMW",3);
      Car car2 = new Car("Audi",2);
      Car car3 = new Car("Mersedes-Benz",4);
      Car car4 = new Car("Shkoda",5);

      User user1 = new User("Tijan","Diop","td@gmail.com",car1);
      User user2 = new User("Vadim","Goshin","vg@gmail.com",car2);
      User user3 = new User("Nikita","Pantyukhin","np@gmail.com",car3);
      User user4 = new User("Zina","Ivanova","zi@gmail.com",car4);

      List<User> usersAddList = List.of(user1,user2,user3,user4);
      usersAddList.forEach(userService::add);

      System.out.println("User с искомой машиной\n"
                         + userService.getUserByCar("BMW",3) + "\n");

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      context.close();
   }
}
