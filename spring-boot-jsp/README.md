## SpringBoot整合jsp

### 1.依赖
pom.xml添加以下依赖：
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- jsp -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
</dependency>
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
</dependency>
```

### 2.配置文件上传的文件大小限制
application.yml 配置文件添加：
```
# 上传文件总的最大值
spring:
  servlet:
    multipart:
    max-request-size: 10MB
    max-file-size: 10MB

# jsp
  mvc:
    view:
      prefix: /WEB-INF/jsp/
      suffix: .jsp
```
其中，spring.servlet.multipart.max-file-size限制单个文件的最大值，spring.servlet.multipart.max-request-size限制上传的多个文件的总大小
   
### 3.jsp简单示例
#### 1.创建Controller控制类
IndexController内容如下：
```
package io.dreamstudio.springboot.jsp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ricky Fung
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(name = "userName") String userName) {
        ModelAndView view = new ModelAndView("index");
        view.addObject("userName", userName);
        return view;
    }
}
```

#### 2.创建index.jsp文件
src/main目录下创建 webapp/WEB-INF/jsp目录，然后新建index.jsp，内容如下：
```
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>首页</title>
</head>
<body>
Welcome ${userName}
</body>
</html>
```

#### 3.启动服务
通过spring-boot:run 插件启动项目，浏览器输入http://localhost:8080/index：
