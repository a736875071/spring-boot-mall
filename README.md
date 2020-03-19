
项目来源: https://github.com/macrozheng/mall-learning
演示地址: http://www.macrozheng.com/admin/index.html
        admin/macro123
根据自己的习惯抄了下项目

搭建环境记录问题
1.习惯将mapper和xml写在一起,所以我喜欢在pom文件中添加
<build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.xml</include>
                </includes>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
            </resource>
        </resources>
    </build>
 这样就不用在新增其他的配置
 
2.集成swagger-ui,习惯使用 swagger-bootstrap-ui 感觉界面更好看
 可以参考 : https://blog.csdn.net/X_Xian_/article/details/82969105
    2.1 增加 pom
     <!--        swagger-->
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger2</artifactId>
                <version>2.9.2</version>
            </dependency>
            <dependency>
                <groupId>com.github.xiaoymin</groupId>
                <artifactId>swagger-bootstrap-ui</artifactId>
                <version>1.9.4</version>
            </dependency>
     2.2 增加SwaggerConfig配置,重写
      @Override
         public void addResourceHandlers(ResourceHandlerRegistry registry) {
             registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
             registry.addResourceHandler("swagger-ui.html")
                 .addResourceLocations("classpath:/META-INF/resources/");
             registry.addResourceHandler("doc.html")
                 .addResourceLocations("classpath:/META-INF/resources/");
             registry.addResourceHandler("/webjars/**")
                 .addResourceLocations("classpath:/META-INF/resources/webjars/");
             super.addResourceHandlers(registry);
         }
      如果不重写 访问 ip:port/doc.html 会有404

3.集成jwt,将JwtAuthenticationTokenFilter中需要在Authorization 的token前加Bearer 删除

4.集成elasticsearch-6.2.2,kibana-6.2.2-windows-x86_64, 
    下载地址
        https://mirrors.huaweicloud.com/elasticsearch/6.2.2/
        https://repo.huaweicloud.com/kibana/6.2.2/
   启动 elasticsearch-6.2.2/bin elasticsearch.bat
        kibana-6.2.2-windows-x86_64/bin kibana.bat
        
   http://localhost:5601 访问 kibana 页面
5.添加elasticsearch-head 插件（浏览器版）
    5.1 「 Chrome 浏览器网上应用商店」或者「 Firefox 附加组件」搜索 elasticsearch head
    5.2 安装插件后点击浏览器地址栏右侧「放大镜图标」，顶部输入框中的 localhost 修改为服务器地址即可查看 ES 服务状态
        http://localhost:9200/