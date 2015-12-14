package cn.ifengkou.athena.dao;

import cn.ifengkou.athena.model.Message;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/11/25.
 */
@Repository
public interface MessageDao {
    int getMessagesCount(long userId);
    Message get(long id);

    int add(Message message);

    int updateMessagesToRead(HashMap<String,Object> map);
    List<Message> getUnreadMessageByUserId(long userId);
    List<Message> getReadMessagesByUserId(long userId);
}
