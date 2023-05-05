> 如下是列举的一些java8中升级的特性，并不是所有的。

## 数据结构的升级
* HashMap底层优化
* CurrentHashMap底层优化，提高了其吞吐量和扩展性。

## JVM内存结构优化
移除了PermGen空间，将永久代（Permanent Generation）替换为元数据区（Metaspace），且使用的是直接内存（物理内存）。

## 支持Lambda表达式
* Lambda表达式
  () -> {}
* 函数式接口
  @FunctionalInterface
* 4大内置函数式接口
  * @Consumer
  * @Supplier
  * @Function
  * @Predicate

## 方法引用及构造器引用

* `Consumer<String> con = System.out::println;`
* `Supplier<String> sup = String::new;`

## 支持Stream Api
Stream流操作不回改变源数据，经过一些列中间操作再通过结束操作生成一个新的流。提供了一种更简单的方式来处理集合中的元素，从而使代码更易读、更安全、更高效。

### Stream流的创建
#### 集合创建
* list.stream()
  
#### 数组创建
* Arrays.stream()
  
#### Stream的静态方法
* Stream.of()
* Stream.iterate()
* Stream.generate()

### 中间操作和结束操作
中间操作只有遇到结束操作时才会执行。
* 中间操作，如filter()、limit()、map()、order()等
* 结束操作，如forEach()、toArray()、collect()、anyMatch()等。

### filter过滤和limit截取
* list.stream().filter()
* list.strea.limit(2)

### map映射
* list.stream().map((e) -> e.toUpperCase());

### order排序 和 distinct去重
* list.stream().order()
* list.stream().distinct() 需要重写对象的hashCode()和equals()方法

### 串行和并行
* list.stream() 串行
* list.parallelStream() 并行

### 查找的匹配
* list.stream().findFirst()
* list.stream().findAny()
* list.stream().anyMatch()
* list.stream().allMatch()

## Optional类处理空指针
Optional是Java 8中引入的一种新的类型，旨在解决空指针异常。
