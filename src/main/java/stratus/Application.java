package stratus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication
public class Application {
    private UserDAO userDao;
    private RouteDAO routeDAO;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("stratus");
//        UserDAO userDao = ctx.getBean(UserDAO.class);
//
//        ApplicationContext ctx2 = new AnnotationConfigApplicationContext("stratus");
//        RouteDAO routeDao = ctx2.getBean(RouteDAO.class);
//
//        User dom = new User("Dominika", "Malinowska", "246 Priory Road", "Birmingham", "B28 0SU", "dom", "password", "do_ma1991@hotmail.com", "07904295900", 'A', null );
//        userDao.save(dom);
//
//        System.out.println(userDao.findAll());
//    }
}