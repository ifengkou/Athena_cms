package cn.ifengkou.athena.service;

import cn.ifengkou.athena.model.TopicCollect;
import cn.ifengkou.athena.model.User;

import java.util.List;

/**
 * Created by Sloong on 2015/11/24.
 */
public interface UserService {

    User get(long id);

    int add(User user);

    int delete(User user);

    int update(User user);

    User verifyAccessToken(String accessToken);

    User getUserByLoginName(String loginName);

    User getUserByMail(String mail);

    List<User> getUsersByIds(List<Long> ids);


    List<TopicCollect> getCollectTopicByUserId(long userId);

}
