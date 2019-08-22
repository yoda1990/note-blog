### 1、在阿里云购买云服务器或者虚拟机安装Linux。
&emsp;&emsp;关于linux系统，可以在阿里云购买云服务器或者利用虚拟机安装CentOs系统。我用的就是阿里云的云服务器，比较方便吧。

### 2、安装Emqx
    安装必要的依赖：
    $ sudo yum install -y yum-utils device-mapper-persistent-data lvm2

    设置稳定的仓库，比如CentOs7的例子：
    $sudo yum-config-manager --add-repo https://repos.emqx.io/emqx-ce/redhat/centos/7/emqx-ce.repo

    安装最新版本的 EMQ X
    $ sudo yum install emqx
    
    也可以安装指定版本
    先查询软件版本列表
    $ yum list emqx --showduplicates | sort -r

    emqx.x86_64                     3.1.0-1.el7                        emqx-stable
    emqx.x86_64                     3.0.1-1.el7                        emqx-stable
    emqx.x86_64                     3.0.0-1.el7                        emqx-stable
    
    选择其中一个版本安装
    
    $ sudo yum install emqx-3.1.0
    
### 4、启动Emqx
    直接启动
    $ emqx start
      emqx 3.1.0 is started successfully!

    $ emqx_ctl status
      Node 'emqx@127.0.0.1' is started
      emqx v3.1.0 is running
      
    系统启动
    $ sudo systemctl start emqx
    
    服务启动
    $ sudo service emqx start
    
### 5、访问Web后台界面
&emsp;&emsp;在访问后台界面时，应该先开放Emqx对应的端口。如下：

    端口    端口对应的协议或者作用
    1883	MQTT protocol port
    8883	MQTT/SSL port
    8083	MQTT/WebSocket port
    8080	HTTP API port
    18083	Dashboard Management Console Port

&emsp;&emsp;在虚拟机安装的Linux 则使用该方式放开端口： 
    
    iptables -A INPUT -ptcp --dport  1883 -j ACCEPT
    iptables -A INPUT -ptcp --dport  8883 -j ACCEPT
    iptables -A INPUT -ptcp --dport  8083 -j ACCEPT
    iptables -A INPUT -ptcp --dport  8080 -j ACCEPT
    iptables -A INPUT -ptcp --dport  18083 -j ACCEPT
    
    保存操作
    service iptables save
    
&emsp;&emsp;在阿里云则在对应的云服务器的安全组中添加对应的开放端口。如下操作：
    
&emsp;&emsp;登录阿里云后台->进入控制台->点击云服务器ECS->实例列表中找到响应的示例->点击更多->
    找到网络和安全组->点击安全组配置->看见响应的安全组列表，然后点击配置规则->在出入方向 中都添加如下配置
![1、阿里云安全组配置.png](https://upload-images.jianshu.io/upload_images/7993547-9af3a11b8846625a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
&emsp;&emsp;访问后台地址：http://localhost:18083，其中localhost可以替换为你的云服务器公网IP或者虚拟机IP。登录账号：admin，密码：public。进入Web管理控制台。如下图所示：
![2、web控制台.png](https://upload-images.jianshu.io/upload_images/7993547-eadf77b6bfddb372.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
### 6、测试Emqx 服务是否可用
&emsp;&emsp;本次用到的测试工具是常见的MQTTBox

&emsp;&emsp;MQTTBox官网下载地址：http://workswithweb.com/html/mqttbox/downloads.html

&emsp;&emsp;下载完成后，直接安装即可。

&emsp;&emsp;安装完成后打开客户端，如下所示：
![图3、打开客户端.png](https://upload-images.jianshu.io/upload_images/7993547-775deca347c11db6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

&emsp;&emsp;点击"Create MQTT Client"后,显示如下：
![图4、配置Client.png](https://upload-images.jianshu.io/upload_images/7993547-7ab23bd39ef1cf36.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

&emsp;&emsp;上图中，在ClientName中填上客户端名称，比如Test_Client;在Protocol中选择 'mqtt/tcp' 这个选项；在Host 中填上 127.0.0.1:1883,其中127.0.0.1需要替换成自己的与服务器公网IP或者虚拟机IP。点击save，进入如下界面：
![图5、测试PubOrSub.png](https://upload-images.jianshu.io/upload_images/7993547-1b40a7f22702c685.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

&emsp;&emsp;应先开启一个订阅，如上图所示。"Topic to subscribe" 里填入要订阅的主题"test"；"QoS" 字段选择 "0 - Almost Once" ；然后点击 "Subscribe" 按钮。

&emsp;&emsp;后发布一条消息，如上图所示。"Topic to publish" 中输入 "test" ，这里输入的主题的名字必须和订阅那里的输入相同；"QoS" 中选择 "0 - Almost Once" ；"Payload" 中输入任何内容都可以，如下图所示输入了一组JSON字符串；所有内容输入完毕之后，点击"Publish"按钮。测试成功如下图显示：
![图6、测试成功图.png](https://upload-images.jianshu.io/upload_images/7993547-5dc781bd996cffec.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

&emsp;&emsp;测试成功，说明Emqx服务可用，接下来应该测试用于设备上了。这边打算引用的ClientSDK 为Java 语言的 MqttClient。

&emsp;&emsp;MqttClient 的GitHub地址：https://github.com/fusesource/mqtt-client 。


### 7、应用MqttClient-Java SDK
&emsp;&emsp;1.Maven中引入如下依赖：
    
    <dependency>
		<groupId>org.fusesource.mqtt-client</groupId>
		<artifactId>mqtt-client</artifactId>
		<version>1.9</version>
	</dependency>

&emsp;&emsp;2.创建一个MqttSubscriber.java 文件，代码如下：

    public class MqttSubscriber {

    /**
     * MQTT 的 IP 地址
     */
    public static final String  MQTT_SERVER_URL="x.x.x.x";

    public static void main(String[] args) throws Exception {
        MQTT mqtt = new MQTT();
        mqtt.setHost(MQTT_SERVER_URL, 1883);
        BlockingConnection connection = mqtt.blockingConnection();
        connection.connect();
        Topic[] topics = {new Topic("Java_Test", QoS.AT_LEAST_ONCE)};
        byte[] qoses = connection.subscribe(topics);
        Message message = connection.receive();
        System.out.println(message.getTopic());
        byte[] payload = message.getPayload();
        System.out.println("打印接收到的消息："+new String(payload));
        message.ack();
        connection.disconnect();
       }
    }

&esmp;&emsp;3.创建一个MqttPublisher.java 文件，代码如下：

    public class MqttPublisher {

    public static void main(String[] args) throws Exception {
        MQTT mqtt = new MQTT();
        mqtt.setHost(MqttSubscriber.MQTT_SERVER_URL, 1883);
        BlockingConnection connection = mqtt.blockingConnection();
        connection.connect();
        connection.publish("Java_Test", "Java".getBytes(), QoS.AT_LEAST_ONCE, true);
        System.out.println("执行发送消息。。。。");
      }
    }

&emsp;&emsp;4.先执行MqttSubscriber的main函数，后执行MqttPublisher的main函数。测试成功后控制带输出如下图所示：
![图7、publisher控制台.png](https://upload-images.jianshu.io/upload_images/7993547-fd4d8a0b54e410bb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![图8、subscriber控制台.png](https://upload-images.jianshu.io/upload_images/7993547-60fc22719667637a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

### 8、总结
&emsp;&emsp;EMQ X 是一个为移动互联和物联网设计的轻量级的publish-subscribe消息中间件。支持当前主流的 MQTT v3.1.1 and v5.0。示意图如下：
![图9、pub-sub示意图.png](https://upload-images.jianshu.io/upload_images/7993547-24a375907ebb891c.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

&emsp;&emsp;这边只是对MQTT的一些粗浅应用和认识，如果想对EMQ X有更深入的了解，可以观看其项目官方文档：https://docs.emqx.io/broker/v3/en/guide.html 。

一些参考资料：

EMQ X官方文档：https://docs.emqx.io/broker/v3/en/guide.html

Mqtt_Box官方文档：http://workswithweb.com/html/mqttbox/getstarted.html

Mqtt_Client GitHub：https://github.com/fusesource/mqtt-client

Mqtt GitHub：https://github.com/mqtt/mqtt.github.io
