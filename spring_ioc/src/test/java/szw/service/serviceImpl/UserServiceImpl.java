package szw.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import szw.dao.UserDao;
import szw.service.UserService;

import javax.annotation.Resource;

//同dao层类似使用
@Service("userService")
//@Compontent
public class UserServiceImpl implements UserService {
    //注入属性
    @Autowired
    //set方法可有可无
    @Qualifier("userDao")
    //@Qualifier("userDao")必须和@Autowired配合，自己可以去掉当只有一个UserDao类型时
    //@Resource
    //也可以用@Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        userDao.addUser();
    }
}
