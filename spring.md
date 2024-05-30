### spring Framework总览
- 核心特性
    - Ioc容器（Ioc Container）
    - Spring 事件(Events)
    - 资源管理(Resources)
    - 国际化(i18n)
    - 校验(Validation)
    - 数据绑定(Data Binding)
    - 类型转换(Type Conversion)
    - Spring 表达式(Spring Express Language)
    - 面向切面编程(AOP)
    
- 数据存储（Data Access）
    - JDBC
    - 事务抽象
    - DAO 支持（DAO Support）
    - O/R映射（O/R Mapping）
    - XML编列
 
- Web技术（WEb）
    - Web Servlet 技术栈
        - Spring MVC
        - WebSocket
        - SockJS
    - Web Reactive 技术栈
        - Spring WebFlux
        - WebClient
        - WebSocket

- 技术整合（Integration）
    - 远程调用（Remoting）
    - Java 消息服务（JMS）
    - Java 连接架构（JCA）
    - Java 管理扩展（JMX）
    - Java 邮件客户端（Email）
    - 本地任务（Tasks）
    - 本地调度（Scheduling）
    - 缓存抽象（Caching）
    - Spring 测试（Testing）

- 测试 （Testing）
    - 模拟对象（Mock Objects）
    - TestContext 框架（TestContext Framework)
    - Spring MVC 测试（Spring MVC Test）
    - Web 测试客户端
    
### Spring 编程模型
- 面向对象编程
    - 契约接口： Aware、BeanPostProcessor
    - 设计模式：观察者模式、组合模式、模板模式
    - 对象继承： Abstarct* 类
- 面向切面编程
    - 动态代理: JDK DynamicAopProxy
    - 字节码提升： ASM、CGLib、AspectJ
- 面向元编程
    - 注解：模式注解
    - 配置：Environment 抽象、PropertySources
    - 泛型：Generic TypeResolvableType
- 函数驱动：
    - 函数接口： ApplicationEventPublisher
    - Rective: Spring WebFlux
- 模块驱动：
    - Maven Artifacts
    - OSGI Bundles
    
### IOC认识
- 主要实现策略
    - 服务定位模式
    - 使用依赖注入
    - 使用上下文查询
    - 模板方法的设计模式
    - 策略模式
- 主要职责
    - 通用职责
    - 依赖处理
        - 依赖查找
            - 根据Bean名称查找
                - 实时查找（BeanFactory）
                - 延迟查找（ObjectFactory）
            - 根据Bean类型查找
                - 单个Bean对象
                - 集合Bean对象
            - 根据Bean名称 + 类型查找
            - 根据Java 注解查找
                - 单个Bean对象
                - 集合Bean对象
        - 依赖注入
            - 根据Bean名称注入
            - 根据Bean类型注入
                - 单个Bean对象
                - 集合Bean对象
            - 注入容器内建Bean对象
            - 注入非Bean对象
            - 注入类型
                - 实时注入
                - 延迟注入
    - 生命周期管理
        - 容器
        - 托管的资源
    - 配置
        - 容器
        - 外部化配置
        - 托管的资源
- 依赖来源
    - 自定义Bean
    - 容器内建Bean对象
    - 容器内建依赖
- 配置元信息 
    - Bean定义配置
        - 基于XML文件
        - 基于Properties文件
        - 基于java注解
        - 基于java api 
    - Ioc容器配置
        - 基于XML文件
        - 基于Java注解
        - 基于Java Api
    - 外部化属性配置
        - 基于Java注解    
- ApplicationContext
    - 提提供IOC容器
    - 面向切面
    - 配置元信息
    - 资源管理
    - 事件
    - 国际化
    - 注解
    - Environment 抽象
- 使用Spring IOC 的容器
    - BeanFactory 是Spring 底层容器
    - ApplicationContext 是具备应用特性的BeanFactory超集
- Ioc 生命周期        
    - 启动
        refresh()
    - 运行
    
    - 停止
        doClose()

### Spring Bean 基础
- 定义Spring Bean
    - BeanDefinition 是Spring Framework中定义Bean的配置元信息接口，包含：bean 的类名；bean行为配置元素，如作用域，自动绑定的模式，生命周期回调等；其他bean引用，又可称为合作者或者依赖；配置设置，比如Bean属性
- BeanDefinition 元信息
    - class,name,scope,constuctor arguments等
- 命名Spring Bean
    - bean的id和name 属性并非必须制定，如果留空的话，容器会成为Bean自动生成一个唯一的名称。
- 注册Spring Bean
    - XML配置元信息：<bean name=""/>
    - Java 注解配置元信息：@Bean，@Component，@Import
    - Java api 配置元信息
- Bean 实例化
    - 常规方式
        - 通过构造器（配置元信息：XML、Java注解和Java API）
        - 通过静态工厂方法（配置元信息：XML和Java API）
        - 通过Bean工厂方法（配置元信息：XML和Java API）
        - 通过FactoryBean（配置元信息：XML、Java注解和Java API）
    - 特殊方式
        - 通过ServiceLoaderFactoryBean(配置元信息：XML、Java注解和Java API)
        - 通过AutowireCapableBeanFactory#createBean(java.lang.Class, int,boolean)
        - 通过BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
- Bean 初始化方式
    - @PostConstruct 标注(第一出现)
    - 实现IntializingBean 接口的afterPropertiesSet()方法(第三出现)
    - 自定义初始化方法(第二出现)
        - XML 配置：<bean init-method="init/>
        - Java 注解：@Bean(initMethod="init")
        - Java API: AbstractBeanDefinition#setInitMethodName(String)
- Bean 延迟初始化
    - XML 配置：<bean lazy-init="true"/>
    - Java 注解： @Lazy(true)
- Bean 销毁
    - @PreDestory 标注方法
    - 实现DisposableBean 接口实现 destory()方法
    - 自定义销毁方法
        - XML 配置：<bean destroy="destroy"/>   
        - Java 注解： @Bean(destroy="destroy")
        - Java API: AbstractBeanDefinition#setDestroyMethodName(String)
- Bean 垃圾回收（GC）        
    - 关闭Spring容器上下文
    - 执行GC
    - Spring Bean 覆盖的finalize()方法被回调

### Spring Ioc 依赖查找
- 47    
            
        
            
 