import com.zhw.season.pojo.User;
import com.zhw.season.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
        for (User user : userServiceImpl.getAllUser()) {
            System.out.println(user);
        }
    }
    @Test
    public void testById(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        System.out.println(userServiceImpl.getUserById(5));
    }
}
