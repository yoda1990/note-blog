## 一、 2天学会Pandas
### 1、Series
     import pandas as pd
     import numpy as np
     # Series
     s = pd.Series([1,3,6,np.nan,44,1])
     print(s)
     # 默认index从0开始,如果想要按照自己的索引设置，则修改index参数,
     如:index=[3,4,3,7,8,9]

### 2、DataFrame

#### 2.1、DataFrame的简单运用
     # DataFrame
     dates = pd.date_range('2018-08-19',periods=6)
     # dates = pd.date_range('2018-08-19','2018-08-24') # 起始、结束  与上述等价
     '''
     numpy.random.randn(d0, d1, …, dn)是从标准正态分布中返回一个或多个样本值。
     numpy.random.rand(d0, d1, …, dn)的随机样本位于[0, 1)中。
     (6,4)表示6行4列数据
     '''
     df = pd.DataFrame(np.random.randn(6,4),index=dates,columns=['a','b','c','d'])
     print(df)
     # DataFrame既有行索引也有列索引， 它可以被看做由Series组成的大字典。

     print(df['b'])

     # 未指定行标签和列标签的数据
     df1 = pd.DataFrame(np.arange(12).reshape(3,4))
     print(df1)
     
     # 另一种方式
     df2 = pd.DataFrame({
            'A': [1,2,3,4],
            'B': pd.Timestamp('20180819'),
            'C': pd.Series([1,6,9,10],dtype='float32'),
            'D': np.array([3] * 4,dtype='int32'),
            'E': pd.Categorical(['test','train','test','train']),
            'F': 'foo'
          })
     print(df2)

     print(df2.index)

     print(df2.columns)

     print(df2.values)

     # 数据总结
     print(df2.describe())

     # 翻转数据
     print(df2.T)
     # print(np.transpose(df2))等价于上述操作

     '''
     axis=1表示行
     axis=0表示列
     默认ascending(升序)为True
     ascending=True表示升序,ascending=False表示降序
     下面两行分别表示按行升序与按行降序
     '''
     print(df2.sort_index(axis=1,ascending=True))

     print(df2.sort_index(axis=1,ascending=False))

     # 表示按列降序与按列升序
     print(df2.sort_index(axis=0,ascending=False))

     print(df2.sort_index(axis=0,ascending=True))

     # 对特定列数值排列
     # 表示对C列降序排列
     print(df2.sort_values(by='C',ascending=False))
      
### 3、pandas选择数据

#### 3.1、实战筛选

     import pandas as pd
     import numpy as np
     dates = pd.date_range('20180819', periods=6)
     df3 = pd.DataFrame(np.arange(24).reshape((6,4)),index = dates,columns=['A','B','C','D'])
     print(df3)

     # 检索A列
     print(df3['A'])

     print(df3.A)

     # 选择跨越多行或多列
     # 选取前3行
     print(df3[0:3])

     print(df3['2018-08-19':'2018-08-21'])

     # 根据标签选择数据
     # 获取特定行或列
     # 指定行数据
     print(df3.loc['20180819'])

     # 指定列
     # 两种方式
     print(df3.loc[:,'A':'B'])

     print(df3.loc[:,['A','B']])

     # 行与列同时检索
     print(df3.loc['20180819',['A','B']])

     # 根据序列iloc
     # 获取特定位置的值
     print(df3.iloc[3,1])

     print(df3.iloc[3:5,1:3]) # 不包含末尾5或3，同列表切片

     # 跨行操作
     print(df3.iloc[[1,3,5],1:3])

     # 混合选择
     print(df3.ix[:3,['A','C']])

     print(df3.iloc[:3,[0,2]]) # 结果同上

     # 通过判断的筛选
     print(df3[df.A>8])

     # 通过判断的筛选
     print(df3.loc[df.A>8])

#### 3.2、筛选总结

     1.iloc与ix区别

       总结:相同点：iloc可以取相应的值，操作方便,与ix操作类似。

            不同点：ix可以混合选择，可以填入column对应的字符选择，而iloc只能采用index索引，对于列数较多情况下，ix要方便操作许多。

     2.loc与iloc区别
       总结：相同点：都可以索引处块数据
             不同点：iloc可以检索对应值,两者操作不同。

     3.ix与loc、iloc三者的区别
       n总结：ix是混合loc与iloc操作
     
### 4.Pandas设置值

#### 4.1、创建数据
     import pandas as pd
     import numpy as np
     # 创建数据
     dates = pd.date_range('20180820',periods=6)
     df = pd.DataFrame(np.arange(24).reshape(6,4), index=dates, columns=['A','B','C','D'])
     print(df)

#### 4.2、根据位置设置loc和iloc

     # 根据位置设置loc和iloc
     df.iloc[2,2] = 111
     df.loc['20180820','B'] = 2222
     print(df) 

#### 4.3、根据条件设置
     # 根据条件设置
     # 更改B中的数，而更改的位置取决于4的位置，并设相应位置的数为0
     df.B[df.A>4] = 0
     print(df)

     df.B.loc[df.A>4] = 0
     print(df)

#### 4.4、按行或列设置
      
     # 按行或列设置
     # 列批处理，F列全改为NaN
     df['F'] = np.nan
     print(df) 
     
#### 4.5、添加Series序列（长度必须对齐）
     
     df['E'] = pd.Series([1,2,3,4,5,6], index=pd.date_range('20180820',periods=6))
     print(df)

#### 4.6、设定某行某列为特定值

     # 设定某行某列为特定值
     df.ix['20180820','A'] = 56
     print(df)
     #ix 以后要剥离了，尽量不要用了

     df.loc['20180820','A'] = 67
     print(df)

     df.iloc[0,0] = 76
     print(df)

#### 4.7、修改一整行数据

     # 修改一整行数据
     df.iloc[1] = np.nan # df.iloc[1,:]=np.nan
     print(df)

     df.loc['20180820'] = np.nan # df.loc['20180820,:']=np.nan
     print(df)

     df.ix[2] = np.nan # df.ix[2,:]=np.nan
     print(df)

     df.ix['20180823'] = np.nan
     print(df)

### 5、Pandas处理丢失数据

#### 5.1、创建含nan的矩阵
     
     # Pandas处理丢失数据
     import pandas as pd
     import numpy as np
     # 创建含NaN的矩阵
     # 如何填充和删除NaN数据?
     dates = pd.date_range('20180820',periods=6)
     df = pd.DataFrame(np.arange(24).reshape((6,4)),index=dates,columns=['A','B','C','D']) 
     print(df)

     # a.reshape(6,4)等价于a.reshape((6,4))
     df.iloc[0,1] = np.nan
     df.iloc[1,2] = np.nan
     print(df)

#### 5.2、删除所有带nan的行或列

     # 删除掉有NaN的行或列
     print(df.dropna()) # 默认是删除掉含有NaN的行

     print(df.dropna(
              axis=0, # 0对行进行操作;1对列进行操作
              how='any' # 'any':只要存在NaN就drop掉；'all':必须全部是NaN才drop
              ))

     # 删除掉所有含有NaN的列
     print(df.dropna(
             axis=1,
             how='any'
          ))         

#### 5.3、替换NaN值为0或者其他

     # 替换NaN值为0或者其他
     print(df.fillna(value=0))

#### 5.4、是否有缺失数据NaN

     # 是否有缺失数据NaN
     # 是否为空
     print(df.isnull())
     
     # 是否为NaN
     print(df.isna())

     # 检测某列是否有缺失数据NaN
     print(df.isnull().any())

     # 检测数据中是否存在NaN,如果存在就返回True
     print(np.any(df.isnull())==True)

### 6、Pandas导入数据

#### 6.1、导入数据
     import pandas as pd # 加载模块
     # 读取csv
     data = pd.read_csv('student.csv')
     # 打印出data
     print(data)

     # 前三行
     print(data.head(3))

     # 后三行
     print(data.tail(3))

#### 6.2、导出数据

     # 将资料存取成pickle
     data.to_pickle('student.pickle')
     
     # 读取pickle文件并打印
     print(pd.read_pickle('student.pickle'))

### 7、Pandas合并操作

#### 7.1、Pandas合并concat

     import pandas as pd
     import numpy as np
     # 定义资料集
     df1 = pd.DataFrame(np.ones((3,4))*0, columns=['a','b','c','d'])
     df2 = pd.DataFrame(np.ones((3,4))*1, columns=['a','b','c','d'])
     df3 = pd.DataFrame(np.ones((3,4))*2, columns=['a','b','c','d'])
     print(df1)  

     print(df2)

     print(df3)

     # concat纵向合并
     res = pd.concat([df1,df2,df3],axis=0)
     # 打印结果
     print(res)   

     # 上述合并过程中，index重复，下面给出重置index方法
     # 只需要将index_ignore设定为True即可
     res = pd.concat([df1,df2,df3],axis=0,ignore_index=True)
     # 打印结果
     print(res)

     # join 合并方式
     # 定义资料集
     df1 = pd.DataFrame(np.ones((3,4))*0, columns=['a','b','c','d'], index=[1,2,3])
     df2 = pd.DataFrame(np.ones((3,4))*1, columns=['b','c','d','e'], index=[2,3,4])
     print(df1)

     print(df2)

     '''
     join='outer',函数默认为join='outer'。此方法是依照column来做纵向合并，有相同的column上下合并在一起，
     其他独自的column各自成列，原来没有值的位置皆为NaN填充。
     '''
     # 纵向"外"合并df1与df2
     res = pd.concat([df1,df2],axis=0,join='outer')
     print(res)

     # 修改index
     res = pd.concat([df1,df2],axis=0,join='outer',ignore_index=True)
     print(res)

     # join='inner'合并相同的字段
     # 纵向"内"合并df1与df2
     res = pd.concat([df1,df2],axis=0,join='inner')
     # 打印结果
     print(res)

     # join_axes(依照axes合并)
     # 定义资料集
     df1 = pd.DataFrame(np.ones((3,4))*0, columns=['a','b','c','d'], index=[1,2,3])
     df2 = pd.DataFrame(np.ones((3,4))*1, columns=['b','c','d','e'], index=[2,3,4])
     print(df1)

     print(df2)

     # 依照df1.index进行横向合并
     res = pd.concat([df1,df2],axis=1,join_axes=[df1.index])
     print(res)

     # 移除join_axes参数,打印结果
     res = pd.concat([df1,df2],axis=1)
     print(res)

     # append(添加数据)
     # append只有纵向合并，没有横向合并
     # 定义资料集
     df1 = pd.DataFrame(np.ones((3,4))*0, columns=['a','b','c','d'])
     df2 = pd.DataFrame(np.ones((3,4))*1, columns=['a','b','c','d'])
     df3 = pd.DataFrame(np.ones((3,4))*2, columns=['a','b','c','d'])
     s1 = pd.Series([1,2,3,4], index=['a','b','c','d'])
     # 将df2合并到df1下面,以及重置index,并打印出结果
     res = df1.append(df2,ignore_index=True)
     print(res)

     # 合并多个df,将df2与df3合并至df1的下面,以及重置index,并打印出结果
     res = df1.append([df2,df3], ignore_index=True)
     print(res)

     # 合并series,将s1合并至df1，以及重置index，并打印结果
     res = df1.append(s1,ignore_index=True)
     print(res)

     # 总结:两种常用合并方式
     res = pd.concat([df1, df2, df3], axis=0, ignore_index=True)
     res1 = df1.append([df2, df3], ignore_index=True)
     print(res)
     print(res1)

#### 7.2、Pandas 合并 merge

     7.2.1、定义资料集并打印出
     
     import pandas as pd
     # 依据一组key合并
     # 定义资料集并打印出
     left = pd.DataFrame({'key' : ['K0','K1','K2','K3'],
                          'A' : ['A0','A1','A2','A3'],
                          'B' : ['B0','B1','B2','B3']})
     right = pd.DataFrame({'key': ['K0', 'K1', 'K2', 'K3'],
                            'C' : ['C0', 'C1', 'C2', 'C3'],
                            'D' : ['D0', 'D1', 'D2', 'D3']})
     print(left)

     print(right)

     7.2.2 依据key column合并,并打印
     
     # 依据key column合并,并打印
     res = pd.merge(left,right,on='key')
     print(res)

     # 依据两组key合并
     # 定义资料集并打印出
     left = pd.DataFrame({'key1': ['K0', 'K0', 'K1', 'K2'],
                          'key2': ['K0', 'K1', 'K0', 'K1'],
                          'A': ['A0', 'A1', 'A2', 'A3'],
                          'B': ['B0', 'B1', 'B2', 'B3']})
     right = pd.DataFrame({'key1': ['K0', 'K1', 'K1', 'K2'],
                           'key2': ['K0', 'K0', 'K0', 'K0'],
                           'C': ['C0', 'C1', 'C2', 'C3'],
                           'D': ['D0', 'D1', 'D2', 'D3']})
     print(left)

     print(right)

     7.2.3 两列合并

     # 依据key1与key2 columns进行合并，并打印出四种结果['left', 'right', 'outer', 'inner']
     res = pd.merge(left, right, on=['key1', 'key2'], how='inner')
     print(res)

     res = pd.merge(left, right, on=['key1', 'key2'], how='outer')
     print(res)

     res = pd.merge(left, right, on=['key1', 'key2'], how='left')
     print(res)

     res = pd.merge(left, right, on=['key1', 'key2'], how='right')
     print(res)

     7.2.4 Indicator设置合并列名称

     # Indicator
     df1 = pd.DataFrame({'col1':[0,1],'col_left':['a','b']})
     df2 = pd.DataFrame({'col1':[1,2,2],'col_right':[2,2,2]})
     print(df1)

     print(df2)

     # 依据col1进行合并,并启用indicator=True,最后打印
     res = pd.merge(df1,df2,on='col1',how='outer',indicator=True)
     print(res)

     # 自定义indicator column的名称,并打印出
     res = pd.merge(df1,df2,on='col1',how='outer',indicator='indicator_column')
     print(res)

     7.2.5 依据index合并

     # 依据index合并
     # 定义资料集并打印出
     left = pd.DataFrame({'A': ['A0', 'A1', 'A2'],
                          'B': ['B0', 'B1', 'B2']},
                          index=['K0', 'K1', 'K2'])
     right = pd.DataFrame({'C': ['C0', 'C2', 'C3'],
                           'D': ['D0', 'D2', 'D3']},
                          index=['K0', 'K2', 'K3'])
     print(left)

     print(right)

     # 依据左右资料集的index进行合并,how='outer',并打印
     res = pd.merge(left,right,left_index=True,right_index=True,how='outer')
     print(res)

     # 依据左右资料集的index进行合并,how='inner',并打印
     res = pd.merge(left,right,left_index=True,right_index=True,how='inner')
     print(res)

     7.2.6 解决overlapping的问题

     # 解决overlapping的问题
     # 定义资料集
     boys = pd.DataFrame({'k': ['K0', 'K1', 'K2'], 'age': [1, 2, 3]})
     girls = pd.DataFrame({'k': ['K0', 'K0', 'K3'], 'age': [4, 5, 6]})
     print(boys)

     print(girls)

     # 使用suffixes解决overlapping的问题
     # 比如将上面两个合并时,age重复了,则可通过suffixes设置,以此保证不重复,不同名
     res = pd.merge(boys,girls,on='k',suffixes=['_boy','_girl'],how='inner')
     print(res)

### 8、Pandas plot出图
    
    import pandas as pd
    import numpy as np
    import matplotlib.pyplot as plt

    data = pd.Series(np.random.randn(1000), index=np.arange(1000))
    print(data)

    print(data.cumsum())

    # data本来就是一个数据，所以我们可以直接plot
    data.plot()
    plt.show()

    # np.random.randn(1000,4) 随机生成1000行4列数据
    # list("ABCD")会变为['A','B','C','D']
    data = pd.DataFrame(
         np.random.randn(1000,4),
         index=np.arange(1000),
         columns=list("ABCD")
     )
    data.cumsum()
    data.plot()
    plt.show()

    ax = data.plot.scatter(x='A',y='B',color='DarkBlue',label='Class1')
    # 将之下这个 data 画在上一个 ax 上面
    data.plot.scatter(x='A',y='C',color='LightGreen',label='Class2',ax=ax)
    plt.show()





