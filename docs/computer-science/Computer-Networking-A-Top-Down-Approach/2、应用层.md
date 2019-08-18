# 计算机网络：自顶向下方法
## 应用层
### 1、应用层协议原理
#### 1.1、网络应用程序体系结构
&emsp;&emsp;客户-服务器体系结构(client-server architecture)：有一个总是打开的主机称为服务器，他服务与来自其他客户的主机请求。客服-服务器体系，客户相互之间不直接通信；该服务器具有固定的，周知的地址，客户总能够通过该服务器的IP地址发送分组来与其联系。<br>
&emsp;&emsp;P2P结构(P2P architecture)：对位于数据中心的专用服务器有最小的依赖。应用程序在间断连接的主机对之间使用直接通信，这些主机对称为对等方。自扩展性是其最引人入胜的特性之一。<br>
#### 1.2、进程通信
&emsp;&emsp;1、客户和服务器进程<br>
&emsp;&emsp;&emsp;&emsp;网络应用程序由成对的进程组成的，这些进程通过网络相互发送报文。对每对通信进程，我们通常将这两个进程之一标识位客户(client)，而另一个进程标识为服务器(server)。
     
      在给定的一对进程之间的通信回话场景中，发起通信的进程被标识为客户，在会话开始时等待联系的进程是服务器。
&emsp;&emsp;2、进程与计算机网络之间的接口<br>      
&emsp;&emsp;&emsp;&emsp;多数应用程序是由通信进程对组成的，每对中的两个进程互相发送报文。从一个进程向另一个进程发送的报文必须通过下面的网络。进程通过一个称为套接字(socket)的软件接口向网络发送报文和从网络接收报文。<br>
&emsp;&emsp;3、进程寻址<br> 
&emsp;&emsp;&emsp;&emsp;为了标识接收进程，定义了两种信息：主机的地址和定义在目的主机中的接收进程的标识符。主机地址由其IP地址(IP address)标识。目的地端口号(port number)，用于标识接收进程。<br>
#### 1.3、可供应用程序使用的运输服务
&emsp;&emsp;1、可靠数据传输<br>
&emsp;&emsp;&emsp;&emsp;如果一个协议可以确保由应用程序的一端发送的数据正确、完全的交付给该应用程序的另一端，就是认为提供了可靠数据传输(reliable data transfer)。运输层协议能够潜在地向应用程序提供的一个重要服务是进程到进程的可靠数据传输。当一个运输协议提供这种服务时，发送进程只要将其数据传递进套接字，就可以完全相信该数据能无差错的到达接收进程。<br>
&emsp;&emsp;&emsp;&emsp;当一个运输层协议不提供可靠数据传输时，由发送进程发送的某些数据可能不能到达接收进程。这可能能被容忍丢失的应用（lose-tolerant application）所接受。<br>
&emsp;&emsp;2、吞吐量<br>
&emsp;&emsp;&emsp;&emsp;可用吞吐量就是发送进程能够向接收进程交付比特的速率。<br>
&emsp;&emsp;3、定时<br>
&emsp;&emsp;&emsp;&emsp;运输协议也能提供定时保证。<br>
&emsp;&emsp;4、安全性<br>
&emsp;&emsp;&emsp;&emsp;运输协议能够为应用程序系统一种或多种安全性服务。<br>
#### 1.4、因特网提供的运输服务
&emsp;&emsp;因特网（TCP/IP网络）为应用程序提供两个运输层协议，即UDP和TCP。<br>
&emsp;&emsp;1、TCP服务<br>
&emsp;&emsp;&emsp;&emsp;TCP服务模型包括面向连接服务和可靠数据传输服务。
- 面向连接的服务：在应用程序数据报文开始流动前，TCP让客户和服务器互相交换运输层控制信息。这个过程提示客户端和服务器，使它们为大量分组的到来做准备。在这个阶段后，一个TCP连接(TCP connection)就在两个进程的套接字之间建立了。
- 可靠的数据传输服务：通信进程能够依靠TCP，无差错、按适当顺序交付所有发送的数据。

&emsp;&emsp;&emsp;&emsp;TCP还具有拥塞控制机制，这种服务不一定能为通信进程带来直接的好处，但能为因特网带来整体好处。<br>
&emsp;&emsp;2、UDP服务<br>
&emsp;&emsp;&emsp;&emsp;UDP是一种不提供不必要服务的轻量级运输协议，它仅提供最小服务。UDP是无连接的，因此在两个进程通信前没有握手过程。UDP协议提供一种不可靠数据传送服务，UDP协议并不保证报文发送将到达接收进程。<br>
#### 1.5、应用层协议
&emsp;&emsp;应用层协议(application-layer protocol)：定义了运行在不同端系统上的应用程序进程如何相互传递报文。应用层协议定义了：
- 交换的报文类型，例如请求报文和响应报文。
- 各种报文类型的语法，如报文中的各个字段以及这些字段是如何描述的。
- 字段的语义，即这些字段中包含的信息的含义。
- 一个进程何时以及如何发送报文，对报文进行响应的规则。

&emsp;&emsp;区分网络应用和应用层协议是很重要的。应用层协议只是网络应用的一部分。Web的应用层协议是HTTP，它定义了在浏览器和web服务器之前传输的报文格式和序列。

### 2、Web和HTTP
#### 2.1、HTTP概况
&emsp;&emsp;Web的应用层协议是超文本协议(HyperText Transfer Protocol,HTTP),它是Web的核心。HTTP由两个程序实现：一个客户程序和一个服务器程序。<br>
&emsp;&emsp;Web页面(Web page)(也叫文档)是由对象组成的。一个对象(object)只是一个文件。多数Web页面包含有一个HTML基本文件(base HTML file)以及几个引用对象。<br>
&emsp;&emsp;HTTP定义了Web客户向Web服务器请求的Web页面的方式，以及服务器向客户传送Web页面的方式。<br>
&emsp;&emsp;HTTP使用TCP作为它的支撑运输协议。

#### 2.2、非持续性连接和持续性连接
&emsp;&emsp;当客户-服务器的交互是经TCP进行的，应用程序的研制者就需要做一个重要的决定，即每个请求/响应 对是一个单独TCP连接发送，还是所有的请求及其响应经相同的TCP连接发送呢？前者，该应用程序被称为非持续性连接(non-persistent connection),后者则为持续连接。<br>
&emsp;&emsp;1、采用非持续连接的HTTP<br>
&emsp;&emsp;&emsp;&emsp;如下图所示为一次非持续连接HTTP请求的过程，浏览器和Web服务器之间发起一个TCP连接，需要“三次握手”过程，即客户端向服务器发送一个小TCP报文段，服务器用一个小TCP报文段做出确认和响应，最后，客户端向服务器返回确认。
![network 2-1.png](https://upload-images.jianshu.io/upload_images/7993547-4142083de99700e3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

&emsp;&emsp;2、采用持续连接的HTTP<br>
&emsp;&emsp;&emsp;&emsp;非持续连接有一些缺点。首先，必须为每一个请求的对象建立和维护一个全新的连接。第二、每一个对象经受两倍RTT的交付时延，即一个RTT用于创建TCP，另一个RTT用于请求和接收一个对象。<br>
&emsp;&emsp;&emsp;&emsp;采用持续连接的情况下，服务器在发送响应偶保持该TCP连接打开。在相同的客户和服务器之间的后续请求和响应报文能够通过相同的连接进行传送。
#### 2.3、HTTP报文格式
&emsp;&emsp;HTTP报文有两种：请求报文和响应报文。<br>
&emsp;&emsp;1、HTTP请求报文<br>
![network 2-2.png](https://upload-images.jianshu.io/upload_images/7993547-4059c9cc7f720744.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
&emsp;&emsp;2、HTTP响应报文<br>
![network 2-3.png](https://upload-images.jianshu.io/upload_images/7993547-47513e1aa6904b66.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
#### 2.4、用户与服务器的交互：cookie
&emsp;&emsp;HTTP服务器是无状态的。HTTP使用了cookie。它允许站点对用户进行跟踪。
#### 2.5、Web缓存
&emsp;&emsp;Web缓存器(Web cache)也叫代理服务器(proxy server)，它能够代表初始Web服务器来满足HTTP请求的网络实体。Web缓存器有自己的磁盘存储空间，并在存储空间中保存最近请求过的对象副本。

#### 2.6、条件GET方法
&emsp;&emsp;HTTP协议有一种机制，允许缓存器验证它的对象是最新的。这种机制的条件GET(conditional GET)方法。如果：请求报文使用GET方法；并且请求报文中包含一个“If-Modifyed-Since：”首部行。那么，这个HTTP请求报文就是一个条件GET请求报文。<br>

### 3、文件传输协议：FTP
&emsp;&emsp;HTTP和FTP都是文件传输协议，并且有很多共同的特点，它们都是运行在TCP上。它们的主要区别是FTP使用了两个并行的TCP连接来传输文件，一个是控制连接(control connection),一个是数据连接(data connection)
#### FTP命令和回答
&emsp;&emsp;从客户到服务器的命令和从服务器到客户的回答，都是以7比特ASCII格式在控制连接上传送的。为了区分连续的命令，每个命令后跟回车换行符。每个命令由4个大写字母ASCII字符组成，还有一些具有可选参数。<br>
&emsp;&emsp;较为常见的命令如下：<br>
- USER username：用于向服务器传送用户表示
- PASS password：用于向服务器发送用户口令
- LIST :用于请求服务器回送当前远程目录中的所有文件列表。
- RETR filename：用于从远程主机当前目录检索文件。
- STOR filename：用于在远程主机的当前目录上存放文件。

&emsp;&emsp;一些典型的回答如下所示：<br>
- 331 Username OK,Password required(用户名OK，需要口令)
- 125 Data connection already open;transfer starting(数据连接已经打开，开始传送)
- 425 Can't open data connection (无法打开数据连接)
- 452 Error writing file(写文件差错)

### 4、因特网中的电子邮件
&emsp;&emsp;因特网电子邮件系统，它有是三个主要组成部分：用户代理(user agent)、邮件服务器(mail server)和简单邮件传输协议(Simple Mail Transfer Protocol,SMTP)。<br>
&emsp;&emsp;邮件服务器形成了电子邮件体系结构的核心。SMTP是因特网电子邮件中主要的应用层协议。它使用TCP可靠传输服务，从发送方的邮件服务器向接收方的邮件服务器发送邮件。<br>
&emsp;&emsp;1、SMTP<br>
&emsp;&emsp;&emsp;&emsp;SMTP是因特网电子邮件应用的核心。所有邮件报文的体部分只能采用简单的7比特ASCII码表示。<br>
&emsp;&emsp;2、与HTTP对比<br>
&emsp;&emsp;&emsp;&emsp;当进行文件传送时，持续的HTTP和SMTP都使用持续连接。两者之间还有一些重要区别：首先，HTTP主要是一个拉协议(pull protocol)。另一方面，SMTP基本上是一个推协议(push protpcol)，即发送邮件服务器把文件推向接收邮件服务器。<br>
&emsp;&emsp;&emsp;&emsp;第二个区别就是SMTP要求每个报文使用7比特ASCII码格式。HTTP数据则不受这种限制。<br>
&emsp;&emsp;&emsp;&emsp;第三个区别在于如何处理一个既包含文本又包含图形的文档。HTTP把每个对象封装到它自己的HTTP响应报文中，而SMTP则把所有报文对象放在一个报文之中。<br>
&emsp;&emsp;3、邮件访问协议<br>
&emsp;&emsp;&emsp;&emsp;目前有一些流行的邮件访问协议，包括第三版的邮局协议(Post Office Protocol-Version 3,POP3)、因特网邮件访问协议(Internet Mail Access Protocol,IMAP)以及HTTP。<br>
&emsp;&emsp;POP3<br>
&emsp;&emsp;&emsp;&emsp;POP3是一个极为简单的邮件访问协议。<br>
&emsp;&emsp;IMAP<br>
&emsp;&emsp;&emsp;&emsp;IMAP是一个邮件访问协议，IMAP服务器把每个报文与一个文件夹联系起来；当报文第一次到达服务器时，它与收件人的INBOX文件夹相关联。收件人则能够把邮件移到一个新的、用户创建的文件夹中，阅读、删除邮件等。<br>
&emsp;&emsp;&emsp;&emsp;IMAP的另一个重要的特性是它具有允许用户代理获取报文组件的命令。<br>
&emsp;&emsp;基于web的电子邮件<br>
&emsp;&emsp;&emsp;&emsp;今天越来越多的用户使用他们的Web浏览器收发电子邮件。使用这种服务，用户代理就是普通的浏览器，用户和他远程邮箱之间的通信则通过HTTP进行。<br>

### 5、DNS:因特网的目录服务
#### 1、DNS提供的服务
&emsp;&emsp;识别主机有两种方式，通过主机名或者IP地址。域名系统(Domain Name System,DNS)就是一种能进行主机名到IP地址转换的目录服务。DNS是：一个由分层的DNS服务器(DNS server)实现的分布式数据库；一个使得主机能够查询分布式数据库的应用层协议。DNS服务器通常运行BIND(Berkeley Internet Name Domain)软件的UNIX机器。DNS协议运行在UDP之上，使用53号端口。<br>
&emsp;&emsp;DNS通常是由其他应用层协议所使用的，包括HTTP、SMTP、FTP，将用户提供的主机名解析为IP地址。解析IP地址的过程如下：<br>
- 同一台用户主机上运行着DNS应用的客户端。
- 浏览器从URL中抽取出主机名 www.baidu.com，并将这台主机名传给DNS应用程序的客户端。
- DNS客户向DNS服务器发送一个包含主机名称的请求。
- DNS客户端最终会收到一份回答报文，其中包含有对应于该主机名的IP地址。
- 一旦浏览器接收到来自DNS的该IP地址，它能够向位于该IP地址80端的HTTP服务器进程发起TCP连接。

&emsp;&emsp;DNS还提供了一些重要的服务：<br>
- 主机别名(host aliasing)。有着复杂主机名的主机能拥有一个或者多个别名。
- 邮件服务器别名(mail server aliasing)。
- 负载分配(load distributing)。DNS也用于在冗余的服务器之间进行负载分配。

#### 2、DNS工作机理概述
&emsp;&emsp;1、分布式、层次数据库<br>
&emsp;&emsp;&emsp;&emsp;为了处理扩展性问题，DNS使用了大量的DNS服务器，它们以层次方式组织，并且分布在全世界范围内，没有一台DNS服务器拥有因特网上所有主机的映射。大致来说，有3种类型的DNS服务器：根DNS服务器、顶级域(Top_Level Domain,TLD)DNS服务器和权威DNS服务器。
- 根DNS服务器。在因特网上有13个根DNS服务器(标号为A到M),它们中的大部分位于北美洲。尽管我们将这13个根DNS服务器中的每个都视为单个的服务器，但每台服务器实际上是一个冗余服务器的网络，以提供安全性和可靠性。
- 顶级域(DNS)服务器。这些服务器负责顶级域名如com、org、net、edu、和gov，以及所有国家的顶级域名域名如uk、fr、ca和jp。
- 权威DNS服务器。在因特网上具有公共可访问的主机的每个组织必须提供公共可访问的DNS记录，这些记录将这些主机的名字映射为IP地址。

&emsp;&emsp;&emsp;&emsp;还有一种重要的DNS，称为本地DNS服务器(local DNS server)。一个本地DNS服务器严格来说并不属于该服务器的层次结构，但它对DNS层次结构是重要的。每个ISP都有一台本地DNS服务器。

&emsp;&emsp;2、DNS缓存<br>
&emsp;&emsp;&emsp;&emsp;DNS 缓存(DNS caching),为了改善时延性能并减少在因特网上到处传输的DNS报文数量，DNS广泛使用了缓存技术。DNS缓存的原理：在一个请求链中，当某DNS服务器接收到一个DNS回答时，它能将该回答中的信息缓存在本地存储器中。<br>
&emsp;&emsp;3、DNS记录和报文
&emsp;&emsp;&emsp;&emsp;共同实现DNS分布式数据库的所有DNS服务器存储了资源记录(Resource Record,RR)，RR提供了主机名到IP地址的映射。每个DNS回答都包含了一条或者多条资源记录。<br>
&emsp;&emsp;DNS报文<br>
&emsp;&emsp;&emsp;&emsp;DNS只有查询和回答两种报文，并且有着相同的格式。如下图所示：<br>
![network 2-6.png](https://upload-images.jianshu.io/upload_images/7993547-712188ffe2a76165.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
&emsp;&emsp;在DNS数据库中插入记录  
### 6、P2P应用
&emsp;&emsp;P2P设计的应用有两种，第一种是文件分发，其中应用程序从单个源向大量的对等方分发一个文件，流行的是BitTorrent协议。第二种应用是分布在大型对等方社区中的数据库，对于这个应用，我们将探讨分布式散列表(Distributed Hash Table,DHT)的概念<br>
#### 1、P2P文件分发
&emsp;&emsp;1、P2P体系结构的扩展性<br>

&emsp;&emsp;2、BitTorrent<br>
&emsp;&emsp;&emsp;&emsp;BitTorrent是一种用于文件分发的流行P2P协议。用BitTorrent术语来讲，参与一个特定的文件分发的所有对等方的集合被称为一个洪流(torrent)。在一个洪流中的对等方彼此下载等长度的文件快(chunk),典型的块长度为256k。当一个对等方首次加入一个洪流时，它没有块。随着时间的流逝，它积累了越来越多的块。当它下载块时，也为其他对等方上传了多个块。一旦某个对等方获得了整个文件，它也许离开洪流，或留在洪流中并继续向其他对等方上传块。同时，任何对等方可能在任何时候仅具有块的子集就离开洪流，并在以后重新加入洪流中。<br>

#### 2、分布式散列表
&emsp;&emsp;构建这样一个数据库直接采用客户-服务器体系结构，以在一个中心服务器中存储所有键值对。我们将允许任何对等方用一个特别地键来查询该分布式数据库。分布式数据库则将定位拥有该相应键值对的对等方，然后向查询的对等方返回该键值对。任何对等方也将允许在数据库插入新键值对。这样一种分布式数据库被称为分布式散列表(Distributed Hash Table,DHT)。<br>
&emsp;&emsp;1、环形DHT<br>
&emsp;&emsp;&emsp;&emsp;为了处理规模问题，我们将对等方组织为一个环。在这种环形设置中，每个对等方仅与它的直接后继和直接前任联系。对等方的这种环形设置是覆盖网络的一种特殊情况。在一个覆盖网络中，对等方形成了一个抽象的逻辑网，该网络存在于由物理链路、路由器和主机组成的底层计算机网络之上。在覆盖网络中的链路不是物理链路，而仅是对等方之间的虚拟联络。一条单一的覆盖链路通常使用了底层网络中的许多条物理链路和物理路由器。<br>
&emsp;&emsp;&emsp;&emsp;为了减少每个对等方必须管理的覆盖信息的数量，环形DHT提供了一种非常精确有效的解决方案。特别是，每个对等方只需要知道两个对等方，即它的直接后继和直接前任。<br>
&emsp;&emsp;2、对等扰动<br>
&emsp;&emsp;&emsp;&emsp;在P2P中，对等方能够不加警示地到来和离去。我也必须关注存在这种对等方扰动时维护DHT的情况。<br>

### 7、TCP套接字编程
&emsp;&emsp;网络应用程序有两类。一类是实现在协议标准中所定义的操作。另一类网络应用程序时专用的网络应用程序，由客户和服务器程序应用的应用层协议没有公开发布在某RFC中或其他地方。<br>
&emsp;&emsp;1、UDP套接字编程<br>
![network 2-4.png](https://upload-images.jianshu.io/upload_images/7993547-5d0d19f7560a7029.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
&emsp;&emsp;2、TCP套接字编程<br>
![network 2-5.png](https://upload-images.jianshu.io/upload_images/7993547-e00be8b52e1017ce.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
