### springbootv 2.5.6
1. sb2是一个多用途的集成框架，
    - 能够集成很多的功能，简化开发
    - 简化了很多配置
    - 嵌入Tomcat,Jetty或Undertow等web容器
    
2. 打包方式:
    - jar
    - war
3. 约定大于配置，表示没有配置的地方，均使用默认配置
    SpringBoot中，约定大于配置可以从以下两个方面来理解：
    - 开发人员仅需规定应用中不符合约定的部分
    - 在没有规定配置的地方，采用默认配置，以力求最简配置为核心思想
    
    具体如下：
    - Maven的目录结构。默认有resources文件夹,存放资源配置文件。src-main-resources,src-main-java。默认的编译生成的类都在targe文件夹下面
    - spring boot默认的配置文件必须是，也只能是application.命名的yml文件或者properties文件，且唯一
    - application.yml中默认属性。数据库连接信息必须是以spring: d
        根据运行环境自动读取不同的配置文件；端口号、请求路径等
4. > 环境要求：tomcat8.5、jetty9.4
    -maven3.2、gradle4.0
    上述是组件的最低版本要求
    
5. - application.yml和application.properties的配置使用优先级
    - properties优先级高，可以通过动态配置哪个配置文件生效,见示例
    - application-***.properties > application.properties > yml
    
    - 指定配置文件
    java -jar wechat-1.jar --spring.config.location=D:/appplicaton.properties
    
6. - 轻量的逻辑可放在Bean的@PostConstruct方法中
   - 耗时长的逻辑如果放在@PostConstruct方法中，可使用独立线程执行
   - 初始化操作放在CommandLineRunner或ApplicationRunner的实现组件中
   
7. lifecycle和smartlifecycle区别
    - 共同点，都是加载所有的bean完成之后执行固定的操作
    - 是在容器本身的生命周期进行处理，postconstruct,predestory都是在bean的生命周期上进行处理
    
8. application runner和commandline runner
   - 两者接收到的参数不一样crunner是原始类型未封装
   - app runner优先于command runner运行
   
   需要解决问题:
       - ApplicationRunner与CommandLineRunner谁先执行
       - 两者的区别在哪
       - 多个CommandLineRunner 执行顺序问题
       
9. spring的自动配置
     > Spring Boot启动的时候会通过@EnableAutoConfiguration注解找到META-INF/spring.factories配置文件中的所有自动配置类，并对其进行加载；
   而这些自动配置类都是以AutoConfiguration结尾来命名的。它们实际上就是一个JavaConfig形式的Spring容器配置类，
   这些配置类通过寻找以Properties结尾命名的类，进而取得在全局配置文件中配置的属性，如：server.port。
   然后XxxProperties类再通过@ConfigurationProperties注解与全局配置文件中对应的属性进行绑定。
        
10. > Bean 的生命周期概括起来就是 4 个阶段：
      
      实例化（Instantiation）
      属性赋值（Populate）
      初始化（Initialization）
      销毁（Destruction）
      
11.web开发两种方式
   
   1. 前后端分离，restful接口对接
   2. 使用内置的模板开发web应用
   
   >内置模板，指的是后端模板，前端模板是js解析页面html标记；
   >后端模板表示的是解析标记，填充数据，最终返回的是html页面；
 
        
