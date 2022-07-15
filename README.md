# Mybatis-demo
Mybatis-demo

<br></br>
## Mybatis学习记录
<br></br>
## 残留不会解决的-痛的出血的-令人迷惑的-焦虑的-掉发的 bug
1. `mybatis-config.xml` 中包导入语句出错，但在另一个项目中却能成功 :(
```xml
    <!-- 这句不会报错 -->
    <mapper resource="com.demo.mapper/BrandMapper.xml"/>
    
    <!-- 这句会报错 -->
    <package name="com.demo.mapper"/>
```

2. 批量选择/删除操作中 `foreach` 标签运行结果肥肠滴异常
```java
    // mapper定义接口
    void delByIds(int[] ids);


    // 调用
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
    mapper.delByIds(new int[]{2,4}); // 这里无论是提前声明传入数组还是在参数中声明都不能解决问题...
```
```xml
    <!-- 极其的离谱，如果传入的数组里有单个数据不会有任何反应，但如果数组内有大于一个只会删除首个数据 -->
    <!-- 比如像上文一样传入[2,4] 就会只删除id为1的数据 （如果没有就不删） 我直接？？？ -->
    <delete id="delByIds">
        delete from tb_user where id in
        <foreach collection="array" index="id" separator="," open="(" close=")">
            #{id}
        </foreach>
    </delete>
```