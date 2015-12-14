#基于SpringMVC+Mybatis 开发的REST API 接口程序#

##介绍##
Athena_cms 是使用SpringMVC　和 Mybatis 开发的社区系统后台接口，功能丰富，小巧迅速。你完全可以用来搭建自己的社区系统后台，配合完成APP搭建。
备注：目前细节尚待优化

##API接口##
见文档[API.md](API.md)

##安装部署##

java环境部署见 [这里](http://jingyan.baidu.com/article/e75aca85b29c3b142edac6a8.html)
mysql安装见 [这里](http://jingyan.baidu.com/article/f3ad7d0ffc061a09c3345bf0.html)
tomcat下载，解压到本地，启动

##配置##
- 登录mysql，新建数据库athena_cms,执行 [crebas.sql](/doc/crebas.sql)，新建用户，分配数据库权限
- 修改数据库访问参数，[config.properties](/athena-cms/controller/src/main/resources/data/config.properties)

##运行##

切换到主目录

**打包**
    mvn clean package

**发布**
    mvn clean package tomcat:redeploy -Dmaven.test.skip=true

##贡献##

有任何意见或建议都欢迎提 issue，或者直接提给 @alsotang

##License##
MIT
