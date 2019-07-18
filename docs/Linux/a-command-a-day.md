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
        
## 三、文件和目录属性         
        
        
     
     
        
        
        
         
        
          
     
     
     
     
     
           
       
       
       
       
       
       
    
                                                              