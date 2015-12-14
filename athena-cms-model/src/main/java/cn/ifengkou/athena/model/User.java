package cn.ifengkou.athena.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Sloong on 2015/11/20.
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class User implements Serializable{
    private long id;
    private String name;
    private String loginName;
    private String pass;
    private String email;
    private String url;
    private String profileImageUrl;
    private String location;
    private String signature;
    private String profile;
    private String weibo;
    private String avatar;
    private String githubId;
    private String githubUserName;
    private String githubAccessToken;
    private boolean isBlock;
    private int score;
    private int topicCount;
    private int replyCount;
    private int followCount;
    private int collectTagCount;
    private int collectTopicCount;
    private Date createAt;
    private Date updateAt;
    private boolean isStar;
    private String level;
    private boolean active;
    private boolean receiveReplyMail;
    private boolean receiveAtMail;
    private boolean fromWp;
    private int retrieveTime;
    private String retrieveKey;
    private String accessToken;

    /*public String getAvataUrl(){
        String url = this.avatar == null?this.avatar: "https://gravatar.com/avatar/"+this.email.toLowerCase()+"?size=48";
        url = url.replace("www.gravatar.com","gravatar.com");

        if(url.indexOf("http:") == 0){
            url = url.substring(5);
        }
        //如果是github头像，则限制大小
        if(url.indexOf("githubusercontent") !=-1){
            url += "&s=120";
        }

        return url;
    }*/

    public boolean isAdvanced(){
        return this.score>700 || this.isStar();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    public String getGithubUserName() {
        return githubUserName;
    }

    public void setGithubUserName(String githubUserName) {
        this.githubUserName = githubUserName;
    }

    public String getGithubAccessToken() {
        return githubAccessToken;
    }

    public void setGithubAccessToken(String githubAccessToken) {
        this.githubAccessToken = githubAccessToken;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setIsBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(int topicCount) {
        this.topicCount = topicCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    public int getCollectTagCount() {
        return collectTagCount;
    }

    public void setCollectTagCount(int collectTagCount) {
        this.collectTagCount = collectTagCount;
    }

    public int getCollectTopicCount() {
        return collectTopicCount;
    }

    public void setCollectTopicCount(int collectTopicCount) {
        this.collectTopicCount = collectTopicCount;
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

    public boolean isStar() {
        return isStar;
    }

    public void setIsStar(boolean isStar) {
        this.isStar = isStar;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isReceiveReplyMail() {
        return receiveReplyMail;
    }

    public void setReceiveReplyMail(boolean receiveReplyMail) {
        this.receiveReplyMail = receiveReplyMail;
    }

    public boolean isReceiveAtMail() {
        return receiveAtMail;
    }

    public void setReceiveAtMail(boolean receiveAtMail) {
        this.receiveAtMail = receiveAtMail;
    }

    public boolean isFromWp() {
        return fromWp;
    }

    public void setFromWp(boolean fromWp) {
        this.fromWp = fromWp;
    }

    public int getRetrieveTime() {
        return retrieveTime;
    }

    public void setRetrieveTime(int retrieveTime) {
        this.retrieveTime = retrieveTime;
    }

    public String getRetrieveKey() {
        return retrieveKey;
    }

    public void setRetrieveKey(String retrieveKey) {
        this.retrieveKey = retrieveKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
