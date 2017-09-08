# quick-ssm-webapp
maven archetypes

通过maven脚手架快速搭建ssm项目
SpringMVC + Spring + Mybatis
数据库连接使用阿里druid

启动后，可通过本地tomcat或者tomcat maven插件运行

默认连接的是本地数据库
在启动前需要保证本地数据库中有，test库，库中有demo表
建表SQL
```SQL
CREATE TABLE `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1
```
使用步骤：
1. mvn install 打包到本地maven仓库
2. 创建maven项目时archetypes输入
    com.whh.maven.archetypes 该项目groupId
    quick-ssm-webapp 改项目artifactId
    1.0.0 改项目版本
3.如果需要上传到公司svn服务器，可以mvn deploy给其他人用

如果不想自己修改创建，可直接下载target目录下quick-ssm-webapp.jar文件，放入本地maven仓库中
放入目录com/whh/maven/archetypes/quick-ssm-webapp/1.0.0下
