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