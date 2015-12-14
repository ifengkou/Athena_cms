package cn.ifengkou.athena.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * 用户收藏的主题贴
 * Created by Sloong on 2015/11/23.
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class TopicCollect {
    private long userId;
    private long topicId;
    private Date createAt;
    private User user;
    private Topic topic;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
