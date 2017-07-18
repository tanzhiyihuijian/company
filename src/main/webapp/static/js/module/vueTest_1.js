var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!'
    }
})

var app2 = new Vue({
    el: '#app-2',
    data: {
        message: '页面加载于' + new Date()
    }
})

var app3 = new Vue({
    el: '#app-3',
    data: {
        seen: true
    }
})

var app4 = new Vue({
    el: '#app-4',
    data: {
        todos: [
            {text: '学习 Java Script'},
            {text: '学习 Vue'},
            {text: '整个牛项目'}
        ]
    }
})

var app6 = new Vue({
    el: '.container',
    data: {
        specInfo: [
            {
                "specId": "1",
                "specName": "颜色",
                "children": [
                    {"label": "白色", "value": "44"},
                    {"label": "黑色", "value": "45"}
                ],
                "multiple": 1
            },
            {
                "specId": "2",
                "specName": "尺寸",
                "children": [
                    {
                        "label": "18x14x20cm",
                        "value": "603"
                    }
                ],
                "multiple": 1
            }
        ]
    },

    created: function () {
        for (var i = 0; i < this.specInfo.length; i++) {
            var item = this.specInfo[i].children;
            if (item.length == 1) {
                // item[0].chooseAttr(0, item.value, item.label);
                item[0].label = item[0].label + "hahaha";
            }
        }
    },


})


var app5 = new Vue({
    el: '#app-5',
    data: {
        message: 'Hello Vue.js !'
    },
    methods: {
        reverseMessage: function () {
            this.message = this.message.split('').reverse().join('')
        }
    }
});


// 定义名为 todo-item 的新组件
Vue.component('todo-item', {
        // todo-item 组件现在接受一个 "prop", 类似于一个自定义属性, 这个属性名为 todo
        props: ['todo'],
        template: '<li>{{todo.text}}</li>'
    }
);

var app7 = new Vue({
        el: '#app-7',
        data: {
            msg: '这是一条提示',
            groceryList: [
                {id: 0, text: '蔬菜'},
                {id: 1, text: '奶酪'},
                {id: 2, text: '随便什么人吃的东西'}
            ]
        }

    }
);

















