## 2.1、创建Spring Boot应用
### 2.1.1、命令行方式创建SpringBoot应用

    1、创建Spring Boot 应用
        <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.0.2.RELEASE</version>
        </parent>
        
        firstApp  的 POM：
        <dependencies>
                <!--增加 SpringBoot Web依赖-->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-web</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-test</artifactId>
                    <scope>test</scope>
                </dependency>
            </dependencies>
        
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                    </plugin>
                </plugins>
            </build>
    
    2、运行 Spring Boot应用
    java -jar target/first-spring-boot-application.jar
    
    
    
    
            
## 2.2、