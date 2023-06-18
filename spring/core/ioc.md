## 概念
IoC就是控制反转，是一种思想，将对象创建交个spring管理，而DI（依赖注入）是一种具体的实现。

## 快速入门
* 从xml配置文件创建spring ioc，ClassPathXmlApplicationContext
编写示例通过bean输出hello spring。

!> 通过xml配置方式来完成，后续可以通过注解配置方式完成。


## bean的三种获取方式
* context.getBean(name)
* context.getBean(class)
* context.getBean(name,class)

## 依赖注入
* setter和constructor方式注入
* 简单类型注入
* 复杂类型（对象、List、Map）注入
* p命名空间
* 自动装配 autowire=byType、byName

## 引入外部配置文件
如jdbc.properties，然后用${jdbc.user}来获取。

## bean的作用域
* 默认scope=singleton单例，初始化容器时就创建
* 可设置scope=prototype多实例，在获取对象时创建

## bean的生命周期
1. 调用无参构造方法
2. 属性注入
3. BeanPostProcessor的before方法执行
4. 调用指定的init-method(不推荐使用InitializingBean，有耦合)
5. BeanPostProcessor的after方法执行
6. 实例化完成，可以使用了
7. 调用指定的destory-method(不推荐使用DisposableBean，有耦合)
8. 

``` java
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

	// simply return the instantiated bean as-is
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		return bean; // we could potentially return any object reference here...
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) {
		System.out.println("Bean '" + beanName + "' created : " + bean.toString());
		return bean;
	}
}
```

## 容器扩展点
* BeanPostProcessor
* FactoryBean - 工厂方式创建bean

## 注解方式开发
* 从注解创建：AnnotationConfigApplicationContext
* 定义Bean：@Controller、@Service、@Repository、@Compontent
* 依赖注入：@Autowire、@Qualifier、@Resource、@CompontentScan
* 配置类：@Configuration