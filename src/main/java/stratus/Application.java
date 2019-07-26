package stratus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;

public class Application {
    private UserDAO userDao;
    private RouteDAO routeDao;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("stratus");
        UserDAO userDao = ctx.getBean(UserDAO.class);
        RouteDAO routeDao = ctx.getBean(RouteDAO.class);
//
//        User dom = new User("Dominika", "Malinowska", "246 Priory Road", "Birmingham",
//                "B28 0SU", "dom", "password", "do_ma1991@hotmail.com",
//                "07904295900", 'A', null );
        User issi = new User("Rose", "DE", "246 Priory Road", "Birmingham",
                "B28 0SU", "rose", "password", "do_ma1991@hotmail.com",
                "07904295900", 'A', null );
//        userDao.save(dom);
//        userDao.save(issi);
//
//        System.out.println(userDao.findAll());

        Route home = new Route("jsonString", "St C Street", "International House",
                LocalDate.of(2019,07,25), true, 'B' , "Startlong",
                "EndLong", "Endlat", "StartLat", "GBP", "QA",
                Arrays.asList(userDao.findByLogin("rose")));

        routeDao.save(home);

        System.out.println(routeDao.findAll());
    }

}

