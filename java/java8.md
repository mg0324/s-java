> 如下是列举的一些java8中升级的特性，并不是所有的。

## 数据结构的升级
* HashMap底层优化
* CurrentHashMap底层优化，提高了其吞吐量和扩展性。

## JVM内存结构优化
移除了PermGen空间，将永久代（Permanent Generation）替换为元数据区（Metaspace），且使用的是直接内存（物理内存）。

## 支持Lambda表达式
* Lambda表达式
* 函数式接口
* 4大内置函数式接口

## 支持Stream Api
提供了一种更简单的方式来处理集合中的元素，从而使代码更易读、更安全、更高效。

## Optional类处理空指针