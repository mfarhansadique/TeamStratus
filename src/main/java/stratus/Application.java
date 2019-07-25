package stratus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stratus.User;

public class Application {
    private UserDAO userDao;

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("stratus");
        UserDAO userDao = ctx.getBean(UserDAO.class);

        User dom = new User("Dominika", "Malinowska", "246 Priory Road", "Birmingham", "B28 0SU", "dom", "password", "do_ma1991@hotmail.com", "07904295900", 'A', null );
        userDao.save(dom);

        System.out.println(userDao.findAll());
    }
}