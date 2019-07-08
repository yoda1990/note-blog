##1、ls命令
     1、命令格式： ls [选项] [目录名]
     2、命令功能： 列出目标目录中所有的子目录和文件
     3、常用参数：
        -a,-all ：列出目录下的所有文件，包括以.开头的隐含文件
        -A 同 -a，但不列出"."和".."
        -c 配合 -lt ：根据ctime 排序及显示ctime 配合 -l：显示ctime，但根据名称排序否则，根据ctime排序
        -C ：每栏由上至下列出项目
        -color[=WHEN] 控制是否使用色彩分辨文件。WHEN 可以是‘never’、‘always’、‘auto’其中之一
        -d：-directory：将目录像文件一样显示，而不是显示其下的文件
        -D，-dired 产生合适Emacs的dired模式使用的结果
        -f:对输出的文件不进行排序，-aU：选项生效，-lst：选项失效
        ...
     4、常用范例：
        1、列出/home/peidachang文件夹下的所有文件和目录的详细资料
           ls -l -R /home/peidachang
           ls -lR /home/peidachang
        2、列出当前目录中所有以“t” 开头的目录的详细内容
           ls -l t*
        3、列出/opt/soft文件夹下面的子目录
           ls -F /opt/soft | grep /$
## 2、cd 命令
    1、 命令格式： cd 目录名
    2、 命令功能： 切换当前目录至dirName
    3、 常用范例
        cd /   说明：进入系统根目录
        cd .. 或者 cd ..//  目录回退
        cd ../..//   使用cd命令实现进入当前目录的父目录的父目录
        使用cd命令进入当前用户主目录
        cd 或者 cd ~
        跳转到指定目录
        cd /opt/soft
        返回进入此目录之前所在的目录
        cd - 
        把上个命令的参数作为cd参数使用
        cd !$
## 3、pwd命令
     1、命令格式：pwd [选项]
     2、命令功能：查看当前工作目录的完整路径
     3、常用参数：-P 显示出实际路径，而非使用连接路径
     4、常用范例：
        查看默认工作目录的完成路径
        pwd
        查看指定文件夹
        pwd
        显示出实际路径
        pwd -P
        
        /bin/pwd
        /bin/pwd [选项]
## 4、mkdir 命令
     1、命令格式：mkdir [选项] 目录
     2、命令功能：指定位置创建以 DirName(指定的文件名)命名的文件夹或目录。
     3、命令参数： -m, --mode=模式，设定权限<模式> (类似 chmod)，而不是 rwxrwxrwx 减 umask
                  -p, --parents  可以是一个路径名称。此时若路径中的某些目录尚不存在,加上此选项后,系统将自动建立好那些尚不存在的目录,即一次可以建立多个目录;
                  -v, --verbose  每次创建新目录都显示信息
                  --help   显示此帮助信息并退出
                  --version  输出版本信息并退出                
     4、命令实例：
        创建一个空目录
        mkdir test1
        递归创建多个目录
        mkdir -p test2/test22
        创建权限为777的目录
        mkdir -m 777 test3
        创建新目录都显示信息
        mkdir -v test4
        一个命令创建项目结构：
        mkdir -vp scf/{lib/,bin/,doc/{info,product},logs/{info,product},service/deploy/{info,product}}                       
## 5、rm 命令        