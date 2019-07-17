# Hadoop
## 1、什么是Hadoop?
    1、HADOOP通常是指一个更广泛的概念——HADOOP生态圈。
    2、Hadoop组成
         1) Hadoop HDFS：一个高可靠、高吞吐量的分布式文件系统。
         2）Hadoop MapReduce：一个分布式的离线并行计算框架。
         3）Hadoop YARN：作业调度与集群资源管理的框架。
         4）Hadoop Common：支持其他模块的工具模块。
         
         HDFS架构概述：
            1)、NameNode(nn)：存储文件的元数据，如文件名，文件目录结构，文件属性（生成时间、副本数、文件权限），以及每个文件的块列表和块所在的DataNode等。
            2）DataNode(dn)：在本地文件系统存储文件块数据，以及块数据的校验和。
            3）Secondary NameNode(2nn)：用来监控HDFS状态的辅助后台程序，每隔一段时间获取HDFS元数据的快照。
         YARN架构概述
            1）ResourceManager(rm)：处理客户端请求、启动/监控ApplicationMaster、监控NodeManager、资源分配与调度；
            2）NodeManager(nm)：单个节点上的资源管理、处理来自ResourceManager的命令、处理来自ApplicationMaster的命令；
            3）ApplicationMaster：数据切分、为应用程序申请资源，并分配给内部任务、任务监控与容错。
            4）Container：对任务运行环境的抽象，封装了CPU、内存等多维资源以及环境变量、启动命令等任务运行相关的信息。
         MapReduce架构概述
            MapReduce将计算过程分为两个阶段：Map和Reduce
            1）Map阶段并行处理输入数据
            2）Reduce阶段对Map结果进行汇总
![images](images/hadoop 1-1.png)    
     
    3、Hadoop 安装
            