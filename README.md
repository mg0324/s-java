<!-- 引入 layui.css -->
<link href="//unpkg.com/layui@2.7.6/dist/css/layui.css" rel="stylesheet">

<style type="text/css">
.layui-row{
    display: flex;
    flex-flow: row wrap;
    align-content: space-between;
}
.layui-row a{
    color: white;
}
.layui-row a:hover{
    text-decoration:underline;
}
.layui-row div{
    border: 1px solid gray;
    height:50px;
    display: flex;
    flex-flow: row wrap;
    align-content: center;
    justify-content: center;
    border-radius: 5px;
    margin-bottom: 5px;
    margin-right: 5px;
}
.layui-row .has {
    background-color: green;
    color: white;
}

.layui-row .doing {
    background-color: blue;
    color: white;
}

.layui-row .no {
    background-color: white;
    color: black;
}
</style>

<div id="container" class="layui-container">
    <fieldset class="layui-elem-field" style="padding: 10px;" v-for="(item,index) in nodes">
        <legend>{{item.moduleName}}</legend>
        <div class="layui-row">
            <div v-if="status(part) == '1'" class="layui-col-xs12 layui-col-sm12 layui-col-md2 has" v-for="(part,index) in item.parts">
                <a :href="theHref(part)">{{theName(part)}}</a>
            </div>
            <div v-else-if="status(part) == '2'" class="layui-col-xs12 layui-col-sm12 layui-col-md2 doing">
                <a :href="theHref(part)">{{theName(part)}}</a>
            </div>
            <div v-else class="layui-col-xs12 layui-col-sm12 layui-col-md2 no">
                    {{theName(part)}}
                </div>
            </div>
    </fieldset>
    <div style="text-align:right;color:gray;">
        蓝色 - 进行中<br/>
        绿色 - 完　成<br/>
        白色 - 待修行<br/>
    </div>
</div>

<script>
    (function(){
         new Vue({
            el:'#container',
            data() {
                return {
                    nodes: [
                        {
                            moduleName: '微服务',
                            parts:['Spring Cloud','Dubbo(java)']
                        },
                        {
                            moduleName: '源码阅读',
                            parts:['JDK相关','Spring','Netty','Zookeeper']
                        },
                        {
                            moduleName: 'Java调优',
                            parts:['MySQL调优','JVM调优','Tomcat调优','线程池调优']
                        },
                        {
                            moduleName: '数据库',
                            parts:['MySQL','Oracle','PostgreSQL','Sqlite']
                        },
                        {
                            moduleName: '框架',
                            parts:['Spring','Spring Boot','Mybatis','Mybatis Plus','Netty']
                        },
                        {
                            moduleName: 'Java核心',
                            parts:['Java基础和面向对象@1@#/java/base','Java Web@1@#/java/web','Java进阶集合框架@2@#/java/collection','Java进阶IO框架@2@#/java/io','Java进阶高并发@1@#/java/juc','Java进阶虚拟机@1@#/java/jvm']
                        }
                    ]
                };
            },
            methods: {
                theName(v){
                    return v.split('@')[0];
                },
                theHref(v){
                    return v.split('@')[2];
                },
                status(v){
                    return v.split('@')[1];
                }
            }
        });
    })();
</script>