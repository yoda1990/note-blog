# 一、基本操作
### 1、git clone
&emsp;&emsp;从git服务器拉取代码

    git clone url
    eg: git clone https://github.com/gafish/gafish.github.com.git
    
### 2、git config
&emsp;&emsp;配置开发者用户名和邮箱

    git config user.name 'xxx'
    git config user.email 'xxx'
    git config [--global] user.name "[name]" // 全局设置
    git config [--global] user.email "[email address]" // 全局设置
    
    eg: git config [--global] user.name gafish
        git config [--global] user.email gafish@qqqq.com
        
### 3、git branch
&emsp;&emsp;创建、重命名、查看、删除项目分支，通过 Git 做项目开发时，一般都是在开发分支中进行，开发完成后合并分支到主干。<br>
&emsp;&emsp;创建一个名为 daily/0.0.0 的日常开发分支，分支名只要不包括特殊字符即可

    git branch daily/0.0.0
&emsp;&emsp;如果觉得之前的分支名不合适，可以为新建的分支重命名，重命名分支名为 daily/0.0.1

    git branch -m daily/0.0.0 daily/0.0.1
&emsp;&emsp; 通过不带参数的branch命令可以查看当前项目分支列表

    git branch
&emsp;&emsp;如果分支已经完成使命则可以通过 -d 参数将分支删除，这里为了继续下一步操作，暂不执行删除操作

    git branch -d daily/0.0.0

### 4、git checkout
&emsp;&emsp;切换分支<br>
    
    git checkout daily/0.0.1

### 5、git status
&emsp;&emsp;查看文件变动状态<br>

    git status

### 6、git add
&emsp;&emsp;添加文件变动到暂存区<br>

    git add README.md
    
### 7、git commit
&emsp;&emsp;提交文件变动到版本库<br>

    git commit -m 'xxx'
&emsp;&emsp;xxx为说明，通过 -m 参数可直接在命令行里输入提交描述文本

### 8、git push 
&emsp;&emsp;将本地的代码改动推送到服务器
    
    git push origin daily/0.0.1

### 9、git pull
&emsp;&emsp;将服务器上的最新代码拉取到本地

    git pull origin daily/0.0.1
    
### 10、 git log
&emsp;&emsp;查看版本提交记录

    git log
    
### 11、git tag
&emsp;&emsp;为项目标记里程碑

    git tag publish/0.0.1
    git push origin publish/0.0.1
    
### 12、.gitignore
&emsp;&emsp;设置哪些内容不需要推送到服务器，这是一个配置文件
    
    touch .gitignore
    
&emsp;&emsp;.gitignore 不是 Git 命令，而在项目中的一个文件，通过设置 .gitignore 的内容告诉 Git 哪些文件应该被忽略不需要推送到服务器，通过以上命令可以创建一个 .gitignore 文件，并在编辑器中打开文件，每一行代表一个要忽略的文件或目录，如：

    demo.html
    build/
以上内容的意思是 Git 将忽略 demo.html 文件 和build/目录，这些内容不会被推送到服务器上    


# 二、高级操作
## 操作文件
### 1、git add
&emsp;&emsp;添加文件到暂存区<br>
    
    git add -i

&emsp;&emsp;通过此命令将打开交互式子命令系统，你将看到如下子命令：

    ***Commands***
    1: status      2: update      3: revert      4: add untracked
    5: patch      6: diff      7: quit      8: help

&emsp;&emsp;通过输入序列号或首字母可以选择相应的功能，具体的功能解释如下：

- status：功能上和 git add -i 相似，没什么鸟用
- update：详见下方 git add -u
- revert：把已经添加到暂存区的文件从暂存区剔除，其操作方式和 update 类似
- add untracked：可以把新增的文件添加到暂存区，其操作方式和 update 类似
- patch：详见下方 git add -p
- diff：比较暂存区文件和本地版本库的差异，其操作方式和 update 类似
- quit：退出 git add -i 命令系统
- help：查看帮助信息

     
    git add -p
    
&emsp;&emsp;直接进入交互命令中最有用的 patch 模式

这是交互命令中最有用的模式，其操作方式和 update 类似，选择后 Git 会显示这些文件的当前内容与本地版本库中的差异，然后您可以自己决定是否添加这些修改到暂存区，在命令行 Stage deletion [y,n,q,a,d,/,?]? 后输入 y,n,q,a,d,/,? 其中一项选择操作方式，具体功能解释如下：

- y：接受修改
- n：忽略修改
- q：退出当前命令
- a：添加修改
- d：放弃修改
- /：通过正则表达式匹配修改内容
- ?：查看帮助信息

    
    git add -u 

&emsp;&emsp;直接进入交互命令中的 update 模式<br>
它会先列出工作区 修改 或 删除 的文件列表，新增 的文件不会被显示，在命令行 Update>> 后输入相应的列表序列号表示选中该项，回车继续选择，如果已选好，直接回车回到命令主界面


    git add --ignore-removal .

&emsp;&emsp;添加工作区 修改 或 新增 的文件列表， 删除 的文件不会被添加    

### 2、git commit
&emsp;&emsp;把暂存区的文件提交到本地版本库

    git commit -m '第一行提交原因'  -m '第二行提交原因'
    
&emsp;&emsp;不打开编辑器，直接在命令行中输入多行提交原因    

    git commit -am '提交原因'

&emsp;&emsp;将工作区 修改 或 删除 的文件提交到本地版本库， 新增 的文件不会被提交

     git commit --amend -m '提交原因'
     
&emsp;&emsp;修改最新一条提交记录的提交原因    

     git commit -C HEAD
     
&emsp;&emsp;将当前文件改动提交到 HEAD 或当前分支的历史ID     

### 3、git mv
&emsp;&emsp;移动或重命名文件、目录

    git mv a.md b.md -f
    
&emsp;&emsp;将 a.md 重命名为 b.md ，同时添加变动到暂存区，加 -f 参数可以强制重命名，相比用 mv a.md b.md 命令省去了 git add 操作    

### 4、git rm
&emsp;&emsp;从工作区和暂存区移除文件

    git rm b.md
    
&emsp;&emsp;从工作区和暂存区移除文件 b.md ，同时添加变动到暂存区，相比用 rm b.md 命令省去了 git add 操作

    git rm src/ -r
    
&emsp;&emsp;允许从工作区和暂存区移除目录    

### 5、git status

    git status -s
    
&emsp;&emsp;以简短方式查看工作区和暂存区文件状态，示例如下：

    git status --ignored

&emsp;&emsp;查看工作区和暂存区文件状态，包括被忽略的文件
