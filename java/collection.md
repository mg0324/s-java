> Java集合框架是Java中用于存储、操作、查询集合（数据结构）的一组类和接口。<br/>
> 

## 成员列表

* `Collection`接口
  * `List`接口 - 有序可重复集合
    - 常用实现类有 `ArrayList`、`LinkedList`
  * `Set`接口 - 无序不可重复集合
    - 常用实现类有 `HashSet`、`TreeSet`
  * `Queue`接口 - `FIFO`顺序集合
    - 常用实现类有 `LinkedList`、`PriorityQueue`
  * `Deque`接口 - 双端队列
    - 常用实现类有 `LinkedList`和 `ArrayDeque`
* `Map`接口 - 不是集合，用于存储键值对
  - 常用实现类有 `HashMap`、`LinkedHashMap`、`TreeMap`

## 工具类

* `java.util.Collections`工具类提供了一组静态方法来操作集合，如排序、二分查找和替换。
* `java.util.Arrays`工具类，提供了排序、二分查找和替换等操作方法。

## 好文推荐
* [Java集合框架](https://pdai.tech/md/java/collection/java-collection-all.html)