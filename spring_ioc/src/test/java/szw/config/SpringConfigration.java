package szw.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/*核心配置类，用注解代替xml配置*/
//标记该类为核心配置类
@Configuration
//替代组件扫描
@ComponentScan("szw")
//替代context-properties
//@PropertySource("classpath:jdbc.properties")
//解除耦合，用import
@Import(DataSourceConfigration.class)
public class SpringConfigration {
    /*@Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    public DataSource getDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }*/
}
