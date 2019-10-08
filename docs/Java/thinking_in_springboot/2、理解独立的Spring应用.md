## 2.1、创建Spring Boot应用

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
    
    3、JarLauncher原理
    
    
    
            
## 3、理解固化的Maven依赖
### 3.1、spring-boot-starter-parent与spring-boot-dependencies 简介

    重新调整 first-app-spring-boot 的 POM 文件
    
     <properties>
            <project.buid.sourceEncoding>UTF-8</project.buid.sourceEncoding>
            <project.reporting.ouyputEncoding>UTF-8</project.reporting.ouyputEncoding>
            <java.version>1.8</java.version>
        </properties>
    
       <dependencyManagement>
           <dependencies>
               <dependency>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-dependencies</artifactId>
                   <version>2.0.2.RELEASE</version>
                   <type>pom</type>
                   <scope>import</scope>
               </dependency>
           </dependencies>
       </dependencyManagement>

### 3.2、理解spring-boot-starter-parent 与 spring-boot-dependencies



