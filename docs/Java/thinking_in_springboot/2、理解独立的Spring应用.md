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

    spring-boot-dependencies是spring-boot-starter-parent 的 parent。
    spring-boot-dependencies 可以直接作为parent。
    
    spring-boot-starter-web 和 spring-boot-test 均定义在 spring-boot-dependencies 的 POM中。
    
    调整 打包 插件
    
    <build>
            <plugins>
                <!-- 保持 与 spring-boot-dependencies 一致 -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-war-plugin</artifactId>
                    <version>3.1.0</version>
                </plugin>
    
                <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                    <version>2.0.2.RELEASE</version>
                    <executions>
                        <execution>
                            <goals>
                                <goal>repackage</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>
            </plugins>
        </build>


## 4、理解嵌入式WEB容器 

### 4.1、嵌入式Servlet Web 容器 
    
     1、tomcat 作为 Web 容器 
      <!--web 里面内嵌入了Tomcat web 容器 -->
      <dependency>
           <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-web</artifactId>
           <version>2.0.2.RELEASE</version>
      </dependency>
      
      2、Jetty作为 Web容器 
       <!--web 里面内嵌入了Tomcat web 容器 -->
       <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>2.0.2.RELEASE</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
             </exclusions>
       </dependency>
       <!--使用 jetty 需要将 tomcat 容器 排除掉-->
       <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
       </dependency>
       <!-- spring-boot-loader 用于源码分析-->
       <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-loader</artifactId>
            <scope>provided</scope>
       </dependency>
       
       3、Undertow 作为 Web 容器 
       
        <!--web 里面内嵌入了Tomcat web 容器 -->
                  <dependency>
                      <groupId>org.springframework.boot</groupId>
                      <artifactId>spring-boot-starter-web</artifactId>
                      <version>2.0.2.RELEASE</version>
                      <exclusions>
                          <exclusion>
                              <groupId>org.springframework.boot</groupId>
                              <artifactId>spring-boot-starter-tomcat</artifactId>
                          </exclusion>
                      </exclusions>
                  </dependency>
                  <!--使用 jetty 需要将 tomcat 容器 排除掉-->
       <!--           <dependency>-->
       <!--               <groupId>org.springframework.boot</groupId>-->
       <!--               <artifactId>spring-boot-starter-jetty</artifactId>-->
       <!--           </dependency>-->
       
                  <!--Use Undertow instead -->
                  <dependency>
                      <groupId>org.springframework.boot</groupId>
                      <artifactId>spring-boot-starter-undertow</artifactId>
                      <version>2.0.2.RELEASE</version>
                  </dependency>
       
                  <!-- spring-boot-loader 用于源码分析-->
                  <dependency>
                      <groupId>org.springframework.boot</groupId>
                      <artifactId>spring-boot-loader</artifactId>
                      <scope>provided</scope>
                  </dependency>
               
### 4.2、嵌入式Reactive Web 容器     

    1、UndertowServletWebServer 作为 Reactive Web 容器
    
    <!--web 里面内嵌入了Tomcat web 容器 -->
               <dependency>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-starter-web</artifactId>
                   <version>2.0.2.RELEASE</version>
                   <exclusions>
                       <exclusion>
                           <groupId>org.springframework.boot</groupId>
                           <artifactId>spring-boot-starter-tomcat</artifactId>
                       </exclusion>
                   </exclusions>
               </dependency>
               <!--使用 jetty 需要将 tomcat 容器 排除掉-->
    <!--           <dependency>-->
    <!--               <groupId>org.springframework.boot</groupId>-->
    <!--               <artifactId>spring-boot-starter-jetty</artifactId>-->
    <!--           </dependency>-->
    
               <!--Use Undertow instead -->
               <dependency>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-starter-undertow</artifactId>
                   <version>2.0.2.RELEASE</version>
               </dependency>
    
               <dependency>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-starter-webflux</artifactId>
                   <version>2.0.2.RELEASE</version>
               </dependency>
    
               <!-- spring-boot-loader 用于源码分析-->
               <dependency>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-loader</artifactId>
                   <scope>provided</scope>
               </dependency> 
    
    2、UndertowWebServer作为嵌入式ReactiveWeb 容器
    
    <!--web 里面内嵌入了Tomcat web 容器 -->
    <!--           <dependency>-->
    <!--               <groupId>org.springframework.boot</groupId>-->
    <!--               <artifactId>spring-boot-starter-web</artifactId>-->
    <!--               <version>2.0.2.RELEASE</version>-->
    <!--               <exclusions>-->
    <!--                   <exclusion>-->
    <!--                       <groupId>org.springframework.boot</groupId>-->
    <!--                       <artifactId>spring-boot-starter-tomcat</artifactId>-->
    <!--                   </exclusion>-->
    <!--               </exclusions>-->
    <!--           </dependency>-->
               <!--使用 jetty 需要将 tomcat 容器 排除掉-->
    <!--           <dependency>-->
    <!--               <groupId>org.springframework.boot</groupId>-->
    <!--               <artifactId>spring-boot-starter-jetty</artifactId>-->
    <!--           </dependency>-->
    
               <!--Use Undertow instead -->
               <dependency>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-starter-undertow</artifactId>
                   <version>2.0.2.RELEASE</version>
               </dependency>
    
               <dependency>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-starter-webflux</artifactId>
                   <version>2.0.2.RELEASE</version>
               </dependency>
    
               <!-- spring-boot-loader 用于源码分析-->
               <dependency>
                   <groupId>org.springframework.boot</groupId>
                   <artifactId>spring-boot-loader</artifactId>
                   <scope>provided</scope>
               </dependency>
     
     3、Jetty 作为 Reactive Web 容器
     
     注释掉其他容器 只留jetty 
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-jetty</artifactId>
     </dependency>
     
     4、Tomcat 作为 Reactive Web 容器
     
     注释掉其他容器 只留tomcat 
     <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-tomcat</artifactId>
     </dependency>
     
## 5、理解自动装配 

         