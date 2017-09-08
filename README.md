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