## Spring boot 上传文件

## 设置单个文件的大小
Spring boot 1.5.x中配置如下：
```
spring.http.multipart.maxFileSize = 10Mb  
spring.http.multipart.maxRequestSize=100Mb 
```
其中，multipart.maxFileSize=10Mb是设置单个文件的大小，multipart.maxRequestSize=100Mb是设置单次请求的文件的总大小，
如果是想要不限制文件上传的大小，那么就把两个值都设置为-1就行啦。

Spring boot 2.0中修改为了:
```
spring.servlet.multipart.max-file-size = 10Mb  
spring.servlet.multipart.max-request-size = 100Mb 
```
