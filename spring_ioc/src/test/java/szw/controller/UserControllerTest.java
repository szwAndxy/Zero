package szw.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import szw.config.SpringConfigration;
import szw.service.UserService;

public class UserControllerTest {
    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        userService.save();*/
        //测试全注解
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfigration.class);
        ((UserService)app.getBean("userService")).save();
    }
}
