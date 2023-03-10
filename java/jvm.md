> 2022年8月阅读 周志磊的《深入理解Java虚拟机》* 第二版的总结笔记。

## 知识大纲

<div class="plantuml">

```plantuml
@startmindmap
*[#white] Java虚拟机
** 走近Java
*** Java发展历史
*** 编译OpenJDK8u
**[#pink] 内存区域
*** 熟悉JVM内存区域
****_ 1.7 JVM栈、本地方法栈、程序计数器和堆、方法区
****_ 1.8 JVM栈、本地方法栈、程序计数器和堆、元数据、直接内存
*** 熟悉HotSpot中的对象
****_ 对象头
*****_ MarkWord标记
*****_ klass类指针
*****_ 数组长度
****_ 实例数据
****_ 对齐
*** 如何计算Java的对象大小
**[#skyblue] 垃圾收集
*** 垃圾判断算法与4大引用
****_ 引用计数算法
****_ 根可达分析算法
****_ 强软弱虚引用
*** 回收堆和方法区中的对象
*** 垃圾收集算法
****_ 标记清除
****_ 复制
****_ 标记整理
****_ 分代收集
*** hotspot垃圾算法实现
****_ 枚举根节点
****_ 安全点
****_ 安全区域
****_ 记忆集、卡表和写屏障
****_ 并发的可达性分析
*** 常用垃圾收集器
****_ CMS
****_ G1
*** 内存分配与回收策略
** 虚拟机工具
*** JDK提供的工具
****_ 故障分析工具：jps、jstat、jinfo、jmap、jhat、jstack
****_ 性能监控工具：jhsdb、jconsole、visualVM、jmc
****_ 其他工具：hsdis、JITWatch
*** 一次idea启动速度调优
--[#orange] 类文件结构
--- 熟悉Java类文件Class的结构
----_ 魔数及版本
----_ 常量池
----_ 访问标志
----_ 类索引、父类索引和接口索引集合
----_ 字段表集合
----_ 方法表集合
----_ 属性表集合
--- 熟悉JVM字节码指令
--- 字节码指令表
--[#orange] 类加载机制
--- 深入类加载机制
----_ 加载
----_ 验证
----_ 准备
----_ 解析
----_ 初始化
----_ 卸载
--- 类加载器
----_ 类加载器层次结构
----_ 双亲委派模型
--[#orangered] 字节码执行引擎
--- 虚拟机栈
--- 基于栈的字节码解释执行引擎
-- 前端编译与优化
--- javac编译器
--- 语法糖
--- 插入式注解处理器
-- 后端编译与优化
--- 及时编辑器
--- 提前编译器
--- 常见编译器优化技术

@endmindmap
```
</div>

## 走近Java
* [Java的发展历史](http://mg.meiflower.top/mb/post/jvm/Java%E5%8F%91%E5%B1%95%E5%8E%86%E5%8F%B2/)
* [Mac10.15.7上编译OpenJDK8u](http://mg.meiflower.top/mb/post/jvm/MacOs10_15_7%E7%BC%96%E8%AF%91openjdk8u/)

## 内存区域
* [熟悉JVM内存区域](http://mg.meiflower.top/mb/post/jvm/%E7%86%9F%E6%82%89JVM%E5%86%85%E5%AD%98%E5%8C%BA%E5%9F%9F/)
* [熟悉HotSpot中的对象](http://mg.meiflower.top/mb/post/jvm/%E7%86%9F%E6%82%89HotSpot%E4%B8%AD%E7%9A%84%E5%AF%B9%E8%B1%A1/)
* [如何计算Java对象的大小](http://mg.meiflower.top/mb/post/jvm/%E5%A6%82%E4%BD%95%E8%AE%A1%E7%AE%97Java%E5%AF%B9%E8%B1%A1%E7%9A%84%E5%A4%A7%E5%B0%8F/)

## 垃圾收集
* [垃圾判断算法与4大引用](http://mg.meiflower.top/mb/post/jvm/%E5%9E%83%E5%9C%BE%E5%88%A4%E5%AE%9A%E7%AE%97%E6%B3%95%E4%B8%8E4%E5%A4%A7%E5%BC%95%E7%94%A8/)
* [回收堆和方法区中对象](http://mg.meiflower.top/mb/post/jvm/%E5%9B%9E%E6%94%B6%E5%A0%86%E5%92%8C%E6%96%B9%E6%B3%95%E5%8C%BA%E4%B8%AD%E5%AF%B9%E8%B1%A1/)
* [垃圾收集算法](http://mg.meiflower.top/mb/post/jvm/%E5%9E%83%E5%9C%BE%E6%94%B6%E9%9B%86%E7%AE%97%E6%B3%95/)
* [HotSpot虚拟机垃圾算法实现之枚举根节点、安全点和安全区域](http://mg.meiflower.top/mb/post/jvm/HotSpot%E5%9E%83%E5%9C%BE%E7%AE%97%E6%B3%95%E5%AE%9E%E7%8E%B0%E4%B9%8B%E6%9E%9A%E4%B8%BE%E6%A0%B9%E8%8A%82%E7%82%B9%E5%92%8C%E5%AE%89%E5%85%A8%E7%82%B9%E5%AE%89%E5%85%A8%E5%8C%BA%E5%9F%9F/)
* [HotSpot虚拟机垃圾算法实现之记忆集与卡表和写屏障](http://mg.meiflower.top/mb/post/jvm/HotSpot%E5%9E%83%E5%9C%BE%E7%AE%97%E6%B3%95%E5%AE%9E%E7%8E%B0%E4%B9%8B%E8%AE%B0%E5%BF%86%E9%9B%86%E5%8D%A1%E8%A1%A8%E5%92%8C%E5%86%99%E5%B1%8F%E9%9A%9C/)
* [HotSpot虚拟机垃圾算法实现之并发的可达性分析](http://mg.meiflower.top/mb/post/jvm/HotSpot%E5%9E%83%E5%9C%BE%E7%AE%97%E6%B3%95%E5%AE%9E%E7%8E%B0%E4%B9%8B%E5%B9%B6%E5%8F%91%E5%8F%AF%E8%BE%BE%E6%80%A7%E5%88%86%E6%9E%90/)
* 常用垃圾收集器
* [内存分配与回收策略](http://mg.meiflower.top/mb/post/jvm/%E5%86%85%E5%AD%98%E5%88%86%E9%85%8D%E4%B8%8E%E5%9B%9E%E6%94%B6%E7%AD%96%E7%95%A5/)

## 虚拟机工具
* [Java虚拟机相关工具](http://mg.meiflower.top/mb/post/jvm/Java%E8%99%9A%E6%8B%9F%E6%9C%BA%E7%9B%B8%E5%85%B3%E5%B7%A5%E5%85%B7/)
* [一次IDEA启动速度调优](http://mg.meiflower.top/mb/post/idea/IDEA%E7%9A%84%E5%90%AF%E5%8A%A8%E9%80%9F%E5%BA%A6%E4%BC%98%E5%8C%96/)

## 类文件结构
* [熟悉Java类文件Class的结构](http://mg.meiflower.top/mb/post/jvm/%E7%86%9F%E6%82%89Java%E7%B1%BB%E6%96%87%E4%BB%B6class%E7%BB%93%E6%9E%84/)
* [熟悉JVM字节码指令](http://mg.meiflower.top/mb/post/jvm/%E7%86%9F%E6%82%89JVM%E5%AD%97%E8%8A%82%E7%A0%81%E6%8C%87%E4%BB%A4/)
* [JVM字节码指令表](/java/bytecode.md)

## 类加载机制
* [深入类加载机制](http://mg.meiflower.top/mb/post/jvm/%E6%B7%B1%E5%85%A5%E7%B1%BB%E5%8A%A0%E8%BD%BD%E6%9C%BA%E5%88%B6/)
* [类加载器](http://mg.meiflower.top/mb/post/jvm/%E7%B1%BB%E5%8A%A0%E8%BD%BD%E5%99%A8/)


## 字节码执行引擎
* 认识并熟悉虚拟机栈
* 基于栈的字节码解释执行引擎

## 前端编译与优化
* javac编译器
* 语法糖
* 插入式注解处理器

## 后端编译与优化
* 及时编译器
* 提前编译器
* 常见编译器优化技术
* [使用 GraalVM 为 Java 应用程序构建最少的 Docker 镜像](https://aws.amazon.com/cn/blogs/china/using-graalvm-build-minimal-docker-images-java-applications/)


<!-- <iframe src="http://mg.meiflower.top/cardview/index.html?id=1" style="width:100%;height: 400px;"></iframe>


<iframe src="http://mg.meiflower.top/cardview/index.html?id=d1e3f1335afe454c9ea6e804cb6b29d7" style="width:100%;height: 400px;"></iframe> -->

