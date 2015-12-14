package cn.ifengkou.athena.service;

import cn.ifengkou.athena.model.Message;

import java.util.List;

/**
 * Created by Sloong on 2015/11/30.
 */
public interface MessageService {
    /**
     * 根据MESSAGE ID 获取 Message对象
     * @param id
     * @return
     */
    Message get(long id);


    /**
     * 新增message
     * @param message
     * @return
     */
    long add(Message message);

    /**
     * 获取消息总数
     * @param userId
     * @return
     */
    int getMessagesCount(long userId);

    /**
     * 将消息置为已读
     * @param userId 用户ID
     * @return
     */
    int updateMessagesToRead(long userId,long[] messageIds);

    /**
     * 获取未读消息
     * @param userId 所属用户
     * @return
     */
    List<Message> getUnreadMessageByUserId(long userId);

    /**
     * 获取已读消息
     * @param userId 所属用户
     * @return
     */
    List<Message> getReadMessagesByUserId(long userId);
}
