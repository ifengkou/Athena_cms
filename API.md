# Athena CMS API #

/api

## 主题 ##

**get /topics 主题首页**

- page Number 页数
- tab String 主题分类
- limit Number 每一页的主题数量
- mdrender String 当为 false 时，不渲染。默认为 true，渲染出现的所有 markdown 格式文本。

示例：*[/api/topics](#)*

**get /topic/:id 主题详情**

-mdrender String

示例：*[/api/topic/5433d5e4e737cbe96dcef312](#)*

**post /topics 新建主题**

- title String 标题
- tab String 目前 ask share job
- content String 主题内容

返回值:

	{success: true, topicId: '5433d5e4e737cbe96dcef312'}

**post /topic/collect 收藏主题**

- accesstoken String 用户的accesstoken
- topicId String 被收藏的主题id

返回值示例：

	{success: true}

**post /topic/de_collect 取消收藏**

- accesstoken String 用户的accesstoken
- topicId String 被收藏的主题id

返回值示例：

	{success: true}

## 评论 ##

**post topic/:topicId/replies 新建评论**

- accesstoken String 用户的 accessToken
- content String 评论的主体
- replyId String 如果这个评论是对另一个评论的回复，请务必带上此字段。这样前端就可以构建出评论线索图。

返回值示例

	{success: true, replyId: 123456789}

**post reply/:replyId/ups 为评论点赞**

- accesstoken String 用户的 accessToken

接口会自动判断用户是否已点赞，如果否，则点赞；如果是，则取消点赞。点赞的动作反应在返回数据的 action 字段中，up or down。

返回值示例

	{"success": true, "action": "down"}

## 用户 ##

**post /user/login 登录**

- loginName string 登录名
- pass string 加密后的password

{success:true,token:'abcdefg1234567'}



**get /user/:loginname 获取用户详情**

示例：*[/api/user/sloong](#)*


**post /accesstoken  验证token有效性**

- accesstoken string 用户的token

如果成功，则返回成功信息{success: true, loginname: 'xxxx'}。否则返回403

## 消息 ##

**get /message/count 获取未读消息总数**

- accesstoken string

返回示例：3

**get /messages 获取已读和未读消息**

- accesstoken string
- mdrender  string

返回示例：

	{
	  data: {
	    has_read_messages: [],
	    hasnot_read_messages: [
	      {
	        id: "543fb7abae523bbc80412b26",
	        type: "at",
	        has_read: false,
	        author: {
	          loginname: "alsotang",
	          avatar_url: "https://avatars.githubusercontent.com/u/1147375?v=2"
	        },
	        topic: {
	          id: "542d6ecb9ecb3db94b2b3d0f",
	          title: "adfadfadfasdf",
	          last_reply_at: "2014-10-18T07:47:22.563Z"
	        },
	        reply: {
	          id: "543fb7abae523bbc80412b24",
	          content: "[@alsotang](/user/alsotang) 哈哈",
	          ups: [ ],
	          create_at: "2014-10-16T12:18:51.566Z"
	          }
	        },
	    ...
	    ]
	  }
	}

**post /message/mark_all 标记全部已读**

- accesstoken string

返回示例：

	{ success: true,
	  marked_msgs: [ { id: '544ce385aeaeb5931556c6f9' } ] }