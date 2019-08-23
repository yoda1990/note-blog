## 一、初始Docker与容器
### 1.1、什么是 docker?

&emsp;&emsp;Docker是基于Go 语言实现的容器项目。

### 1.2、Docker的优势
- 更快速的交付和部署
- 更高效的资源利用
- 更轻松的迁移和扩展
- 更简单的更新管理

## 二、核心概念和安装配置

&emsp;&emsp;Docker的三大核心概念：
- 镜像(Image)
- 容器(Container)
- 仓库(Repository)
 

### 2.1、核心概念

&emsp;&emsp;1、Docker镜像

&emsp;&emsp;Docker镜像类似于虚拟机镜像，可以将它理解为一个只读模板。是创建Docker容器的基础。

&emsp;&emsp;2、Docker容器

&emsp;&emsp;Docker容器相当于一个轻量级的沙箱，Docker利用容器来运行和隔离应用。

&emsp;&emsp;3、Docker仓库

&emsp;&emsp;Docker仓库是类似于代码仓库，是Docker集中存放镜像文件的场所。

### 2.2、安装Docker引擎

&emsp;&emsp;CentOs安装指南：https://docs.docker.com/install/linux/docker-ce/centos/

&emsp;&emsp;MacOs安装指南：https://docs.docker.com/docker-for-mac/install/

&emsp;&emsp;Windows安装指南: https://docs.docker.com/docker-for-windows/install/

## 三、使用Docker镜像

### 3.1、获取镜像

&emsp;&emsp;docker [image] pull  会直接从DockerHub镜像源来下载镜像

&emsp;&emsp;命令格式：docker [image] pull name[:TAG]。

    示例命令： docker pull ubuntu:18.04
    非官方仓库命令：docker pull hub.c.163.com/public/ubuntu:18.04
    
    下载镜像到本地后使用该镜像;
    docker run -it ubuntu:18.04 bash
    
    启动后可在 bash 中输入 echo  "Hello World"

### 3.2、查看镜像信息

&emsp;&emsp;1、使用images命令列出镜像
     
    docker images 或者 docker image ls 
    
&emsp;&emsp;2、使用tag命令 添加镜像标签

    docker tag ubuntu:latest myubuntu:latest
    
&emsp;&emsp;3、使用 inspect 命令查看详细信息

    docker [image] inspect ubuntu:18.04
    
&emsp;&emsp;4、使用history命令查看镜像历史

    docker history ubuntu:18.04
    
### 3.3、搜索镜像    
    
    docker search [option] keyword
    
### 3.4、删除和清理镜像

&emsp;&emsp;1、使用标签删除镜像

&emsp;&emsp;使用docker rmi 或 docker image rm 命令可以删除镜像，命令格式 docker rmi IMAGE，其中IMAGE可以为标签或ID。

&emsp;&emsp;支持选项包括：
- -f，-force：强制删除镜像，即使有容器依赖它。
- -no-prune：不要清理未带标签的父镜像。
- 


&emsp;&emsp;2、使用镜像ID来删除镜像

&emsp;&emsp;docker rmi 命令后 用镜像Id。


&emsp;&emsp;3、清理镜像

&emsp;&emsp;docker image prune

&emsp;&emsp;支持选项包括：
- -a,-all：删除所有无用镜像，不仅仅是临时镜像。
- -filter filter：只清理符合给定过滤器的镜像。
- -f，-force：强制删除镜像，而不进行提示确认。
- 


### 3.5、创建镜像

&emsp;&emsp;1、基于已有容器创建

&emsp;&emsp;该方法主要是使用 docker [container] commit命令。

&emsp;&emsp;命令格式为docker [container] commit [OPTIONS] CONTAINER [REPOSITORY [:TAG]]，主要选项包括：
- -a，--author=""：作者信息；
- -c, --change=[]：提交的时候执行Dockerfile指令；
- -m, --message=""：提交信息；
- -p, --pause=true：提交时暂定容器运行。
- 


&emsp;&emsp;命令示例：

    docker [container] commit -m "Added a new file" -a "Docker Author" a82(容器ID)

&emsp;&emsp;2、基于本地模板导入

&emsp;&emsp;使用的命令docker [container] import。

&emsp;&emsp;命令格式：docker [container] import [OPTIONS] file|URL|-[REPOSITORY[:TAG]]

&emsp;&emsp;3、基于Dockerfile创建

&emsp;&emsp;基于debian:stretch-slim镜像安装python3环境，构成一个新的python:3镜像：

    FROM debian:stretch-slim
    LABEL version="1.0" maintainer="docker user <docker_user@github>"
    RUN apt-get update && \
        apt-get install -y python3 && \
        apt-get clean && \
        rm -rf /var/lib/apt/lists/*
        
&emsp;&emsp;创建镜像的过程可以使用docker [image] build 命令，编译成功后本地将多出一个python:3 镜像。

### 3.6、存出和载入镜像
&emsp;&emsp;1、存出镜像

&emsp;&emsp;docker [image] save 命令。支持 -o、-output string参数，导出镜像到指定的文件中。


&emsp;&emsp;2、载入镜像

&emsp;&emsp;docker [image] load将导出的tar文件再导入到本地镜像库。支持 -i、-input string选项，从指定文件中读入镜像内容。

### 3.7、上传镜像

&emsp;&emsp;可以使用docker [image] push命令上传镜像到仓库。

&emsp;&emsp;命令格式：docker [image] push NAME[:TAG]|[REGISTRY_HOST[:REGISTER_PORT]/]NAME[:TAG]。

&emsp;&emsp;命令示例：

    docker tag test:latest user/test:latest
    docker push user/test:latest

## 四、操作Docker容器

### 4.1、创建容器

&emsp;&emsp;1、新建容器
&emsp;&emsp;可以使用 docker [container] create新建容器。

    docker create -it ubuntu:latest
    
&emsp;&emsp;2、启动容器

&emsp;&emsp;使用docker [container] start 来启动一个容器。

    docker start af
    
&emsp;&emsp;3、新建并启动容器

&emsp;&emsp;需要用到的命令为：docker [container] run 

    docker run ubuntu /bin/echo 'Hello world'
    
    //启动一个bash终端
    docker run -it ubuntu:18.04 /bin/bash
    
    可以使用ctrl+d 或者输入 exit 退出容器。    
    
&emsp;&emsp;4、守护态运行

    docker run -d ubuntu /bin/sh....

&emsp;&emsp;5、查看容器输出

&emsp;&emsp;使用 docker [container] logs 命令

    docker logs 容器ID
    
### 4.2、停止容器

&emsp;&emsp;1、暂停容器

&emsp;&emsp;用docker [container] pause CONTAINER[CONTAINER...] 命令暂停一个容器。

   docker pause test(containerName)
   
&emsp;&emsp;2、终止容器

&emsp;&emsp;可以使用docker [container] stop 来终止一个运行中的容器。

&emsp;&emsp;命令格式：docker [container] stop [-t|--time[=10]][CONTAINER...]

### 4.3、进入容器

&emsp;&emsp;1、attach命令

&emsp;&emsp;命令格式：docker [container] attach [--detach-keys[=[]]] [--no-stdin] [--sig-proxy[=true] CONTAINER]

&emsp;&emsp;2、exec命令 

&emsp;&emsp;命令格式：docker [container] exec [-d|--detach] [--detach-keys[=[]]] [-i|--interactive] [--privileged] [-t|--tty] [-u|--user[=USER]] CONTAINER COMMAND [ARG...]

&emsp;&emsp;进入容器bash

    docker exec -it 容器ID /bin/bash
    
### 4.4、删除容器

&emsp;&emsp;可以使用 docker [container] rm 来删除

&emsp;&emsp;命令格式：docker [container] rm [-f|--fore] [-l|--link] [-v|--volumes] CONTAINER
[CONTAINER...]

    docker rm 容器ID


### 4.5、导入和导出容器

&emsp;&emsp;1、导出容器

&emsp;&emsp;可以使用 docker [container] export

&emsp;&emsp;命令格式：docker [container] export [-o|--output[=""]] CONTAINER

&emsp;&emsp;2、导入容器

&emsp;&emsp;可以使用 docker [container] import

&emsp;&emsp;命令格式：docker import [-c|--change[=[]]] [-m|--message[=MESSAGE]] file|URL|-[REPOSITORY[:TAG]]

### 4.6、查看容器

&emsp;&emsp;1、查看容器详情
&emsp;&emsp;可以使用docker container inspect [OPTIONS] CONTAINER[CONTAINER...]子命令。

    docker container inspect test
    
&emsp;&emsp;2、查看容器内进程
&emsp;&emsp;可以使用docker [container] top [OPTIONS] CONTAINER[CONTAINER..]子命令

    docker top test
    
&emsp;&emsp;3、查看统计信息
&emsp;&emsp;可以使用 docker [container] stats [OPTIONS] [CONTAINER...]子命令

## 五、访问Docker仓库

&emsp;&emsp;访问DockerHub

## 六、Docker数据管理

&emsp;&emsp;容器中的管理书库主要有两种方式
- 数据卷(Data Volumes)：容器内数据直接映射到本主机环境
- 数据卷容器(Data Volume Containers)：使用特定容器维护数据卷

### 6.1、数据卷

&emsp;&emsp;1、创建数据卷

&emsp;&emsp;Docker 提供volume子命令来管理数据卷，如下命令：

    docker volume create -d local test test

&emsp;&emsp;2、绑定数据卷

&emsp;&emsp;在用docker [container] run 命令的时候，可以使用 -mount选项来使用数据卷。

&emsp;&emsp;-mount选项支持三种类型的数据卷，包括：
- volume：普通数据卷，映射到到主机/var/lib/docker/volumes路径下；
- bind：绑定数据卷，映射到主机指定路径下；
- tmpfs：临时数据卷，只存在于内存中

&emsp;&emsp;下面使用 training/webapp镜像创建了一个Web容器，并创建一个数据卷挂载到容器的/opt/webapp目录：

    docker run -d -p --name web --mount type=bind,source=/webapp,destination=/opt/webapp training/webapp python app.py

&emsp;&emsp;Docker挂载数据卷的默认权限是读写(rw)，用户也可以通过ro指定为只读：

    docker run -d -p --name web -v /webapp:/opt/webapp:ro training/webapp python app.py
    
### 6.2、数据卷容器

&emsp;&emsp;首先创建一个数据卷容器db-data,并在其中创建一个数据卷挂载到/dbdata：

    docker run -it -v /dbdata --name dbdata ubuntu

&emsp;&emsp;可以在其他容器中使用 --volume-from 来挂载dbdata 容器中的数据卷，例如创建db1和db2两个容器，并从dbdata容器挂载数据卷：

    docker run -it --volumes-from dbdata --name db1 ubuntu
    docker run -it --volumes=from dbdata --name db2 ubuntu

&emsp;&emsp;此时，容器db1和db2都挂载同一个数据卷到到相同的/dbdata 目录，此时数据共享。

### 6.3、利用数据卷容器来迁移数据

&emsp;&emsp;1、备份

&emsp;&emsp;用命令备份dbdata数据卷容器内的数据卷：

    docker run --volumes-from dbdata -v $(pwd):/backup --name work ubuntu tar cvf /backup/backup.tar /dbdata

&emsp;&emsp;2、恢复

&emsp;&emsp;首先创建带有数据卷的容器 dbdata2：

    docker run -v /dbdata --name dbdata2 ubuntu /bin/bash
    
&emsp;&emsp;然后创建另一个新的容器，挂载dbdata2的容器，并使用untar 解压备份文件到所挂载的容器卷中：

    docker run --volumes-from dbdata2-v $(pwd):/backup busybox tar xvf /backup/backup.tar
    
## 七、端口映射与容器互联

### 7.1、端口哦映射实现容器访问

&emsp;&emsp;1、从外部访问容器应用

&emsp;&emsp;当容器运行一些网络应用，要让外部访问这些应用时，可以通过-P或-p参数来指定端口。当使用-P(大写的)标记时，Docker会随机映射一个49000~49900的端口到内部容器开放的网络端口：

   docker run -d -P training/webapp python app.py

   // 查看映射情况
   docker ps -l   
   
&emsp;&emsp;-p(小写的)则可以指定要映射的端口，并且，在一个指定端口上只可以绑定一个容器。支持的格式有 IP:HostPort:ContainerPort | IP::ContainerPort | HostPort:ContainerPort

&emsp;&emsp;2、映射所有接口地址

&emsp;&emsp;使用HostPort:ContainerPort格式

    docker run -d -p 5000:5000 training/webapp python app.py
    
&emsp;&emsp;3、映射到指定地址的指定端口

&emsp;&emsp;可以使用IP:HostPort:ContainerPort格式：

    docker run -d -p 127.0.0.1:5000:5000 training/webapp python app.py
    
&emsp;&emsp;4、映射到指定地址的任意端口

&emsp;&emsp;可以使用IP::ContainerPort格式：

    docker run -d -p 127.0.0.1::5000 training/webapp python app.py

&emsp;&emsp;5、查看端口映射

&emsp;&emsp;使用 docker port 查看

    docker port werw 5000

### 7.2、互联机制实现便捷互访

&emsp;&emsp;1、自定义容器命名
    
    docker run -d -P --name web training/webapp python app.py

&emsp;&emsp;2、容器互联    

&emsp;&emsp;使用--link参数可以让容器之间安全地进行交互。

&emsp;&emsp;先创建一个新的数据库容器

    docker run -d --name db tarining/postgres
    
&emsp;&emsp;创建一个新的web容器，并将它连接到db容器：

    docker run -d -P --name web --link db:db training/webapp python app.py
   
&emsp;&emsp;--link 的参数格式为 --link name:alias   


## 八、使用Dockerfile创建镜像
### 8.1、基本结构
&emsp;&emsp;Dockerfile主体内容分为四部分：基础镜像信息、维护者信息、镜像操作指令和容器启动时执行指令。

### 8.2、指令说明
&emsp;&emsp;Dockerfile中指令的一般格式为INSTRUCTION arguments，包括配置指令和操作指令。

&emsp;&emsp;1、配置指令

&emsp;&emsp;ARG:定义创建镜像过程中使用的变量。

&emsp;&emsp;格式为ARG <name>[=<default value>]。

&emsp;&emsp;在执行docker build时，可以通过-build-arg[=]来为变量赋值。当镜像编译成功后，ARG指定的变量将不存在(ENV指定的变量将在镜像中保留)。

&emsp;&emsp;Docker内置了一些镜像创建变量，包括 HTTP_PROXY、HTTPS_PROXY、FTP_PROXY、NO_PROXY。

&emsp;&emsp;FROM：指定所创建镜像的基础镜像

&emsp;&emsp;格式为 FROM <image> [AS <name>] 或 FROM <image>:<TAG> [AS <name>] 或 FROM <image>@<digest> [AS <name>]。

&emsp;&emsp;例如：

    ARG VERSION=9.3
    FROM debian:${VERSION}
    
&emsp;&emsp;LABEL：可以为生成的镜像添加元数据标签信息。

&emsp;&emsp;格式为 LABEL <key>=<value> <key>=<value> <key>=<value>...

&emsp;&emsp;例如：

    LABEL version="123546"
    LABEL author="sdfsdff" date="2020-01-01"

&emsp;&emsp;EXPOSE：声明镜像内服务监听的端口。

&emsp;&emsp;格式为 EXPOSE <port> [<port>/<protocol>...] 。

    EXPOSE 22 808443
    
&emsp;&emsp;ENV：指定环境变量。

&emsp;&emsp;格式为 ENV <key>=<value> 、ENV <key> <value>

    ENV APP_VERSION=1.0.0
    
&emsp;&emsp;ENTRYPOINT：指定镜像的默认入口命令，该入口命令会在启动容器时作为根命令执行，所有传入值作为该命令的参数。

&emsp;&emsp;支持两种格式：
- ENTRYPOINT ["executable","param1","param2"]:exec 调用执行；
- ENTRYPOINT command param1 param2:shell 中执行。

&emsp;&emsp;VOLUME：创建一个数据卷挂载点。格式为 VOLUME["/data"]。

&emsp;&emsp;USER：指定运行容器的用户名或UID，格式为 USER daemon。

&emsp;&emsp;WORKDIR：为后续的RUN、CMD、ENTRYPOINT指令配置工作目录。

&emsp;&emsp;格式为 WORKDIR /path/to/workdir

&emsp;&emsp;ONBUILD：指定当基于所生成镜像创建子镜像时，自动执行的操作指令。

&emsp;&emsp;格式为 ONBUILD [INSTRUCTION]

&emsp;&emsp;2、操作指令

&emsp;&emsp;RUN：运行指定命令

&emsp;&emsp;格式为 RUN <command>或RUN ["executable","param1","param2"]。命令较长时用 \ 来换行。

&emsp;&emsp;CMD：用来指定启动容器时默认执行的命令。支持三种格式
- CMD ["executable","param1","param2"]：相当于执行 executable param1 param2,推荐方式；
- CMD command param1 param2：在默认的shell中执行。提供给需要的交互的应用；
- CMD ["param1","param2"]：提供给ENTRYPOINT 的默认参数。

&emsp;&emsp;ADD：添加内容到镜像，格式 ADD <src> <dest> 该命令将复制指定的<src>路径下内容到容器中的<dest>路径下。

&emsp;&emsp;COPY 复制内容到镜像，格式为 COPY <src> <dest>

### 8.3、创建镜像

&emsp;&emsp;可以通过docker [image] build来创建镜像，格式为 docker build [OPTIONS] PATH | URL |- 。 

&emsp;&emsp;1、命令选项

&emsp;&emsp;2、选择父镜像

&emsp;&emsp;3、使用.dockerignore文件

&emsp;&emsp;4、多步骤创建

&emsp;&emsp;通常情况下至少需要准备两个环境的Docker镜像：
- 编译环境镜像：包括完整的编译引擎、依赖库等。
- 运行环境镜像：利用编译好的二进制文件，运行应用。
