package stratus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    private UserDAO userDao;
    private RouteDAO routeDAO;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("stratus");
        UserDAO userDao = ctx.getBean(UserDAO.class);

        ApplicationContext ctx2 = new AnnotationConfigApplicationContext("stratus");
        RouteDAO routeDao = ctx2.getBean(RouteDAO.class);

        User dom = new User("Dominika", "Malinowska", "246 Priory Road", "Birmingham", "B28 0SU", "dom", "password", "do_ma1991@hotmail.com", "07904295900", 'A', null );
//        userDao.save(dom);
//
//        System.out.println(userDao.findAll());

//        Route home = new Route("jsonString", "Tabernacle Street", "International House", "2019-21-21", 'Y', 'B' , "Startlong", "EndLong", "Endlat", "StartLat", "GBP", "QA", users.add())
        }
}

