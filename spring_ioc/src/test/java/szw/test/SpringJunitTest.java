package szw.test;

import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import szw.config.SpringConfigration;
import szw.service.UserService;

import javax.sql.DataSource;
import java.sql.SQLException;

//spring集成junit测试,使用spring内核，可以不用创建spring的上下文获取bean
@RunWith(SpringJUnit4ClassRunner.class)
//如果是配置文件形式
//@ContextConfiguration("classpath:applicationContext.xml")
//如果是全注解形式
@ContextConfiguration(classes = {SpringConfigration.class})
public class SpringJunitTest {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}
