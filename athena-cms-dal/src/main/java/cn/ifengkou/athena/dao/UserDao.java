package cn.ifengkou.athena.dao;

import cn.ifengkou.athena.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sloong on 2015/11/24.
 */
@Repository
public interface UserDao {

    User getUserByLoginName(String loginName);

    User get(long id);

    User getUserByMail(String mail);

    List<User> getUserByAccessToken(String accessToken);

    List<User> getUsersByIds(List<Long> ids);


    int add(User user);

    int delete(User user);

    int update(User user);
}
