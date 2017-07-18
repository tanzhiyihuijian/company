<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/7/13 0013
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VueTest_1.jsp</title>

    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/vue.js"></script>

</head>
<body>

    <%--声明式渲染--%>

    <div id="app">
        {{message}}
    </div>

    <%--
        v-bind: 将这个元素节点的 title属性和 Vue实例的 message属性保持一致
    --%>
    <div id="app-2">
        <span v-bind:title="message">
            鼠标悬停几秒钟查看此处动态绑定的提示信息!
        </span>
    </div>

    <%--条件
        v-if: 切换一个元素的显示
    --%>
    <div id="app-3">
        <p v-if="seen">现在你看到我了</p>
    </div>

    <%--循环
        vue-for指令: 可以绑定数组的数据来渲染一个项目列表
    --%>
    <div id="app-4">
        <ol>
            <li v-for="todo in todos">
                {{todo.text}}
            </li>
        </ol>
    </div>

    <%--处理用户输入
        vue-on指令: 绑定一个事件监听器
    --%>
    <div id="app-5">
        <p>{{message}}</p>
        <button v-on:click="reverseMessage">逆转消息</button>
    </div>


    <div class="container">
        <div v-for="(spec, key) in specInfo">
            <h5>{{spec.specName}}</h5>
            <ul>
                <li v-for="(s, key) in spec.children">
                    {{s.label}}
                </li>
            </ul>
        </div>
    </div>


    <div id="app-7">
        <ol>
            <%--创建一个 todo-item组件的实例--%>
            <%--
                现在我们为每个 todo-item提供待办项对象, 待办项对象是变量, 即其内容可以是动态的.
                我们也需要为每个组件提供一个 "key", 晚些时候我们会做个解释
            --%>
            <todo-item
                v-for = "item in groceryList"
                v-bind:todo = "item"
                v-bind:key = "item.id" >
            </todo-item>
        </ol>

        <span>Message: {{msg}}</span>

        <div></div>

    </div>








    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/module/vueTest_1.js"></script>

</body>
</html>
