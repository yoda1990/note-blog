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
     1、命令格式： rm [选项] 文件
     2、命令功能：删除一个目录的一个或者多个文件，删除文件，通常仍可以将该文件恢复原状。
     3、命令参数：
        -f ：忽略不存在的文件，从不给提示
        -i ：进行交互删除
        -r ：指示rm将参数中列出的全部目录和子目录均递归的删除。
        -v ：详细显示进行的步骤
        --help：显示此帮助信息并退出
        --version：输出版本信息并退出
     4、命令实例：
        删除文件file
        rm 文件名
        强行删除file
        rm -f log1.log
        删除任何.log文件；删除前逐一询问确认 
        rm -i *.log
        将test1子目录及子目录中所有档案删除
        rm -r test1
        rm -rf 命令会将test2子目录及子目录中所有档案删除,并且不用一一确认
        rm -rf test2
        删除以 -f 开头的文件
        rm -- -f
## 6、 rmdir 命令  
     1、命令格式：rmdir [选项] 目录
     2、命令功能：该命令从一个目录中删除一个或多个子目录项，删除某目录时也必须具有对父目录的写权限。
     3、命令参数：
        -p：递归删除目录
        -v：显示指令执行过程
     4、命令实例：
        rmdir 不能删除非空目录
        rmdir doc
        
        rmdir -p 当子目录被删除后使它也成为空目录的话，则顺便一并删除 
        rmdir -p logs
        
## 7、mv命令
     1、 命令格式：mv [选项] 源文件或目录 目标文件或目录
     2、 命令功能：移动源文件或者目录
     3、 命令参数：
         -b：若需覆盖文件，则覆盖前先行备份
         -f：不询问，直接覆盖
         -i：若目标文件已经存在，询问是否覆盖
         -u：若目标文件已经存在，且source比较新，才会更新
         -t：--target-directory=DIRECTORY move all SOURCE arguments into DIRECTORY，即指定mv的目标目录，该选项适用于移动多个源文件到一个目录的情况，此时目标目录在前，源文件在后。
     4．命令实例：
        文件改名
        mv test.log test1.txt
        移动文件
        mv test1.txt test3
        将文件log1.txt log2.txt,log3.txt移动到目录test3中
        mv log1.txt log2.txt log3.txt test3
        mv -t /opt/soft/log.txt log2.txt log3.txt
        将文件file1改名为file2，如果file2已经存在，则询问是否覆盖
        mv -i log1.txt log2.txt
        将文件file1改名为file2，即使file2存在，也是直接覆盖掉 
        mv -f log1.txt log2.txt   
        目录的移动
        mv dir1 dir2
        移动当前文件夹下的所有文件到上一级目录
        mv * ../
        把当前目录的一个子目录里的文件移动到另一个子目录里
        mv test3/*.txt test5
        文件被覆盖前做简单备份，前面加参数-b
        mv log1.txt -b log2.txt
## 8、cp 命令
    1、命令格式：
       cp [选项]... [T] 源 目的
       cp [选项]... 源...  目录
       cp [选项]... -t 目录 源...
    2、命令功能：
       将源文件复制至目标文件，或将多个源文件复制至目标目录。
    3、命令参数：
       -a,--archive 等于 -dR --preserve=all --backup[=CONTROL 为每个已存在的目标文件创建备份
       -b 类似 --backup 但不接收参数
       --copy-contents 在递归处理是复制特殊文件内容
       -d 等于 --no-dereference --preserve=links
       -f,--force 如果目标文件无法打开则将其移除并重试（当 -n 选项存在时则不需要再选此项）
       -i , --interactive 覆盖前询问（使前面的 -n 选项失效）
       -H                跟随源文件中的命令行符号链接
       -l, --link            链接文件而不复制
       -L, --dereference   总是跟随符号链接
       -n, --no-clobber   不要覆盖已存在的文件(使前面的 -i 选项失效)
       -P, --no-dereference   不跟随源文件中的符号链接
       -p                等于--preserve=模式,所有权,时间戳
       --preserve[=属性列表   保持指定的属性(默认：模式,所有权,时间戳)，如果可能保持附加属性：环境、链接、xattr 等
       -R, -r, --recursive  复制目录及目录内的所有项目 
    4、命令实例：
       复制单个文件到目标目录，文件在目标文件中不存在
       cp log.log test5
       目标文件存在时，会询问是否覆盖
       cp log.log test5
       复制整个目录
       cp -a test3 test5 
       复制的 log.log 建立一个连结档 log_link.log 
       cp -s log.log log_link.log
## 9、touch 命令
    1、命令格式：
       touch [选项]... 文件...
    2、命令功能：
       touch 命令参数可更改文档或目录的日期时间，包括存取时间和更改时间   
    3、命令参数
       -a 或 --time=atime或--time=access或--time=use 只更改存取时间
       -c 或 --no-create 不建立任何文档
       -d 使用指定的日期时间，而非现在的时间
       -f 此参数将忽略不予处理，仅负责解决BSD版本touch指令的兼容性问题
       -m 或 --time=mtime或--time=modify 只更改变动时间
       -r 把指定文档或目录的日期，统统设成和参考文档或目录的日期时间相同。
       -t 使用指定的日期时间，而非现在时间
    4、命令实例：
       创建不存在的文件
       touch log2012.log log2013.log
       更新log.log的时间和log2012.log时间戳相同
       touch -r log.log log2012.log
       设定文件的时间戳
       touch -t 201211122234.50 log.log
## 10、cat 命令      
    1、命令格式：
       cat [选项] [文件]...
    2、命令功能：
       显示整个文件：cat fileName
       从键盘创建一个文件：cat > filename 只能创建新文件，不能编辑已有文件
       将几个文件合并为一个文件：cat file1 file2 > file
    3、命令参数：
       -A,--show-all 等价于 -vET
       -b,--number-nonblank 对非空输出行编号
       -e 等价于 -vE
       -E，--show-ends 每行结束处显示 $
       -n,--number 对输出的所有行编号，由1开始对所有输出的行数编号
       -s,--squeeze-blank 有连续两行以上的空白行，就代换为一行的空白行
       -t 与 -vT等价
       -T, --show-tabs 将跳格字符显示为 ^T
       -u 被忽略
       -v，--show-nonprinting 使用^和M- 引用，除了LFD和TAB 之外
    4、使用实例：
       把 log2012.log 的文件内容加上行号后输入 log2013.log 这个文件里
       cat -n log2012.log log2013.log
       
       把 log2012.log 和 log2013.log 的文件内容加上行号（空白行不加）之后将内容附加到 log.log 里
       cat -b log2012.log log2013.log log.log
       
       把 log2012.log 的文件内容加上行号后输入 log.log 这个文件里
       cat -n log2012.log > log.log
       cat -n log.log
       
                                              