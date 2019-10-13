## 一、概述
### 1.1、概念
&emsp;&emsp; HDFS，它是一个文件系统，用于存储文件，通过目录树来定位文件；其次，它是分布式的，由很多服务器联合起来实现其功能，集群中的服务器有各自的角色。
HDFS的设计适合一次写入，多次读出的场景，且不支持文件的修改。适合用来做数据分析，并不适合用来做网盘应用。

### 1.2、组成

1）HDFS集群包括，NameNode和DataNode以及Secondary Namenode。

2）NameNode负责管理整个文件系统的元数据，以及每一个路径（文件）所对应的数据块信息。

3）DataNode 负责管理用户的文件数据块，每一个数据块都可以在多个datanode上存储多个副本。

4）Secondary NameNode用来监控HDFS状态的辅助后台程序，每隔一段时间获取HDFS元数据的快照。

### 1.3 HDFS 文件块大小

HDFS中的文件在物理上是分块存储（block），块的大小可以通过配置参数( dfs.blocksize)来规定，默认大小在hadoop2.x版本中是128M，老版本中是64M

HDFS的块比磁盘的块大，其目的是为了最小化寻址开销。如果块设置得足够大，从磁盘传输数据的时间会明显大于定位这个块开始位置所需的时间。因而，传输一个由多个块组成的文件的时间取决于磁盘传输速率。

如果寻址时间约为10ms，而传输速率为100MB/s，为了使寻址时间仅占传输时间的1%，我们要将块大小设置约为100MB。默认的块大小128MB。

块的大小：10ms*100*100M/s = 100M

![images](images/HDFS 1-1.png) 

## 二、HFDS命令行操作

1）基本语法
     
     bin/hadoop fs 具体命令
    
2）参数大全
	
	bin/hadoop fs

3）常用命令实操

&emsp;&emsp; （1）-help：输出这个命令参数
		
	        bin/hdfs dfs -help rm
	
&emsp;&emsp; （2）-ls: 显示目录信息
    
            hadoop fs -ls /

&emsp;&emsp; （3）-mkdir：在hdfs上创建目录
       
            hadoop fs  -mkdir  -p  /aaa/bbb/cc/dd

&emsp;&emsp; （4）-moveFromLocal从本地剪切粘贴到hdfs

            hadoop  fs  - moveFromLocal  /home/hadoop/a.txt  /aaa/bbb/cc/dd

&emsp;&emsp; （5）-moveToLocal：从hdfs剪切粘贴到本地（尚未实现）

            [atguigu@hadoop102 hadoop-2.7.2]$ hadoop fs -help moveToLocal
            -moveToLocal <src> <localdst> :
            Not implemented yet

&emsp;&emsp; （6）--appendToFile  ：追加一个文件到已经存在的文件末尾

            hadoop  fs  -appendToFile  ./hello.txt  /hello.txt

&emsp;&emsp; （7）-cat ：显示文件内容

&emsp;&emsp; （8）-tail：显示一个文件的末尾

             hadoop  fs  -tail  /weblog/access_log.1

&emsp;&emsp; （9）-chgrp 、-chmod、-chown：linux文件系统中的用法一样，修改文件所属权限
     
             hadoop  fs  -chmod  666  /hello.txt
             hadoop  fs  -chown  someuser:somegrp   /hello.txt

&emsp;&emsp; （10）-copyFromLocal：从本地文件系统中拷贝文件到hdfs路径去
         
             hadoop  fs  -copyFromLocal  ./jdk.tar.gz  /aaa/

&emsp;&emsp; （11）-copyToLocal：从hdfs拷贝到本地

             hadoop fs -copyToLocal /user/hello.txt ./hello.txt

&emsp;&emsp; （12）-cp ：从hdfs的一个路径拷贝到hdfs的另一个路径

             hadoop  fs  -cp  /aaa/jdk.tar.gz  /bbb/jdk.tar.gz.2

&emsp;&emsp; （13）-mv：在hdfs目录中移动文件

             hadoop  fs  -mv  /aaa/jdk.tar.gz  /

&emsp;&emsp; （14）-get：等同于copyToLocal，就是从hdfs下载文件到本地

             hadoop fs -get /user/hello.txt ./

&emsp;&emsp;（15）-getmerge  ：合并下载多个文件，比如hdfs的目录 /aaa/下有多个文件:log.1, log.2,log.3,...

             hadoop fs -getmerge /aaa/log.* ./log.sum

&emsp;&emsp; （16）-put：等同于copyFromLocal

             hadoop  fs  -put  /aaa/jdk.tar.gz  /bbb/jdk.tar.gz.2

&emsp;&emsp; （17）-rm：删除文件或文件夹
             
             hadoop fs -rm -r /aaa/bbb/

&emsp;&emsp; （18）-rmdir：删除空目录

             hadoop  fs  -rmdir   /aaa/bbb/ccc

&emsp;&emsp; （19）-df ：统计文件系统的可用空间信息
             
             hadoop  fs  -df  -h  /

&emsp;&emsp; （20）-du统计文件夹的大小信息

              [atguigu@hadoop102 hadoop-2.7.2]$ hadoop fs -du -s -h /user/atguigu/wcinput
              188.5 M  /user/atguigu/wcinput

              [atguigu@hadoop102 hadoop-2.7.2]$ hadoop fs -du  -h /user/atguigu/wcinput
              188.5 M  /user/atguigu/wcinput/hadoop-2.7.2.tar.gz
              97       /user/atguigu/wcinput/wc.input


&emsp;&emsp; （21）-count：统计一个指定目录下的文件节点数量
              
              hadoop fs -count /aaa/
              [atguigu@hadoop102 hadoop-2.7.2]$ hadoop fs -count /user/atguigu/wcinput
              1            	2          197657784 /user/atguigu/wcinput
              嵌套文件层级；  包含文件的总数

&emsp;&emsp; （22）-setrep：设置hdfs中文件的副本数量

              hadoop fs -setrep 3 /aaa/jdk.tar.gz

##  三、HDFS 原理

     后续学习



























