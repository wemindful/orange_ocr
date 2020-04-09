# 橙子OCR

#### 项目介绍
​        OrangeOcr(橙子OCR) 依托前沿深度学习等人工智能技术，提供多渠道、高精准度的OCR字符识别技术服务，印刷体文字识别准确率可高达90%以上,提供通用OCR识别，身份证识别， 银行卡识别， 发票识别 ，车牌识别，等常见工业OCR识别服务。

橙子OCR 软件包括orange_ocr-viwer,orange_ocr-server,orange_ocr-admin，分别为前端,管理后台,服务监控。

#### 软件架构

​       微服务架构（microservices architecture）是服务导向架构（service-oriented architecture，缩写 SOA）的升级。

 RESTful API 模式：服务通过 API 提供。

<img src="project-image/1.png" style="zoom: 80%;" />


#### 安装教程

1. 确保安装maven 3.6+  

   ```xml
   mvn -v
   ```

2. 项目根目录打包

   ```xml
   mvn clean package
   ```

3. 启动

   ```xml
   nohup java -Xms800m -Xmx800m -XX:PermSize=256m -XX:MaxPermSize=512m -XX:MaxNewSize=512m -jar xxxjar
   ```

#### 使用技术

```
1: Spring Boot 2.2.6
2: Spring-Data-Jpa
3: Spring-Security
4: spring-boot-starter-mail
5: fastjson
6: thymeleaf
7: knife4j
8: lombok
9: hutool
10: Mysql
11: Spring-Admin
```


#### 使用说明

1. 可直接使用 Jpa

3.  也可使用SQL.sql

   ```xml
   在项目更目录 SQL文件: 
   ```
   

#### 配置说明

```
在orange_ocr-admin项目的application.xml 配置监控地址:

# 例子:
orange_ocr-viwer : http://localhost:9090/
orange_ocr-server: http://localhost:9091/
orange_ocr-admin : http://localhost:9092/


```

#### 项目展示