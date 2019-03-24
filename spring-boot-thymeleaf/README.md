## Spring boot2.x 集成Thymeleaf
Spring boot开发web项目，通常打成jar包，使用内置的web服务器 Tomcat、Jetty、undertow 来运行。静态资源（css、js、图片等）默认放在resources/static下面。如果要修改默认存放目录，可以通过设置属性 spring.mvc.static-path-pattern来实现。

模板文件默认放在 templates目录下。Spring boot支持使用模板来开发web应用，支持的模板类型包括：
* FreeMarker
* Groovy
* Thymeleaf
* Mustache

Spring boot不建议使用jsp开发web。本文使用Thymeleaf来作为模板引擎开发web项目。

### Thymeleaf
Thymeleaf是一个Java模板引擎开发库，可以处理和生成HTML、XML、JavaScript、CSS和文本，在Web和非Web环境下都可以正常工作。Thymeleaf可以跟Spring boot很好的集成。


### 示例
1.pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

	<parent>
		<groupId>io.dreamstudio</groupId>
        <artifactId>spring-boot-tutorials</artifactId>
        <version>1.0.0-SNAPSHOT</version>
    </parent>
	
    <artifactId>spring-boot-thymeleaf</artifactId>
    <packaging>jar</packaging>

    <name>${project.artifactId}</name>
    <url>http://maven.apache.org</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencyManagement>
        <dependencies>
            <!-- Import dependency management from Spring Boot,not include plugin
                    management as the parent import style -->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- thymeleaf -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <finalName>${project.artifactId}</finalName>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

```