## Spring boot 上传文件

## 设置单个文件的大小
Spring boot 1.5.x中配置如下：
```
spring.http.multipart.maxFileSize = 10Mb  
spring.http.multipart.maxRequestSize=100Mb 
```

Spring boot 2.0中修改为了:
```
spring.servlet.multipart.max-file-size = 10Mb  
spring.servlet.multipart.max-request-size = 100Mb 
```
