package cn.ifengkou.athena.service.impl;

import cn.ifengkou.athena.common.id.IdGen;
import cn.ifengkou.athena.dao.MessageDao;
import cn.ifengkou.athena.model.Message;
import cn.ifengkou.athena.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sloong on 2015/11/30.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    @Resource
    MessageDao messageDao;

    public Message get(long id) {
        return messageDao.get(id);
    }

    @Override
    public long add(Message message){
        long id = IdGen.genId();
        message.setId(id);
        messageDao.add(message);
        return id;
    }

    @Override
    public int getMessagesCount(long userId) {
        return messageDao.getMessagesCount(userId);
    }

    @Override
    public int updateMessagesToRead(long userId,long[] messageIds) {
        HashMap<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("messages",messageIds);
        return messageDao.updateMessagesToRead(map);
    }

    @Override
    public List<Message> getUnreadMessageByUserId(long userId) {
        return messageDao.getUnreadMessageByUserId(userId);
    }

    @Override
    public List<Message> getReadMessagesByUserId(long userId) {
        return messageDao.getReadMessagesByUserId(userId);
    }
}
