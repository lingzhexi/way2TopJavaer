## 1.Maven配置
   + 添加三个spring依赖，分别为:spring-core,spring-context,spring-webmvc,声明版本号
## 2.构建java代码路径
   + src/main/java 设置为Sources Root
## 3.新建springmvc两个配置
   + src目录下新建resources，配置为Reources Root在这个目录里面新建两个文件
   + spring-sevlet配置文件：mvc-dispatcher.xml
   + spring-mvc配置文件：applicationContext.xnl
## 4.配置web.xml
   + 主要配置两个节点：filter，servlet
## 5.配置mvc-dispatcher.xml
      
      //扫描器，会自动扫描该包下有@Controller注解的类
      <context:component-scan base-package="com.zxling.controller"/>
      
      <!-- 配置注解驱动 --><!--可以使用注解-->
      <mvc:annotation-driven/>
      
      <!-- 视图解析器， 
      //当controller返回字符串的时候，就会去/WEB-INF/views/下面找对应字符串名字的jsp文件-->
      <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
          <!--前缀-->
          <property name="prefix" value="/WEB-INF/views/"/>
          <!--后缀-->
          <property name="suffix" value=".jsp"/>
      </bean>
## 6.新建一个Controller
           
      @Controller
      @RequestMapping("/developer")
      public class MyController {
        @RequestMapping(value = "/hello", method = RequestMethod.GET)
        public String hello() {
          return "hello";
        }
      }
       
   1. @Controller可在扫描时,将这个扫描成bean
   2. @RequestMapping,dispatchservlet会调用改路径下的方法
   3. 返回值hello,根据配置会找到WEB-INF/views/hello.jsp
## 7.新建对应的jsp视图(hello.jsp)
       <html>
       <body>
           <h2>hello</h2>
       </body>
       </html>
## 8.运行配置Tomcat
        
        访问:http://localhost:8080/say/hello
        可以得到hello.jsp中的内容
       
## 9.总结:遇到的问题
1. ContextLoaderListener类找不到问题

    问题：
     * 启项目的时候出现:ClassNotFound的异常,
     * 其中找不到org.springframework.web.context.ContextLoaderListener
     
    原因:
      * 由于tomcat服务器部署的项目WEB-InF/lib文件中没有这个类的包
      * 项目部署在tomcat后,路径一般是在Tomcat/webapp/Root下
     
    解决方式
      * [解决地址](https://www.2cto.com/kf/201806/754904.html)
      * idea方式：
        实际在Idea中这样配置：
        File > Project Structure > Artifacts > 在右侧Output Layout右击项目名，选择Put into Output Root,见下面截图：
      ![idea步骤1](https://www.2cto.com/uploadfile/Collfiles/20180616/20180616143031678.png)
       执行后，在WEB-INF在增加了lib目录，里面是项目引用的jar包，点击OK。
      ![idaa步骤2](https://www.2cto.com/uploadfile/Collfiles/20180616/20180616143031679.jpg)     
          
