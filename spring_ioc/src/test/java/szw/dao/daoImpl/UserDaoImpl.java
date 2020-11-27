package szw.dao.daoImpl;

import org.springframework.stereotype.Repository;
import szw.dao.UserDao;
@Repository("userDao")
//或者使用@Component();可以默认无id
public class UserDaoImpl implements UserDao {
    public void addUser() {
        System.out.println("添加用户成功！");
    }
}
