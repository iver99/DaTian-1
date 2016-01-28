# 【大田资源供应链管理平台】

【项目概述】：
------
		PC端项目为基于Java Web的J2EE项目，主要涉及的技术为：
		前端:JSP，Javascript，Jquery
		后台:Spring MVC+Hibernate
		测试：junit4
		数据库:Mysql5.5
		服务器:Tomcat7
		JDK：1.7
		本地开发环境：eclipse-jee-luna-R-win32-x86_64
		线上服务器：CentOS
		安全、权限框架：Shiro

【短信接口】：
------
		1、短信接口的源代码位于cn.b2m包下，是由亿美软通提供的嵌入式SDK，本项目只需要调用其封装好的方法即可
		2、短信相关的文档位于WebContent文件夹下的doc/sms中
		3、短信的测试页面为http://123.56.143.59/:8585/DaTian/views/testSMS.jsp页面
		4、【注意】短信功能只能在线上环境使用，本地环境下不会发送短信！
		5、负责短信接口的同学在改动前请先阅读，亿美软通提供的嵌入式SDK中的相关文档
【`日志`】：
-----
		关于日志，线上的日志文件位置为`/usr/local/datian_logs`文件夹下:
		error_datian.log  --- 项目的异常日志
		smsHis.log		--- 短信接口历史记录日志(记录短信的各种操作，发送状态等等)
		smsError.log		--- 短信接口的异常日志
		
【文档】：
------
		项目的文档位于docs文件夹下

【DB备份】：
------
		数据库备份文件位于sql_backup文件夹下
		

