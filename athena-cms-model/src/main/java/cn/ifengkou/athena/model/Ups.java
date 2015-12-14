package cn.ifengkou.athena.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by Sloong on 2015/11/24.
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Ups {
    private long id;
    private long replyId;
    private long userId;
    private User user;
    private Reply reply;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
