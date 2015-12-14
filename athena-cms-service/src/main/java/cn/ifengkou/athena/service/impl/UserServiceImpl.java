package cn.ifengkou.athena.service.impl;

import cn.ifengkou.athena.common.id.IdGen;
import cn.ifengkou.athena.dao.TopicCollectDao;
import cn.ifengkou.athena.dao.UserDao;
import cn.ifengkou.athena.model.TopicCollect;
import cn.ifengkou.athena.model.User;
import cn.ifengkou.athena.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Sloong on 2015/11/24.
 */
@Service
public class UserServiceImpl implements UserService {
    private final static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    UserDao userDao;

    @Resource
    TopicCollectDao topicCollectDao;

    @Override
    public User get(long id) {
        return userDao.get(id);
    }

    @Override
    public int add(User user) {
        user.setId(IdGen.genId());
        return userDao.add(user);
    }

    @Override
    public int delete(User user) {
        user.setActive(false);
        return userDao.update(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Cacheable(value = "accessTokenUser",key = "#accessToken")
    @Override
    public User verifyAccessToken(String accessToken) {
        LOG.info("verifyAccessToken executing......");
        List<User> users = userDao.getUserByAccessToken(accessToken);
        if(users.size()!=1){
            if(users.size()>1){
                LOG.error("accessToken 出现了重复，bug！请检查！");
            }
            return null;
        }
        return users.get(0);
    }

    @Override
    public User getUserByLoginName(String loginName) {
        return userDao.getUserByLoginName(loginName);
    }

    @Override
    public User getUserByMail(String mail) {
        return userDao.getUserByLoginName(mail);
    }

    @Override
    public List<User> getUsersByIds(List<Long> ids) {
        return userDao.getUsersByIds(ids);
    }

    @Override
    public List<TopicCollect> getCollectTopicByUserId(long userId) {


        return topicCollectDao.getTopicCollectsByUserId(userId) ;
    }


}
