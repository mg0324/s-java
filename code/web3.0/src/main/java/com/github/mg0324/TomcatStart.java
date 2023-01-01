package com.github.mg0324;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import javax.servlet.ServletException;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * servlet3.1 tomcat8.5 启动器
 */
public class TomcatStart {
    
    public static void main(String[] args) throws ServletException, LifecycleException {
        int port = 9000; //默认
        if(args.length > 0){
            System.out.print("传入的参数列表为：");
            Arrays.stream(args).forEach(System.out::println);
            if(Objects.nonNull(args[0])){
                try {
                    port = Integer.valueOf(args[0]);
                }catch (NumberFormatException e){
                    System.out.println("请传入正确的端口格式！！！");
                }
            }
        }
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setHostname("0.0.0.0");
        tomcat.setBaseDir(".");
        // tomcat 添加webapp
        StandardContext context = (StandardContext) tomcat.addWebapp(
                "/", System.getProperty("user.dir") + File.separator +
                        "src/main/webapp");
        // 设置热加载
        context.setReloadable(true);
        // 上下文监听器
        context.addLifecycleListener(new AprLifecycleListener());

        // 开始加载class中的servlet，filter，listener等资源
        String classDir = System.getProperty("user.dir") + File.separator + "target/classes";
        // 设置web资源
        WebResourceRoot root = new StandardRoot(context);
        // 添加目录资源集
        root.addPreResources(new DirResourceSet(root, "/WEB-INF/classes", classDir,"/"));
        // 设置到上下文
        context.setResources(root);

        // 启动tomcat
        tomcat.start();
        tomcat.getServer().await();
    }
    
}
