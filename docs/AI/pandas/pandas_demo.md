## 一、 10 minutes in pandas
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

    1、


     













