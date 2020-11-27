package szw.junitTest;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import szw.config.SpringConfigration;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
    String driver = resourceBundle.getString("jdbc.driver");
    String url = resourceBundle.getString("jdbc.url");
    String username = resourceBundle.getString("jdbc.username");
    String password = resourceBundle.getString("jdbc.password");
    //分别手动创建c3p0和druid
    @Test
    public void test1() throws SQLException, PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost3306/db_rubbish");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    //使用配置文件创建
    @Test
    public void test2() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DruidDataSource druidDataSource = (DruidDataSource)applicationContext.getBean("dataSource");
        System.out.println(druidDataSource.getConnection());
    }
    //利用properties
    @Test
    public void test3() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        System.out.println(dataSource.getConnection());
    }
    //全注解
    @Test
    public void test4() throws SQLException {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfigration.class);
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}

