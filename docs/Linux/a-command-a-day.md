#  每日一命令
##  一. 文件目录操作命令：
## 1、ls命令
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
## 11、nl 命令
    1、命令格式：
       nl [选项]... [文件]...
    2、命令功能：
       nl 命令读取 File 参数          
    3、命令参数：
       -b  ：指定行号指定的方式，主要有两种：
       -b a ：表示不论是否为空行，也同样列出行号(类似 cat -n)；
       -b t ：如果有空行，空的那一行不要列出行号(默认值)；
       -n  ：列出行号表示的方法，主要有三种：
       -n ln ：行号在萤幕的最左方显示；
       -n rn ：行号在自己栏位的最右方显示，且不加 0 ；
       -n rz ：行号在自己栏位的最右方显示，且加 0 ；
       -w  ：行号栏位的占用的位数。
       -p 在逻辑定界符处不重新开始计算。 
    4、命令实例：
       用 nl 列出 log2012.log 的内容
       nl log2012.log
      
       用 nl 列出 log2012.log 的内容，空本行也加上行号
       nl -b a log2012.log
      
       让行号前面自动补上0,统一输出格式
       nl -b a -n rz log2014.log 
       
## 12、more命令
    1、命令格式：
       more [-dlfpcsu ] [-num ] [+/ pattern] [+ linenum] [file ... ] 
    2、命令功能：
       more命令和cat的功能一样都是查看文件里的内容，但有所不同的是more可以按页来查看文件的内容，还支持直接跳转行等功能。
    3、命令参数:
       +n      从笫n行开始显示
       -n       定义屏幕大小为n行
       +/pattern 在每个档案显示前搜寻该字串（pattern），然后从该字串前两行之后开始显示  
       -c       从顶部清屏，然后显示
       -d       提示“Press space to continue，’q’ to quit（按空格键继续，按q键退出）”，禁用响铃功能
       -l        忽略Ctrl+l（换页）字符
       -p       通过清除窗口而不是滚屏来对文件进行换页，与-c选项相似
       -s       把连续的多个空行显示为一行
       -u       把文件内容中的下画线去掉
    4、命令示例：
       显示文件中从第3行起的内容
       more +3 log2012.log
       
       从文件中查找第一个出现"day3"字符串的行，并从该处前两行开始显示输出 
       more +/day3 log2012.log
       
       设定每屏显示行数 
       more -5 log2012.log
       
       列一个目录下的文件，由于内容太多，我们应该学会用more来分页显示。这得和管道 | 结合起来 
       ls -l  | more -5
## 13、less命令       
    1、命令格式：
       less [参数] 文件
    2、命令功能：
       less 与 more 类似，但是less可以随意浏览文件，而more只能向前移动，而且less 在查看之前不会加载整个文件。
    3、命令参数：
       -b <缓冲区大小> 设置缓冲区的大小
       -e  当文件显示结束后，自动离开
       -f  强迫打开特殊文件，例如外围设备代号、目录和二进制文件
       -g  只标志最后搜索的关键词
       -i  忽略搜索时的大小写
       -m  显示类似more命令的百分比
       -N  显示每行的行号
       -o <文件名> 将less 输出的内容在指定文件中保存起来
       -Q  不使用警告音
       -s  显示连续空行为一行
       -S  行过长时间将超出部分舍弃
       -x <数字> 将“tab”键显示为规定的数字空格
       /字符串：向下搜索“字符串”的功能
       ?字符串：向上搜索“字符串”的功能
       n：重复前一个搜索（与 / 或 ? 有关）
       N：反向重复前一个搜索（与 / 或 ? 有关）
       b  向后翻一页
       d  向后翻半页
       h  显示帮助界面
       Q  退出less 命令
       u  向前滚动半页
       y  向前滚动一行
       空格键 滚动一行
       回车键 滚动一页
       [pagedown]： 向下翻动一页
       [pageup]：   向上翻动一页
    4、命令示例：
       查看文件
       less log2013.log
       
       ps查看进程信息并通过less分页显示
       ps -ef | less
       
       查看命令历史使用记录并通过less分页显示
       history | less
       
       浏览多个文件
       less log2013.log log2014.log
## 14、 head 命令
     1、命令格式：
        head [参数]... [文件]...
     2、命令功能：
        head 用来显示档案的开头至标准输出中，默认head命令打印其相应文件的开头10行。 
     3、命令参数：
        -q 隐藏文件名
        -v 显示文件名
        -c<字节> 显示字节数
        -n<行数> 显示的行数
     4、命令示例：
        显示文件的前n行
        head -n 5 log2014.log
        
        显示文件前n个字节
        head -c 20 log2014.log
        
        文件的除了最后n个字节以外的内容 
        head -c -30 log2014.log
        
        输出文件除了最后n行的全部内容
        head -n -6 log2014.log
## 15、 tail 命令
     1、命令格式：
        tail [必要参数] [选择参数] [文件]
     2、命令功能：
        用于显示指定文件末尾内容，不指定文件时，作为输入信息进行处理。常用查看日志文件。      
     3、命令参数：
        -f 循环读取
        -q 不显示处理信息
        -v 显示详细的处理信息
        -c<数目> 显示的字节数
        -n<行数> 显示行数
        --pid=PID 与-f合用,表示在进程ID,PID死掉之后结束. 
        -q, --quiet, --silent 从不输出给出文件名的首部 
        -s, --sleep-interval=S 与-f合用,表示在每次反复的间隔休眠S秒 
     4、命令示例：
        显示文件末尾内容
        tail -n 5 log2014.log
        
        循环查看文件内容
        tail -f log2014.log
        
        从第5行开始显示文件
        tail -n +5 log2014.log
## 二、文件查找命令：
## 16、 which 命令
     1、命令格式：
        which 可执行文件名称
     2、命令功能：
        which指令会在PATH变量指定的路径中，搜索某个系统命令的位置，并且返回第一个搜索结果。
     3、命令参数：
        -n 　指定文件名长度，指定的长度必须大于或等于所有文件中最长的文件名。
        -p 　与-n参数相同，但此处的包括了文件的路径。
        -w 　指定输出时栏位的宽度。
        -V 　显示版本信息
     4、命令实例：
        查找文件、显示命令路径
        which lsmod   
        
        用 which 去找出 which
        which which
        
        找出 cd 这个命令
        which cd
## 17、 whereis 命令
     1、命令格式：
        whereis [-bmsu] [BMS 目录名 -f ] 文件名
     2、命令功能：
        whereis命令是定位可执行文件、源代码文件、帮助文件在文件系统中的位置。这些文件的属性应属于原始代码，二进制文件，或是帮助文件。whereis 程序还具有搜索源代码、指定备用搜索路径和搜索不寻常项的能力。
     3、命令参数：
        -b   定位可执行文件。
        -m   定位帮助文件。
        -s   定位源代码文件。
        -u   搜索默认路径下除可执行文件、源代码文件、帮助文件以外的其它文件。
        -B   指定搜索可执行文件的路径。
        -M   指定搜索帮助文件的路径。
        -S   指定搜索源代码文件的路径。
     4、命令示例：
        将和**文件相关的文件都查找出来
        whereis svn
        
        只将二进制文件 查找出来 
        whereis -b svn
        
## 18、 locate 命令
     1、命令格式：
        locate [选择参数] [样式]
     2、命令功能：
        locate命令可以在搜寻数据库时快速找到档案，数据库由updatedb程序来更新，updatedb是由cron daemon周期性建立的，locate命令在搜寻数据库时比由整个由硬盘资料来搜寻资料来得快，但较差劲的是locate所找到的档案若是最近才建立或 刚更名的，可能会找不到，在内定值中，updatedb每天会跑一次，可以由修改crontab来更新设定值。(etc/crontab)
        locate指定用在搜寻符合条件的档案，它会去储存档案与目录名称的数据库内，寻找合乎范本样式条件的档案或目录录，可以使用特殊字元（如”*” 或”?”等）来指定范本样式，如指定范本为kcpa*ner, locate会找出所有起始字串为kcpa且结尾为ner的档案或目录，如名称为kcpartner若目录录名称为kcpa_ner则会列出该目录下包括 子目录在内的所有档案。
        locate指令和find找寻档案的功能类似，但locate是透过update程序将硬盘中的所有档案和目录资料先建立一个索引数据库，在 执行loacte时直接找该索引，查询速度会较快，索引数据库一般是由操作系统管理，但也可以直接下达update强迫系统立即修改索引数据库。
     3、命令参数：
        -e   将排除在寻找的范围之外。
        -1  如果 是 1．则启动安全模式。在安全模式下，使用者不会看到权限无法看到	的档案。这会始速度减慢，因为 locate 必须至实际的档案系统中取得档案的	权限资料。
        -f   将特定的档案系统排除在外，例如我们没有到理要把 proc 档案系统中的档案	放在资料库中。
        -q  安静模式，不会显示任何错误讯息。
        -n 至多显示 n个输出。
        -r 使用正规运算式 做寻找的条件。
        -o 指定资料库存的名称。
        -d 指定资料库的路径
        -h 显示辅助讯息
        -V 显示程式的版本讯息
     4、命令示例：
        查找和pwd相关的所有文件
        locate pwd
        
        搜索etc目录下所有以sh开头的文件
        locate /etc/sh
        
        搜索etc目录下，所有以m开头的文件
        locate /etc/m
        
## 19、 find 命令
     1、命令格式：
        find pathname -options [-print -exec -ok ...]
     2、命令功能：
        用于在文件树中查找文件，并作出相应的处理
     3、命令参数：
        -name   按照文件名查找文件。
        -perm   按照文件权限来查找文件。
        -prune  使用这一选项可以使find命令不在当前指定的目录中查找，如果同时使用-depth选项，那么-prune将被find命令忽略。
        -user   按照文件属主来查找文件。
        -group  按照文件所属的组来查找文件。
        -mtime -n +n  按照文件的更改时间来查找文件， - n表示文件更改时间距现在n天以内，+ n表示文件更改时间距现在n天以前。find命令还有-atime和-ctime 选项，但它们都和-m time选项。
        -nogroup  查找无有效所属组的文件，即该文件所属的组在/etc/groups中不存在。
        -nouser   查找无有效属主的文件，即该文件的属主在/etc/passwd中不存在。
        -newer file1 ! file2  查找更改时间比文件file1新但比文件file2旧的文件。
        -type  查找某一类型的文件，诸如：
        b - 块设备文件。
        d - 目录。
        c - 字符设备文件。
        p - 管道文件。
        l - 符号链接文件。
        f - 普通文件。
        -size n：[c] 查找文件长度为n块的文件，带有c时表示文件长度以字节计。-depth：在查找文件时，首先查找当前目录中的文件，然后再在其子目录中查找。
        -fstype：查找位于某一类型文件系统中的文件，这些文件系统类型通常可以在配置文件/etc/fstab中找到，该配置文件中包含了本系统中有关文件系统的信息。
        -mount：在查找文件时不跨越文件系统mount点。
        -follow：如果find命令遇到符号链接文件，就跟踪至链接所指向的文件。
        -cpio：对匹配的文件使用cpio命令，将这些文件备份到磁带设备中。
        另外,下面三个的区别:
        -amin n   查找系统中最后N分钟访问的文件
        -atime n  查找系统中最后n*24小时访问的文件
        -cmin n   查找系统中最后N分钟被改变文件状态的文件
        -ctime n  查找系统中最后n*24小时被改变文件状态的文件
        -mmin n   查找系统中最后N分钟被改变文件数据的文件
        -mtime n  查找系统中最后n*24小时被改变文件数据的文件
     4、命令示例：
        查找指定时间内修改过的文件 
        find -atime -2
         
        根据关键字查找 
        find -name "*.log"
        
        按照目录或文件的权限来查找文件
        find /opt/soft/test -perm 777
        
        按类型查找 
        find -type f -name "*.log"
        
        查找当前所有目录并排序
        find -type d|sort
       
        find命令之exec
        exec解释：
        -exec  参数后面跟的是command命令，它的终止是以;为结束标志的，所以这句命令后面的分号是不可缺少的，考虑到各个系统中分号会有不同的意义，所以前面加反斜杠。
        {}   花括号代表前面find查找出来的文件名。
        使用find时，只要把想要的操作写在一个文件里，就可以用exec来配合find查找，很方便的。在有些操作系统中只允许-exec选项执行诸如l s或ls -l这样的命令。大多数用户使用这一选项是为了查找旧文件并删除它们。建议在真正执行rm命令删除文件之前，最好先用ls命令看一下，确认它们是所要删除的文件。 exec选项后面跟随着所要执行的命令或脚本，然后是一对儿{ }，一个空格和一个\，最后是一个分号。为了使用exec选项，必须要同时使用print选项。如果验证一下find命令，会发现该命令只输出从当前路径起的相对路径及文件名。       
        
        ls -l命令放在find命令的-exec选项中 
        find -type f -exec ls -l {}\;
        
        在目录中查找更改时间在n日以前的文件并删除它们
        find . -type f -mtime +14 -exec rm {} \; 
        
        在目录中查找更改时间在n日以前的文件并删除它们，在删除之前先给出提示
        find . -name "*.log" -mtime +5 -ok rm {} \;
        
        -exec中使用grep命令
        find /etc -name "passwd*" -exec grep "root" {} \;
        
        查找文件移动到指定目录  
        find . -name "*.log" -exec mv {} .. \;
        
        用exec选项执行cp命令  
        find . -name "*.log" -exec cp {} test3 \;
        
        find命令之xargs
        查找系统中的每一个普通文件，然后使用xargs命令来测试它们分别属于哪类文件 
        find . -type f -print | xargs file
          
        在整个系统中查找内存信息转储文件(core dump) ，然后把结果保存到/tmp/core.log 文件中       
        find / -name "core" -print | xargs echo "" >/tmp/core.log
        
        在当前目录下查找所有用户具有读、写和执行权限的文件，并收回相应的写权限
        find . -perm -7 -print | xargs chmod o-w
        
        用grep命令在所有的普通文件中搜索hostname这个词
        find . -type f -print | xargs grep "hostname"
        
        用grep命令在当前目录下的所有普通文件中搜索hostnames这个词
        find . -name \* -type f -print | xargs grep "hostnames"
        
        使用xargs执行mv 
        find . -name "*.log" | xargs -i mv {} test4
        
        find后执行xargs提示xargs: argument line too long解决方法：
        find . -type f -atime +0 -print0 | xargs -0 -l1 -t rm -f
        
        使用-i参数默认的前面输出用{}代替，-I参数可以指定其他代替字符，如例子中的[] 
        
        xargs的-p参数的使用 
        find . -name "*.log" | xargs -p -i mv {} ..
        
## 三、文件和目录属性、上传和下载        
## 28、tar 命令
     1、命令格式：
        tar [必要参数][选择参数][文件]
     2、命令功能：
        用来压缩和解压文件。tar本身不具有压缩功能。他是调用压缩功能实现的 
     3、命令参数：
        必要参数有如下：
        -A 新增压缩文件到已存在的压缩
        -B 设置区块大小
        -c 建立新的压缩文件
        -d 记录文件的差别
        -r 添加文件到已经压缩的文件
        -u 添加改变了和现有的文件到已经存在的压缩文件
        -x 从压缩的文件中提取文件
        -t 显示压缩文件的内容
        -z 支持gzip解压文件
        -j 支持bzip2解压文件
        -Z 支持compress解压文件
        -v 显示操作过程
        -l 文件系统边界设置
        -k 保留原有文件不覆盖
        -m 保留文件不被覆盖
        -W 确认压缩文件的正确性
        可选参数如下：
        -b 设置区块数目
        -C 切换到指定目录
        -f 指定压缩文件
        --help 显示帮助信息
        --version 显示版本信息
     4、命令示例：
        解包：tar xvf FileName.tar
        打包：tar cvf FileName.tar DirName
        （注：tar是打包，不是压缩！）
        
        将文件全部打包成tar包
        tar -cvf log.tar log2012.log  仅打包，不压缩！ 
        tar -zcvf log.tar.gz log2012.log  打包后，以 gzip 压缩 
        tar -jcvf log.tar.bz2 log2012.log  打包后，以 bzip2 压缩 
         
        在参数 f 之后的文件档名是自己取的，我们习惯上都用 .tar 来作为辨识。 如果加 z 参数，则以 .tar.gz 或 .tgz 来代表 gzip 压缩过的 tar包； 如果加 j 参数，则以 .tar.bz2 来作为tar包名。
        
        查阅上述 tar包内有哪些文件
        tar -ztvf log.tar.gz        
        由于我们使用 gzip 压缩的log.tar.gz，所以要查阅log.tar.gz包内的文件时，就得要加上 z 这个参数了。
        
        将tar 包解压缩
        tar -zxvf /opt/soft/test/log.tar.gz
        
        只将 /tar 内的 部分文件解压出来 
        tar -zxvf /opt/soft/test/log30.tar.gz log2013.log
        
        文件备份下来，并且保存其权限
        tar -zcvpf log31.tar.gz log2014.log log2015.log log2016.log 
        
        在文件夹当中，比某个日期新的文件才备份
        tar -N "2012/11/13" -zcvf log17.tar.gz test
        
        备份文件夹内容是排除部分文件 
        tar --exclude scf/service -zcvf scf.tar.gz scf/*
## 29、 gzip命令
     1、命令格式：
        gzip[参数][文件或者目录]
     2、命令功能：
        gzip是个使用广泛的压缩程序，文件经它压缩过后，其名称后面会多出".gz"的扩展名。
     3、命令参数：
        -a或--ascii 　使用ASCII文字模式。 
        -c或--stdout或--to-stdout 　把压缩后的文件输出到标准输出设备，不去更动原始文件。 
        -d或--decompress或----uncompress 　解开压缩文件。 
        -f或--force 　强行压缩文件。不理会文件名称或硬连接是否存在以及该文件是否为符号连接。 
        -h或--help 　在线帮助。 
        -l或--list 　列出压缩文件的相关信息。 
        -L或--license 　显示版本与版权信息。 
        -n或--no-name 　压缩文件时，不保存原来的文件名称及时间戳记。 
        -N或--name 　压缩文件时，保存原来的文件名称及时间戳记。 
        -q或--quiet 　不显示警告信息。 
        -r或--recursive 　递归处理，将指定目录下的所有文件及子目录一并处理。 
        -S<压缩字尾字符串>或----suffix<压缩字尾字符串> 　更改压缩字尾字符串。 
        -t或--test 　测试压缩文件是否正确无误。 
        -v或--verbose 　显示指令执行过程。 
        -V或--version 　显示版本信息。 
        -num 用指定的数字num调整压缩的速度，-1或--fast表示最快压缩方法（低压缩比），-9或--best表示最慢压缩方法（高压缩比）。系统缺省值为6。 
     4、命令示例：
        把test6目录下的每个文件压缩成.gz文件
        gzip * 
            
        把例1中每个压缩的文件解压，并列出详细的信息
        gzip -dv *
        
        详细显示例1中每个压缩的文件的信息，并不解压
        gzip -l *
        
        压缩一个tar备份文件，此时压缩文件的扩展名为.tar.gz
        gzip -r log.tar
        
        递归的压缩目录
        gzip -rv test6
        
        递归地解压目录
        gzip -dr test6
## 四、linux文件权限设置        
## 30、 chomd 命令
    1、命令格式：
       chomd [-cfvR][--help][--version]mode file
    2、命令功能：
       用于改变文件或目录的访问权限，用它控制文件或目录的访问权限。
    3、命令参数：
       必要参数：
       -c 当发生改变时，报告处理信息
       -f 错误信息不输出
       -R 处理指定目录以及其子目录下的所有文件
       -v 运行时显示详细处理信息
    4、命令示例：
       增加文件所有用户组可执行权限
       chmod a+x log2012.log
       
       同时修改不同用户权限
       chmod ug+w,o-x log2012.log
       
       删除文件权限
       chmod a-x log2012.log
       
       使用“=”设置权限 
       chmod u=x log2012.log
       
       对一个目录及其子目录所有文件添加权限 
       chmod -R u+x test4
       
       其他：
           1）. 命令：chmod 751 file   
           说明：给file的属主分配读、写、执行(7)的权限，给file的所在组分配读、执行(5)的权限，给其他用户分配执行(1)的权限
           2）. 命令：chmod u=rwx,g=rx,o=x file 
           说明：上例的另一种形式
           3）. 命令：chmod =r file 
           说明：为所有用户分配读权限
           3）. 命令：chmod 444 file 
           说明： 同上例
           4）. 命令：chmod a-wx,a+r   file
           说明：同上例
## 31、chgrp 命令 
     1、命令格式：
        chgrp [选项] [组] [文件]
     2、命令功能：
        chgrp命令可采用群组名称或群组识别码的方式改变文件或目录的所属群组。使用权限是超级用户。 
     3、命令参数：
        必要参数:
        -c 当发生改变时输出调试信息
        -f 不显示错误信息
        -R 处理指定目录以及其子目录下的所有文件
        -v 运行时显示详细的处理信息
        --dereference 作用于符号链接的指向，而不是符号链接本身
        --no-dereference 作用于符号链接本身
        选择参数:
        --reference=<文件或者目录>
        --help 显示帮助信息
        --version 显示版本信息
     4、命令示例：
        改变文件的群组属性 
        chgrp -v bin log2012.log
        
        根据指定文件改变文件的群组属性 
        chgrp --reference=log2012.log log2013.log
        
        改变指定目录以及其子目录下的所有文件的群组属性 
        chgrp -R bin test6
        
        通过群组识别码改变文件群组属性      
        chgrp -R 100 test6

## 32、chown 命令
    1、命令格式：
       chown [选项]... [所有者][:[组]] 文件...
    2、命令功能：
       通过chown改变文件的拥有者和群组。在更改文件的所有者或所属群组时，可以使用用户名称和用户识别码设置。普通用户不能将自己的文件改变成其他的拥有者。其操作权限一般为管理员。
    3、命令参数：
       必要参数:
       -c 显示更改的部分的信息
       -f 忽略错误信息
       -h 修复符号链接
       -R 处理指定目录以及其子目录下的所有文件
       -v 显示详细的处理信息
       -deference 作用于符号链接的指向，而不是链接文件本身
       选择参数:
       --reference=<目录或文件> 把指定的目录/文件作为参考，把操作的文件/目录设置成参考文件/目录相同拥有者和群组
       --from=<当前用户：当前群组> 只有当前用户和群组跟指定的用户和群组相同时才进行改变
       --help 显示帮助信息
       --version 显示版本信息
    4、命令示例：
       改变拥有者和群组
       chown mail:mail log2012.log
       
       改变文件拥有者和群组
       chown root:log2012.log
       
       改变文件群组
       chown :mail log2012.log
       
       改变指定目录以及其子目录下的所有文件的拥有者和群组 
       chown -R -v root:mail test6
## 五、磁盘存储相关       
## 33、df 命令 
     1、命令格式：
        df [选项] [文件]
     2、命令功能：
        显示指定磁盘文件的可用空间。
     3、命令参数：
        必要参数：
        -a 全部文件系统列表
        -h 方便阅读方式显示
        -H 等于“-h”，但是计算式，1K=1000，而不是1K=1024
        -i 显示inode信息
        -k 区块为1024字节
        -l 只显示本地文件系统
        -m 区块为1048576字节
        --no-sync 忽略 sync 命令
        -P 输出格式为POSIX
        --sync 在取得磁盘信息前，先执行sync命令
        -T 文件系统类型
        选择参数：
        --block-size=<区块大小> 指定区块大小
        -t<文件系统类型> 只显示选定文件系统的磁盘信息
        -x<文件系统类型> 不显示选定文件系统的磁盘信息
        --help 显示帮助信息
        --version 显示版本信息
     4、命令示例：
        显示磁盘使用情况
        df
        
        以inode模式来显示磁盘使用情况
        df -i
        
        显示指定类型磁盘
        df -t text3
        
        列出各文件系统的i节点使用情况
        df -ia
        
        列出文件系统的类型
        df -T
        
        以更易读的方式显示目前磁盘空间和使用情况 
        df -h
        
## 34、 du 命令
    1、命令格式：
       du [选项] [文件]
    2、命令功能：
       显示每个文件和目录的磁盘使用空间。
    3、命令参数：
       -a或-all  显示目录中个别文件的大小。   
       -b或-bytes  显示目录或文件大小时，以byte为单位。   
       -c或--total  除了显示个别目录或文件的大小外，同时也显示所有目录或文件的总和。 
       -k或--kilobytes  以KB(1024bytes)为单位输出。
       -m或--megabytes  以MB为单位输出。   
       -s或--summarize  仅显示总计，只列出最后加总的值。
       -h或--human-readable  以K，M，G为单位，提高信息的可读性。
       -x或--one-file-xystem  以一开始处理时的文件系统为准，若遇上其它不同的文件系统目录则略过。 
       -L<符号链接>或--dereference<符号链接> 显示选项中所指定符号链接的源文件大小。   
       -S或--separate-dirs   显示个别目录的大小时，并不含其子目录的大小。 
       -X<文件>或--exclude-from=<文件>  在<文件>指定目录或文件。   
       --exclude=<目录或文件>         略过指定的目录或文件。    
       -D或--dereference-args   显示指定符号链接的源文件大小。   
       -H或--si  与-h参数相同，但是K，M，G是以1000为换算单位。   
       -l或--count-links   重复计算硬件链接的文件。  
    4、命令示例：
       显示目录或者文件所占空间
       du
       
       显示指定文件所占空间
       du log2012.log
       
       查看指定目录的所占空间
       du scf 
        
       显示多个文件所占空间
       du log30.tar.gz log31.tar.gz
       
       只显示总和的大小
       du -s
       
       方便阅读的格式显示
       du -h test
       
       文件和目录都显示
       du -ah test
       
       显示几个文件或目录各自占用磁盘空间的大小，还统计它们的总和     
       du -c log30.tar.gz log31.tar.gz
       
       按照空间大小排序 
       du|sort -nr|more
       
       输出当前目录下各个子目录所使用的空间
       du -h  --max-depth=1
## 六、性能监控和优化命令
## 35、top命令
    1、命令格式：
       top [参数]
    2、命令功能：
       显示当前系统正在执行的进程的相关信息，包括进程ID、内存占用率、CPU占用率等
    3、命令参数：
       -b 批处理
       -c 显示完整的治命令
       -I 忽略失效过程
       -s 保密模式
       -S 累积模式
       -i<时间> 设置间隔时间
       -u<用户名> 指定用户名
       -p<进程号> 指定进程
       -n<次数> 循环显示的次数
    4、命令示例：
       显示进程信息
       top 
       
       显示 完整命令
       top -c
       
       以批处理模式显示程序信息
       top -b
       
       以累积模式显示程序信息
       top -S
       
       设置信息更新次数
       top -n 2
       
       设置信息更新时间
       top -d 3
       
       显示指定的进程信息
       top -p 574
       
## 36、free 命令
    1、命令格式：
       free [参数]
    2、命令功能：
       free 命令显示系统使用和空闲的内存情况，包括物理内存、交互区内存(swap)和内核缓冲区内存。共享内存将被忽略
    3、命令参数：
       -b 　以Byte为单位显示内存使用情况。 
       -k 　以KB为单位显示内存使用情况。 
       -m 　以MB为单位显示内存使用情况。
       -g   以GB为单位显示内存使用情况。 
       -o 　不显示缓冲区调节列。 
       -s<间隔秒数> 　持续观察内存使用状况。 
       -t 　显示内存总和列。 
       -V 　显示版本信息。
    4、命令示例：
       显示内存使用情况
       free
       free -g
       free -m
       
       以总和的形式显示内存的使用信息
       free -t 
       
       周期性的查询内存使用信息
       free -s 10
       
## 37、 vmstat 命令
    1、命令格式：
       vmstat [-a] [-n] [-S unit] [delay [ count]]
       vmstat [-s] [-n] [-S unit]
       vmstat [-m] [-n] [delay [ count]]
       vmstat [-d] [-n] [delay [ count]]
       vmstat [-p disk partition] [-n] [delay [ count]]
       vmstat [-f]
       vmstat [-V]
    2、命令功能：
       用来显示虚拟内存的信息
    3、命令参数：
       -a：显示活跃和非活跃内存
       -f：显示从系统启动至今的fork数量 。
       -m：显示slabinfo
       -n：只在开始时显示一次各字段名称。
       -s：显示内存相关统计信息及多种系统活动数量。
       delay：刷新时间间隔。如果不指定，只显示一条结果。
       count：刷新次数。如果不指定刷新次数，但指定了刷新时间间隔，这时刷新次数为无穷。
       -d：显示磁盘相关统计信息。
       -p：显示指定磁盘分区统计信息
       -S：使用指定单位显示。参数有 k 、K 、m 、M ，分别代表1000、1024、1000000、1048576字节（byte）。默认单位为K（1024 bytes）
       -V：显示vmstat版本信息。
    4、命令示例：
       显示虚拟内存使用情况
       vmstat
       
       显示活跃和非活跃内存
       vmstat -a 2 5
       
       查看系统已经fork了多少次
       vmstat -f
       
       查看内存使用的详细信息
       vmstat -s
        
       查看磁盘的读/写
       vmstat -d
       
       查看/dev/sda1磁盘的读/写 
       vmstat -p /dev/sda1
       
       查看系统的slab信息       
       vmstat -m
       
## 38、iostat 命令
    1、命令格式：
       iostat[参数][时间][次数]
    2、命令功能：
       通过iostat方便查看CPU、网卡、tty设备、磁盘、CD-ROM 等等设备的活动情况,	负载信息。 
    3、命令参数：
       -C 显示CPU使用情况
       -d 显示磁盘使用情况
       -k 以 KB 为单位显示
       -m 以 M 为单位显示
       -N 显示磁盘阵列(LVM) 信息
       -n 显示NFS 使用情况
       -p[磁盘] 显示磁盘和分区的情况
       -t 显示终端和CPU的信息
       -x 显示详细信息
       -V 显示版本信息
    4、命令示例：
       显示所有设备负载情况
       iostat
       
       定时显示所有信息
       iostat 2 3
       
       显示指定磁盘信息
       iostat -d sda1
       
       显示tty和Cpu信息
       iostat -t
       
       以M为单位显示所有信息
       iostat -m
       
       查看TPS和吞吐量信息
       iostat -d -k 1 1
       
       查看设备使用率（%util）、响应时间（await）
       iostat -d -x -k 1 1
       
       查看cpu状态
       iostat -c 1 3
       
## 39、lsof 命令     
    1、命令格式：
       lsof [参数][文件]
    2、命令功能：
       用于查看你进程开打的文件，打开文件的进程，进程打开的端口(TCP、UDP)。
    3、命令参数：
       -a 列出打开文件存在的进程
       -c<进程名> 列出指定进程所打开的文件
       -g  列出GID号进程详情
       -d<文件号> 列出占用该文件号的进程
       +d<目录>  列出目录下被打开的文件
       +D<目录>  递归列出目录下被打开的文件
       -n<目录>  列出使用NFS的文件
       -i<条件>  列出符合条件的进程。（4、6、协议、:端口、 @ip ）
       -p<进程号> 列出指定进程号所打开的文件
       -u  列出UID号进程详情
       -h 显示帮助信息
       -v 显示版本信息
    4、命令示例：
       无任何参数
       lsof
       
       查看谁正在使用某个文件，也就是说查找某个文件相关的进程
       lsof /bin/bash
       
       递归查看某个目录的文件信息
       lsof test/test3
       
       不使用+D选项，遍历查看某个目录的所有文件信息的方法
       lsof |grep 'test/test3'
       
       列出某个用户打开的文件信息
       lsof -u username
       
       列出某个程序进程所打开的文件信息
       lsof -c mysql
       
## 七、网络命令
## 40、ifconfig 命令
    1、命令格式：
       ifconfig [网络设备] [参数]
    2、命令功能：
       ifconfig 命令用来查看和配置网络设备。当网络环境发生改变时可通过此命令对网络进行相应的配置。
    3、命令参数：
       up 启动指定网络设备/网卡。
       down 关闭指定网络设备/网卡。该参数可以有效地阻止通过指定接口的IP信息流，如果想永久地关闭一个接口，我们还需要从核心路由表中将该接口的路由信息全部删除。
       arp 设置指定网卡是否支持ARP协议。
       -promisc 设置是否支持网卡的promiscuous模式，如果选择此参数，网卡将接收网络中发给它所有的数据包
       -allmulti 设置是否支持多播模式，如果选择此参数，网卡将接收网络中所有的多播数据包
       -a 显示全部接口信息
       -s 显示摘要信息（类似于 netstat -i）
       add 给指定网卡配置IPv6地址
       del 删除指定网卡的IPv6地址
       <硬件地址> 配置网卡最大的传输单元
       mtu<字节数> 设置网卡的最大传输单元 (bytes)
       netmask<子网掩码> 设置网卡的子网掩码。掩码可以是有前缀0x的32位十六进制数，也可以是用点分开的4个十进制数。如果不打算将网络分成子网，可以不管这一选项；如果要使用子网，那么请记住，网络中每一个系统必须有相同子网掩码。
       tunel 建立隧道
       dstaddr 设定一个远端地址，建立点对点通信
       -broadcast<地址> 为指定网卡设置广播协议
       -pointtopoint<地址> 为网卡设置点对点通讯协议
       multicast 为网卡设置组播标志
       address 为网卡设置IPv4地址
       txqueuelen<长度> 为网卡设置传输列队的长度
    4、命令示例：
       显示网络设备信息（激活状态的）
       ifconfig
       
       启动关闭指定网卡
       ifconfig eth0 up
       ifconfig eth1 down
       
       为网卡配置和删除IPv6地址
       ifconfig eth0 add 33ffe:3240:800:1005::2/64
       ifconfig eth0 del 33ffe:3240:800:1005::2/64
       
       用ifconfig修改MAC地址
       ifconfig eth0 hw ether 00:AA:BB:CC:DD:EE
       
       配置IP地址
       ifconfig eth0 192.168.120.56 
       给eth0网卡配置IP地：192.168.120.56
       ifconfig eth0 192.168.120.56 netmask 255.255.255.0 
       给eth0网卡配置IP地址：192.168.120.56 ，并加上子掩码：255.255.255.0
       ifconfig eth0 192.168.120.56 netmask 255.255.255.0 broadcast 192.168.120.255
       /给eth0网卡配置IP地址：192.168.120.56，加上子掩码：255.255.255.0，加上个广播地址： 192.168.120.255
        
       启用和关闭ARP协议
       ifconfig eth0 arp
       ifconfig eth0 -arp
       
       设置最大传输单元
       ifconfig eth0 mtu 1500
## 41、route命令
    1、命令格式：
       route [-f] [-p] [Command [Destination] [mask Netmask] [Gateway] [metric Metric]] [if Interface]] 
    2、命令功能：
       Route命令是用于操作基于内核ip路由表，它的主要作用是创建一个静态路由让指定一个主机或者一个网络通过一个网络接口，如eth0。当使用"add"或者"del"参数时，路由表被修改，如果没有参数，则显示路由表当前的内容。
    3、命令参数：
       -c 显示更多信息
       -n 不解析名字
       -v 显示详细的处理信息
       -F 显示发送信息
       -C 显示路由缓存
       -f 清除所有网关入口的路由表。 
       -p 与 add 命令一起使用时使路由具有永久性。
        
       add:添加一条新路由。
       del:删除一条路由。
       -net:目标地址是一个网络。
       -host:目标地址是一个主机。
       netmask:当添加一个网络路由时，需要使用网络掩码。
       gw:路由数据包通过网关。注意，你指定的网关必须能够达到。
       metric：设置路由跳数。
       Command 指定您想运行的命令 (Add/Change/Delete/Print)。 
       Destination 指定该路由的网络目标。 
       mask Netmask 指定与网络目标相关的网络掩码（也被称作子网掩码）。 
       Gateway 指定网络目标定义的地址集和子网掩码可以到达的前进或下一跃点 IP 地址。 
       metric Metric 为路由指定一个整数成本值标（从 1 至 9999），当在路由表(与转发的数据包目标地址最匹配)的多个路由中进行选择时可以使用。 
       if Interface 为可以访问目标的接口指定接口索引。若要获得一个接口列表和它们相应的接口索引，使用 route print 命令的显示功能。可以使用十进制或十六进制值进行接口索引。
    4、命令示例：
       显示当前路由
       route
       route -n
       
       添加网关/设置网关
       route add -net 224.0.0.0 netmask 240.0.0.0 dev eth0
       
       屏蔽一条路由           
       route add -net 224.0.0.0 netmask 240.0.0.0 reject
       
       删除路由记录
       route del -net 224.0.0.0 netmask 240.0.0.0
       route del -net 224.0.0.0 netmask 240.0.0.0 reject
       
       删除和添加设置默认网关
       route del default gw 192.168.120.240
       route add default gw 192.168.120.240
       
## 42、ping命令
     1、命令格式：
        ping [参数] [主机名或IP地址]
     2、命令功能：
        ping命令用于：确定网络和各外部主机的状态；跟踪和隔离硬件和软件问题；测试、评估和管理网络。
     3、命令参数：
        -d 使用Socket的SO_DEBUG功能。
        -f  极限检测。大量且快速地送网络封包给一台机器，看它的回应。
        -n 只输出数值。
        -q 不显示任何传送封包的信息，只显示最后的结果。
        -r 忽略普通的Routing Table，直接将数据包送到远端主机上。通常是查看本机的网络接口是否有问题。
        -R 记录路由过程。
        -v 详细显示指令的执行过程。
        <p>-c 数目：在发送指定数目的包后停止。
        -i 秒数：设定间隔几秒送一个网络封包给一台机器，预设值是一秒送一次。
        -I 网络界面：使用指定的网络界面送出数据包。
        -l 前置载入：设置在送出要求信息之前，先行发出的数据包。
        -p 范本样式：设置填满数据包的范本样式。
        -s 字节数：指定发送的数据字节数，预设值是56，加上8字节的ICMP头，一共是64ICMP数据字节。
        -t 存活数值：设置存活数值TTL的大小。
     4、命令示例：
        ping的通的情况
        ping 192.168.120.205
        
        ping网关
        ping -b 192.168.120.1
        
        ping指定次数
        ping -c 10 192.168.120.206
        
        时间间隔和次数限制的ping
        ping -c 10 -i 0.5 192.168.120.206
        
        通过域名ping公网上的站点
        ping -c 5 www.58.com
        
        多参数使用
        ping -i 3 -s 1024 -t 255 192.168.120.206
        
## 43、traceroute 命令 
    1、命令格式：
    2、命令功能：
    3、命令参数：
    4、命令示例：
       
             
       
       
        
       
                
       
       
                     
   
         
        
          
     
     
     
     
     
           
       
       
       
       
       
       
    
                                                              