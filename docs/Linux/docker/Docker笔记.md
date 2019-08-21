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





























































