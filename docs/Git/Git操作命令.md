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

## 操作分支
### 1、 git branch
&emsp;&emsp;查看、创建、删除分支
    
    git branch -a 

&emsp;&emsp;查看本地版本库和远程版本库上的分支列表

    git branch -r

&emsp;&emsp;查看远程版本库上的分支列表，加上 -d 参数可以删除远程版本库上的分支    

    git branch -D
    
&emsp;&emsp;分支未提交到本地版本库前强制删除分支    

    git branch -vv 

&emsp;&emsp;查看带有最后提交id、最近提交原因等信息的本地版本库分支列表

### 2、git merge
&emsp;&emsp; 将其它分支合并到当前分支

    git merge --squash

&emsp;&emsp;将待合并分支上的 commit 合并成一个新的 commit 放入当前分支，适用于待合并分支的提交记录不需要保留的情况    

    git merge --no-ff

&emsp;&emsp;默认情况下，Git 执行"快进式合并"（fast-farward merge），会直接将 Master 分支指向 Develop 分支，使用 --no-ff 参数后，会执行正常合并，在 Master 分支上生成一个新节点，保证版本演进更清晰。

    git merge --no-edit

&emsp;&emsp;在没有冲突的情况下合并，不想手动编辑提交原因，而是用 Git 自动生成的类似 Merge branch 'test'的文字直接提交

### 3、git checkout 
&emsp;&emsp;切换分支

    git checkout -b daily/0.0.1

&emsp;&emsp;创建 daily/0.0.1 分支，同时切换到这个新创建的分支

    git checkout HEAD demo.html

&emsp;&emsp;从本地版本库的 HEAD（也可以是提交ID、分支名、Tag名） 历史中检出 demo.html 覆盖当前工作区的文件，如果省略 HEAD 则是从暂存区检出

    git checkout --orphan new_branch

&emsp;&emsp;这个命令会创建一个全新的，完全没有历史记录的新分支，但当前源分支上所有的最新文件都还在，真是强迫症患者的福音，但这个新分支必须做一次 git commit 操作后才会真正成为一个新分支。

    git checkout -p other_branch
    
&emsp;&emsp;这个命令主要用来比较两个分支间的差异内容，并提供交互式的界面来选择进一步的操作，这个命令不仅可以比较两个分支间的差异，还可以比较单个文件的差异。

### 4、git stash
&emsp;&emsp;在 Git 的栈中保存当前修改或删除的工作进度，当你在一个分支里做某项功能开发时，接到通知把昨天已经测试完没问题的代码发布到线上，但这时你已经在这个分支里加入了其它未提交的代码，这个时候就可以把这些未提交的代码存到栈里。

    git stash

&emsp;&emsp;将未提交的文件保存到Git栈中

    git stash list

&emsp;&emsp;查看栈中保存的列表

    git stash show stash@{0}

&emsp;&emsp;显示栈中其中一条记录

    git stash drop stash@{0}

&emsp;&emsp;移除栈中其中一条记录

    git stash pop

&emsp;&emsp;从Git栈中检出最新保存的一条记录，并将它从栈中移除

    git stash apply stash@{0}

&emsp;&emsp;从Git栈中检出其中一条记录，但不从栈中移除

    git stash branch new_banch

&emsp;&emsp;把当前栈中最近一次记录检出并创建一个新分支

    git stash clear

&emsp;&emsp;清空栈里的所有记录

    git stash create 

&emsp;&emsp;为当前修改或删除的文件创建一个自定义的栈并返回一个ID，此时并未真正存储到栈里

    git stash store xxxxxx

&emsp;&emsp;将 create 方法里返回的ID放到 store 后面，此时在栈里真正创建了一个记录，但当前修改或删除的文件并未从工作区移除

    $ git stash create
      09eb9a97ad632d0825be1ece361936d1d0bdb5c7
    $ git stash store 09eb9a97ad632d0825be1ece361936d1d0bdb5c7
    $ git stash list
      stash@{0}: Created via "git stash store".

## 操作历史
### 1、git log
&emsp;&emsp;显示提交历史记录

    git log -p

&emsp;&emsp;显示带提交差异对比的历史记录

    git log demo.html

&emsp;&emsp;显示 demo.html 文件的历史记录

    git log --since="2 weeks ago"

&emsp;&emsp;显示2周前开始到现在的历史记录，其它时间可以类推

    git log --before="2 weeks ago"

&emsp;&emsp;显示截止到2周前的历史记录，其它时间可以类推

    git log -10
&emsp;&emsp;显示最近10条历史记录

    git log f5f630a..HEAD

&emsp;&emsp;显示从提交ID f5f630a 到 HEAD 之间的记录，HEAD 可以为空或其它提交ID

    git log --pretty=oneline

&emsp;&emsp;在一行中输出简短的历史记录

    git log --pretty=format:"%h" 

&emsp;&emsp;格式化输出历史记录

&emsp;&emsp;Git 用各种 placeholder 来决定各种显示内容，我挑几个常用的显示如下：

- %H: commit hash
- %h: 缩短的commit hash
- %T: tree hash
- %t: 缩短的 tree hash
- %P: parent hashes
- %p: 缩短的 parent hashes
- %an: 作者名字
- %aN: mailmap的作者名
- %ae: 作者邮箱
- %ad: 日期 (--date= 制定的格式)
- %ar: 日期, 相对格式(1 day ago)
- %cn: 提交者名字
- %ce: 提交者 email
- %cd: 提交日期 (--date= 制定的格式)
- %cr: 提交日期, 相对格式(1 day ago)
- %d: ref名称
- %s: commit信息标题
- %b: commit信息内容
- %n: 换行

### 2、git cherry-pick
&emsp;&emsp;合并分支的一条或几条提交记录到当前分支末梢

    git cherry-pick 170a305

&emsp;&emsp;合并提交ID 170a305 到当前分支末梢

### 3、git reset
&emsp;&emsp;将当前的分支重设（reset）到指定的 <commit> 或者 HEAD

    git reset --mixed <commit>

&emsp;&emsp;--mixed 是不带参数时的默认参数，它退回到某个版本，保留文件内容，回退提交历史<br>    

    git reset --soft <commit>

&emsp;&emsp;暂存区和工作区中的内容不作任何改变，仅仅把 HEAD 指向 <commit> 

    git reset --hard <commit>

&emsp;&emsp;自从 <commit> 以来在工作区中的任何改变都被丢弃，并把 HEAD 指向 <commit>

### 4、git rebase
&emsp;&emsp;重新定义分支的版本库状态

    git rebase branch_name
    
&emsp;&emsp;

### 5、git revert    
&emsp;&emsp;撤销某次操作，此次操作之前和之后的 commit 和 history 都会保留，并且把这次撤销作为一次最新的提交

    git revert HEAD

&emsp;&emsp;撤销前一次提交操作

    git revert HEAD --no-edit

&emsp;&emsp;撤销前一次提交操作，并以默认的 Revert "xxx" 为提交原因

    git revert -n HEAD

&emsp;&emsp;需要撤销多次操作的时候加 -n 参数，这样不会每次撤销操作都提交，而是等所有撤销都完成后一起提交

### 6、git diff
&emsp;&emsp;查看工作区、暂存区、本地版本库之间的文件差异，用一张图来解释

    git diff --stat

&emsp;&emsp;通过 --stat 参数可以查看变更统计数据

    test.md | 1 -
    1 file changed, 1 deletion(-)

### 7、git reflog
&emsp;&emsp;reflog 可以查看所有分支的所有操作记录（包括commit和reset的操作、已经被删除的commit记录，跟 git log的区别在于它不能查看已经删除了的commit记录


## 远程版本库连接

### 1、git init
&emsp;&emsp;在本地目录内部会生成.git文件夹

### 2、git remote
     
    git remote -v

&emsp;&emsp;不带参数，列出已经存在的远程分支，加上 -v 列出详细信息，在每一个名字后面列出其远程url

    git remote add origin https://github.com/gafish/gafish.github.com.git

&emsp;&emsp;添加一个新的远程仓库，指定一个名字，以便引用后面带的URL

### 3、git fetch
&emsp;&emsp;将远程版本库的更新取回到本地版本库

    git fetch origin daily/0.0.1
&emsp;&emsp;默认情况下，git fetch 取回所有分支的更新。如果只想取回特定分支的更新，可以指定分支名。

## 问题排查

### 1、git blame
&emsp;&emsp;查看文件每行代码块的历史信息
    git blame -L 1,10 demo.html

&emsp;&emsp;截取 demo.html 文件1-10行历史信息

### 2、git bisect

&emsp;&emsp;二分查找历史记录，排查BUG

    git bisect start

&emsp;&emsp;开始二分查找

    git bisect bad

&emsp;&emsp;标记当前二分提交ID为有问题的点

    git bisect good

&emsp;&emsp;标记当前二分提交ID为没问题的点

    git bisect reset
    
&emsp;&emsp;查到有问题的提交ID后回到原分支

## 更多操作

### 1、git submodule

&emsp;&emsp;通过 Git 子模块可以跟踪外部版本库，它允许在某一版本库中再存储另一版本库，并且能够保持2个版本库完全独立

    git submodule add https://github.com/gafish/demo.git demo

&emsp;&emsp;将 demo 仓库添加为子模块

    git submodule update demo

&emsp;&emsp;更新子模块 demo

### 2、git gc
&emsp;&emsp;运行Git的垃圾回收功能，清理冗余的历史快照
    git archive

&emsp;&emsp;将加了tag的某个版本打包提取

    git archive -v --format=zip v0.1 > v0.1.zip

&emsp;&emsp;--format 表示打包的格式，如 zip，-v 表示对应的tag名，后面跟的是tag名，如 v0.1。



    