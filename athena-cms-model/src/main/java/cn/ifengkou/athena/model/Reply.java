package cn.ifengkou.athena.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.util.List;

/**
 * Created by Sloong on 2015/11/23.
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Reply {
    private long id;
    private String content;
    private long topicId;
    private long authorId;
    private long parentReplyId;
    private Date createAt;
    private Date updateAt;
    private boolean contentIsHtml;
    private boolean deleted;

    private Topic topic;
    private User author;

    private List<String> upids;
    private List<Ups> ups;

    public List<String> getUpids() {
        return upids;
    }

    public void setUpids(List<String> upids) {
        this.upids = upids;
    }



    public List<Ups> getUps() {
        return ups;
    }

    public void setUps(List<Ups> ups) {
        this.ups = ups;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public long getParentReplyId() {
        return parentReplyId;
    }

    public void setParentReplyId(long parentReplyId) {
        this.parentReplyId = parentReplyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public boolean isContentIsHtml() {
        return contentIsHtml;
    }

    public void setContentIsHtml(boolean contentIsHtml) {
        this.contentIsHtml = contentIsHtml;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
