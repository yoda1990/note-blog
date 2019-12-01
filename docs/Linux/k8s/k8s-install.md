## 1、Kubernetes 安装

### CentOs 7 单机 安装 K8S

1、关闭防火墙，selinux,swapoff

    systemctl disable firewalld #停止firewall
    systemctl stop firewalld #禁止firewall开机启动
    firewall-cmd --state #查看防火墙状态
    swapoff -a
     
    # 临时关闭
    $ setenforce 0  
    # 永久关闭
    $ vim /etc/selinux/config 
    SELINUX=disabled
    
2、 yum 安装 k8s   

    yum remove etcd kubernetes
    
    yum install -y etcd kubernetes
    
3、修改配置
 
    修改配置
    
    /etc/sysconfig/docker 修改OPTIONS='--selinux-enabled=false --insecure-registry gcr.io'并重启docker
    /etc/kubernetes/apiserver KUBE_ADMISSION_CONTROL项删除ServiceAccount   
    
    // 编辑docker配置信息
    vi /etc/sysconfig/docker
    
    // 配置信息局部示例：
    ##OPTIONS='--selinux-enabled --log-driver=journald --signature-verification=false'
    OPTIONS='--selinux-enabled=false --insecure-registry gcr.io'
    
    // 重启docker容器
    service docker restart
    
    // 编辑 kubernetes配置信息
    vi /etc/kubernetes/apiserver
    
    // 配置信息局部示例：
    # default admission control policies
    #KUBE_ADMISSION_CONTROL="--admission-control=NamespaceLifecycle,NamespaceExists,LimitRanger,SecurityContextDeny,ServiceAccount,ResourceQuota"
    KUBE_ADMISSION_CONTROL="--admission-control=NamespaceLifecycle,NamespaceExists,LimitRanger,SecurityContextDeny,ResourceQuota"
    
4、启动服务

    systemctl start etcd
    systemctl start docker
    systemctl start kube-apiserver
    systemctl start kube-controller-manager
    systemctl start kube-scheduler
    systemctl start kubelet
    systemctl start kube-proxy
    

5、验证

    // 产看版本
    kubectl version
    
    // 组将状态
    kubectl get componentstatus
    
    // 查看进程
    ps -ef|grep kube
    
    // 信息
    kubectl cluster-info
    
    // 节点
    kubectl get nodes
    
5、简单实验

   Docker 镜像。
   
     部署自己的镜像：
     查看镜像
     docker images
     
     部署镜像：
     kubectl run <命名> --image=<REPOSITORY> --replicas=2 --port=<端口号>
     
     eg:
     kubectl run myk8s-pod --image=base_tomcat --replicas=2 --port=80
     
     查看 pods： kubectl get pods
     
     查看 deployments： kubectl get deployments
     
     产看 pod 信息
     
     kubectl describe pod pod的Name
     eg: kubectl describe pod myk8s-pod-1394982580-11h8h
     
     删除pod：kubectl delete podName
     
     彻底删除pod：kubectl delete deployment myk8s-pod(名称前缀)
     
     
                
    
    
    
    
    
     

